package com.example.pypoh.snapventure.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Model.LevelModel;
import com.example.pypoh.snapventure.R;

import java.util.List;

public class StageDialogAdapter extends RecyclerView.Adapter<StageDialogAdapter.ViewHolder> {

    private Context mContext;
    private LevelModel mData;

    private int positionChecked;
    private OnItemClickListener OnItemClickListener;

    public StageDialogAdapter(Context mContext, LevelModel mData, StageDialogAdapter.OnItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.mData = mData;
        OnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_stage, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(mData, OnItemClickListener, position);
        // Set Completed Star per Stage
        List<Boolean[]> totalStarCompleted = mData.getTotalCompletedStar();
        Boolean[] statusCompleted = totalStarCompleted.get(position);
        int totalStar = 0;
        // Count Total Star
        for (Boolean status : statusCompleted) {
            if (status) totalStar++;
        }
        switch (totalStar) {
            case 1:
                holder.star1.setImageResource(R.drawable.stage_star_bronze);
                break;
            case 2:
                if (mData.getSelected()[position]) {
                    holder.star1.setImageResource(R.drawable.stage_star_silver_fix);
                    holder.star2.setImageResource(R.drawable.stage_star_silver_fix);
                } else {
                    holder.star1.setImageResource(R.drawable.stage_star_silver);
                    holder.star2.setImageResource(R.drawable.stage_star_silver);
                }
                break;
            case 3:
                holder.star1.setImageResource(R.drawable.stage_star_gold);
                holder.star2.setImageResource(R.drawable.stage_star_gold);
                holder.star3.setImageResource(R.drawable.stage_star_gold);
                break;
            default:
        }

        if (mData.getSelected()[position]) {
            holder.stageNumber.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            holder.itemLayout.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        } else {
            holder.stageNumber.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.itemLayout.setBackgroundColor(mContext.getResources().getColor(R.color.transparent));
        }

        holder.stageNumber.setText("Stage " + (position+1));
    }

    @Override
    public int getItemCount() {
        return mData.getRiddle().size();
    }

    public interface OnItemClickListener {
        void onItemClick(LevelModel levelModel, int position);
    }

    public int getPositionChecked() {
        return positionChecked;
    }

    public void setPositionChecked(int positionChecked) {
        this.positionChecked = positionChecked;
    }

    public void setSelected(int position, boolean input) {
        mData.setSelected(position, input);
    }

    public boolean isSelected(int position) {
        return mData.getSelected()[position];
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout itemLayout;
        private TextView stageNumber;
        private ImageView star1;
        private ImageView star2;
        private ImageView star3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemLayout = itemView.findViewById(R.id.layout_item_dialog);
            stageNumber = itemView.findViewById(R.id._text_dialog_stage_stage_number);
            star1 = itemView.findViewById(R.id.star_dialog_1);
            star2 = itemView.findViewById(R.id.star_dialog_2);
            star3 = itemView.findViewById(R.id.star_dialog_3);
        }

        public void bind(final LevelModel levelModel, final OnItemClickListener listener, final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(levelModel, position);
                }
            });
        }
    }
}
