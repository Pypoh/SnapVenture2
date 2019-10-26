package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Model.LessonModel;
import com.example.pypoh.snapventure.Model.ModeModel;
import com.example.pypoh.snapventure.R;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder>{

    private Context mContext;
    private List<LessonModel> mDataSet;
    private OnItemClickListener onItemClickListener;

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
        LessonModel data = mDataSet.get(position);
        holder.bind(data, onItemClickListener);
        holder.lessonImage.setImageResource(data.getImage());
        holder.lessonName.setText(data.getLessonNames());
        holder.lessonProgressBar.setProgress(data.getProgress());
        holder.lessonProgressText.setText(data.getProgress() + "% completed");
    }

    @Override
    public int getItemCount() {
        if (mDataSet.size() > 3) {
            return 3;
        }
        return mDataSet.size();
    }

    public interface OnItemClickListener {
        void onItemClick(LessonModel lessonModel);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView lessonCard;
        private ImageView lessonImage;
        private TextView lessonName;
        private TextView lessonProgressText;
        private ProgressBar lessonProgressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lessonCard = itemView.findViewById(R.id.lesson_card);
            lessonImage = itemView.findViewById(R.id.lesson_image);
            lessonName = itemView.findViewById(R.id.text_lesson_name);
            lessonProgressText = itemView.findViewById(R.id.text_progress_lesson);
            lessonProgressBar = itemView.findViewById(R.id.progress_lesson);
        }

        public void bind(final LessonModel lessonModel, final OnItemClickListener listener) {
            lessonCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(lessonModel);
                }
            });
        }
    }


}
