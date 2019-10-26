package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Model.LessonModel;
import com.example.pypoh.snapventure.R;

import java.util.List;

public class LessonTitleAdapter extends RecyclerView.Adapter<LessonTitleAdapter.ViewHolder> {

    private Context mContext;
    private List<LessonModel> mDataSet;
    private OnItemClickListener onItemClickListener;

    public LessonTitleAdapter(Context mContext, List<LessonModel> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson_title, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson_title_completed, parent, false);
                break;
            default:
        }
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataSet.get(position).getProgress() == 100) {
            return 1; // completed
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LessonModel lessonData = mDataSet.get(position);
        holder.bind(lessonData, onItemClickListener);

        holder.lessonImage.setImageResource(lessonData.getImage());
        holder.lessonText.setText(lessonData.getLessonNames());
        holder.lessonDesc.setText(lessonData.getLessonDesc());

    }

    @Override
    public int getItemCount() {
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
        private TextView lessonText;
        private TextView lessonDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lessonCard = itemView.findViewById(R.id.lesson_card);
            lessonImage = itemView.findViewById(R.id.lesson_image_title);
            lessonText = itemView.findViewById(R.id.lesson_text_title);
            lessonDesc = itemView.findViewById(R.id.lesson_text_desc);

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
