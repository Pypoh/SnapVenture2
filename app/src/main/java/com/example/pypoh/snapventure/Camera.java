package com.example.pypoh.snapventure;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.pypoh.snapventure.Fragment.LevelFragment;
import com.example.pypoh.snapventure.Helper.InternetCheck;
import com.example.pypoh.snapventure.Model.LevelModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabeler;
import com.otaliastudios.cameraview.BitmapCallback;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureAction;

import java.util.List;

public class Camera extends AppCompatActivity {


    // Content
    private CameraView cameraView;
    private ImageView captureButton;
    private ImageView questionButton;
    private ImageView hintButton;
    private ConstraintLayout snapLayout;
    private TextView passText;

    private LinearLayout questionLayout;

    // Result Dialog
    private Dialog resultDialog;
    private TextSwitcher riddlesTextSwitch;

    // Final Result Dialog
    private Dialog finalResultDialog;

    // Animation
    private Animation slideLeft;
    private Animation slideRight;

    private LevelModel dataSet;

    private int state = 0;
    private Boolean[] statusRiddle;

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // Get Data
        dataSet = (LevelModel) getIntent().getSerializableExtra("dataClass");
        statusRiddle = new Boolean[dataSet.getTotalCompletedStar().get(position).length];
        position = getIntent().getIntExtra("position", 0);

        // Get Ids
        cameraView = findViewById(R.id.camera_view);
        cameraView.setLifecycleOwner(this);
        captureButton = findViewById(R.id.snap_btn);
        snapLayout = findViewById(R.id.snap_layout);
        questionButton = findViewById(R.id.camera_question_button);
        questionLayout = findViewById(R.id.question_popup);
        hintButton = findViewById(R.id.camera_hint_button);
        passText = findViewById(R.id.text_pass_button);

        // Set Dialog Data
        riddlesTextSwitch = questionLayout.findViewById(R.id.riddles_text_popup);
        riddlesTextSwitch.setFactory(new ViewSwitcher.ViewFactory() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public View makeView() {
                TextView riddleText = new TextView(questionLayout.getContext());
                riddleText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                riddleText.setTextColor(getResources().getColor(R.color.white));
                riddleText.setTextSize(16);
                return riddleText;
            }
        });

        slideLeft = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        slideRight = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        riddlesTextSwitch.setInAnimation(slideRight);
        riddlesTextSwitch.setOutAnimation(slideLeft);

        // Get nanti posisi
        riddlesTextSwitch.setText(dataSet.getRiddle().get(position)[0]);

        // Pass Button
        passText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRiddle();
            }
        });

        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeQuestionState();
            }
        });

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Camera.this, "Hints are under development", Toast.LENGTH_SHORT).show();
            }
        });

        // Camera Button Click
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("stateProgress", state + "");
                if (state < dataSet.getRiddle().get(position).length) {
                    cameraView.takePicture();
                } else {
                    // Create Result Dialog & return to level
                }
                questionLayout.setVisibility(View.INVISIBLE);
