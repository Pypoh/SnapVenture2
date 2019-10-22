package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Model.LessonModel;
import com.example.pypoh.snapventure.R;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder>{

    private Context mContext;
    private List<LessonModel> mDataSet;

    public LessonAdapter(Context mContext, List<LessonModel> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mDataSet.size() > 2) {
            return 2;
        }
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView lessonImage;
        private TextView lessonNumber;
        private TextView lessonProgressText;
        private ProgressBar lessonProgressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
