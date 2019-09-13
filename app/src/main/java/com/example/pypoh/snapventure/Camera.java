package com.example.pypoh.snapventure;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pypoh.snapventure.Helper.InternetCheck;
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
    private Button captureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // Get Ids
        cameraView = findViewById(R.id.camera_view);
        cameraView.setLifecycleOwner(this);
        captureButton = findViewById(R.id.snap_btn);

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.takePicture();
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