//                changeQuestionState();
//                createResultDialog();
            }
        });

        cameraView.setLifecycleOwner(this);
        cameraView.mapGesture(Gesture.PINCH, GestureAction.ZOOM); // Pinch to zoom!
        cameraView.mapGesture(Gesture.TAP, GestureAction.AUTO_FOCUS); // Tap to focus!

        cameraView.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(@NonNull PictureResult result) {
                super.onPictureTaken(result);
                Log.i("Picture", "Picture Taken");
                result.toBitmap(new BitmapCallback() {
                    @Override
                    public void onBitmapReady(@Nullable Bitmap bitmap) {
                        checkImage(bitmap);
                        Log.i("Picture", "Bitmap Ready");
                    }
                });
            }
        });
    }

    private void changeRiddle() {
        increaseState(1);
        if (state < dataSet.getRiddle().get(position).length) {
            riddlesTextSwitch.setText(dataSet.getRiddle().get(position)[state]);
        }
        Log.d("stateProgress", this.state + "Change Riddle");
    }

    private void increaseState(int input) {
        if (state < dataSet.getRiddle().get(position).length) {
            state += input;
        }
        Log.d("stateProgress", state + "Change");
    }

    private void changeQuestionState() {
        final Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        final Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        if (questionLayout.getVisibility() == View.INVISIBLE) {
            questionLayout.setVisibility(View.VISIBLE);
            questionLayout.startAnimation(slideUp);
            Log.d("animationDebug", "SlideUp");
        } else {
            questionLayout.setVisibility(View.INVISIBLE);
            questionLayout.startAnimation(slideDown);
            Log.d("animationDebug", "SlideDown");
        }
    }

    @SuppressLint("SetTextI18n")
    private void createResultDialog(String result) {
        resultDialog = new Dialog(this);
        resultDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Setting Result
        if (result.equalsIgnoreCase("Success")) {
            resultDialog.setContentView(R.layout.dialog_result_success);
            Button nextButton = resultDialog.findViewById(R.id.button_result_ok);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resultDialog.dismiss();
                    Log.d("stateProgressResult", state + " : " + dataSet.getRiddle().get(position).length);
                    if (state == dataSet.getRiddle().get(position).length) {
                        // Create Final Result Dialog
                        createFinalResultDialog();
                    }
                    Log.d("resultDialog", "Result Button Pressed");
                }
            });
        } else {
            resultDialog.setContentView(R.layout.dialog_result_fail);
            Button nextButton = resultDialog.findViewById(R.id.button_result_ok);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resultDialog.dismiss();
                    Log.d("resultDialog", "Result Button Pressed");
                }
            });
        }

        resultDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                snapLayout.setVisibility(View.GONE);
                cameraView.close();
            }
        });

        resultDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                snapLayout.setVisibility(View.VISIBLE);
                cameraView.open();
            }
        });

        resultDialog.show();


    }

    private void createFinalResultDialog() {
        finalResultDialog = new Dialog(this);
        finalResultDialog.setContentView(R.layout.dialog_final_result);
        finalResultDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView resultBadge = finalResultDialog.findViewById(R.id.badge_result);
        Button doneButton = finalResultDialog.findViewById(R.id.btn_result_done);
        Button shareButton = finalResultDialog.findViewById(R.id.btn_result_share);

        int starCollected = 0;
        // Count result
        for (Boolean result : statusRiddle) {
            if (result) starCollected++;
        }

        switch (starCollected) {
            case 0:
                break;
            case 1:
                resultBadge.setImageResource(R.drawable.result_badge_bronze);
                break;
            case 2:
                resultBadge.setImageResource(R.drawable.result_badge_silver);
                break;
            case 3:
                resultBadge.setImageResource(R.drawable.result_badge_gold);
                break;
        }

        int level = dataSet.getLevel();

        // Nembak data ke LevelFragment
        LevelFragment.tempGardenDataset.get(level-1).setTotalCompletedStar(statusRiddle, position);
        LevelFragment.levelAdapter.notifyDataSetChanged();

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Camera.this, "Under Development", Toast.LENGTH_SHORT).show();
            }
        });

        finalResultDialog.show();

    }

    private void checkImage(Bitmap bitmap) {
        final FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        final boolean[] resultRiddle = {false};

        new InternetCheck(new InternetCheck.Consumer() {
            @Override
            public void accept(boolean internet) {
                if (internet) {
                    Log.i("Picture", "Internet Ready");
                    FirebaseVisionImageLabeler detectOnline = FirebaseVision.getInstance().getCloudImageLabeler();
                    detectOnline.processImage(image).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionImageLabel>>() {
                        @Override
                        public void onSuccess(List<FirebaseVisionImageLabel> firebaseVisionImageLabels) {
                            Log.i("Picture", "Vision Processing, Online");
                            for (FirebaseVisionImageLabel result : firebaseVisionImageLabels) {
                                Toast.makeText(Camera.this, "Result Online : " + result.getText(), Toast.LENGTH_SHORT).show();
                                Log.i("Picture", "Result Online Debug : " + result.getText() + " Confidence : " + result.getConfidence());
                                Log.d("resultImage", dataSet.getAnswer().get(position)[state] + "" + result.getText());
                                // Check Image
                                if (dataSet.getAnswer().get(position)[state].equalsIgnoreCase(result.getText())) {
                                    statusRiddle[state] = true;
                                    resultRiddle[0] = true;
                                    Log.d("resultImage", dataSet.getAnswer().get(position)[state] + "" + result.getText() + "Right Answer");
                                    break;
                                }
                            }
                            if (resultRiddle[0]) {
                                createResultDialog("Success");
                                changeRiddle();

                            } else {
                                createResultDialog("Fail");
                            }
                        }
                    });
                } else {
                    FirebaseVisionImageLabeler detect = FirebaseVision.getInstance().getOnDeviceImageLabeler();
                    detect.processImage(image).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionImageLabel>>() {
                        @Override
                        public void onSuccess(List<FirebaseVisionImageLabel> firebaseVisionImageLabels) {
                            Log.i("Picture", "Vision Processing, Offline");
                            for (FirebaseVisionImageLabel result : firebaseVisionImageLabels) {
                                Toast.makeText(Camera.this, "Result : " + result.getText(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.i("Picture", "Vision Failed : " + e.toString());
                        }
                    });
                }
            }
        });
    }

    private void finishActivity() {
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraView.destroy();
    }

    @Override
    public void recreate() {
        super.recreate();
    }
}
