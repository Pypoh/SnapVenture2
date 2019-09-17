package com.example.pypoh.snapventure;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

import com.example.pypoh.snapventure.Helper.InternetCheck;
import com.example.pypoh.snapventure.Model.LevelModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions;
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

    // Animation
    private Animation slideLeft;
    private Animation slideRight;

    private LevelModel dataSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // Get Data
        dataSet = (LevelModel) getIntent().getSerializableExtra("dataClass");

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
        riddlesTextSwitch.setInAnimation(slideLeft);
        riddlesTextSwitch.setOutAnimation(slideRight);

        // Get nanti posisi
//        riddlesTextSwitch.setText(dataSet.getRiddle().get(0)[0]);
        riddlesTextSwitch.setText("TESSSSSSSSSSSSS SSSSSSSSSSS SSSSSSSSSSSSSSS SSSSSSSS SSSSSSSSSS SSSSS SSSSSSS SSSST");


        final int[] count = {1};

        passText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                riddlesTextSwitch.setText("Test : " + count[0]);
                count[0]++;
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

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cameraView.takePicture();
                changeQuestionState();
                createDialog();
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

    private void createDialog() {
        resultDialog = new Dialog(this);
        resultDialog.setContentView(R.layout.dialog_result);

        resultDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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


        Button nextButton = resultDialog.findViewById(R.id.button_result_ok);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultDialog.dismiss();
            }
        });

    }

    private void checkImage(Bitmap bitmap) {
        final FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);

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
