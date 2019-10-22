package com.example.pypoh.snapventure.MainMenu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pypoh.snapventure.Adapter.LessonAdapter;
import com.example.pypoh.snapventure.Model.LessonModel;
import com.example.pypoh.snapventure.Model.UserModel;
import com.example.pypoh.snapventure.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class LessonFragment extends Fragment{

    private List<LessonModel> lessonsData = new ArrayList<>();
    private List<LessonModel> eventLessonsData = new ArrayList<>();

    private RecyclerView lessonRecycler;
    private LessonAdapter lessonAdapter;

    private RecyclerView eventLessonRecycler;
    private LessonAdapter eventLessonAdapter;

    private List<UserModel> userMainData = new ArrayList<>();

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseFirestore db;

    private View view;
    public LessonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_lesson, container, false);

        setupViews(view);
        if (!userMainData.isEmpty()) {
            setupHeader(view);
        }

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        if (mUser != null) {
            getUserData();
        }

        lessonsData.add(new LessonModel(null, 1, 30f));
//        lessonsData.add(new LessonModel(null, 2, 30f));

        lessonAdapter = new LessonAdapter(getContext(), lessonsData);
        lessonRecycler.setAdapter(lessonAdapter);

        eventLessonAdapter = new LessonAdapter(getContext(), eventLessonsData);
        eventLessonRecycler.setAdapter(eventLessonAdapter);

        return view;
    }

    private void setupViews(View view) {
        lessonRecycler = view.findViewById(R.id.recycler_lessons);
        lessonRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        eventLessonRecycler = view.findViewById(R.id.recycler_event_lesson);
        eventLessonRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupHeader(View view) {
        final TextView username = view.findViewById(R.id.text_user_name);
        final TextView userlevel = view.findViewById(R.id.text_user_level);
        username.setText(userMainData.get(0).getName());
    }

    private void getUserData() {
        DocumentReference userRef = db.collection("users").document(mUser.getUid());
        userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                UserModel userData = documentSnapshot.toObject(UserModel.class);
                userMainData.add(userData);
                setupHeader(view);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
//        setupHeader(view);
    }
}
