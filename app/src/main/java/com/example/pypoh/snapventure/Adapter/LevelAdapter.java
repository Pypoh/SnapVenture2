package com.example.pypoh.snapventure.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Camera;
import com.example.pypoh.snapventure.Fragment.LevelFragment;
import com.example.pypoh.snapventure.Model.LevelModel;
import com.example.pypoh.snapventure.R;

import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<LevelModel> dataSet;

    public LevelAdapter(Context mContext, List<LevelModel> dataSet) {
        this.mContext = mContext;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snap_level_header, parent, false);
                return new headerViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snap_stage, parent, false);
                return new itemViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (dataSet.get(position).isHeader()) {
            return 1; // 1 = header;
        }
        return 2; // 2 = items
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final LevelModel levelData = dataSet.get(position);
        switch (holder.getItemViewType()) {
            case 1:
                headerViewHolder headerViewHolder = (headerViewHolder) holder;
                // Set Star Count Image
                switch (levelData.getLevel()) {
                    case 1:
                        if (!levelData.isLockStatus()) {
                            headerViewHolder.headerImage.setImageResource(R.drawable.play_level1_on);
                        } else {
                            headerViewHolder.headerImage.setImageResource(R.drawable.play_level1_off);
                        }
                        break;
                    case 2:
                        if (!levelData.isLockStatus()) {
                            headerViewHolder.headerImage.setImageResource(R.drawable.play_level2_on);
                        } else {
                            headerViewHolder.headerImage.setImageResource(R.drawable.play_level2_off);
                        }
                        break;
                    case 3:
                        if (!levelData.isLockStatus()) {
                            headerViewHolder.headerImage.setImageResource(R.drawable.play_level3_on);
                        } else {
                            headerViewHolder.headerImage.setImageResource(R.drawable.play_level3_off);
                        }
                        break;
                }

                // Set tittle and star
                headerViewHolder.headerTitle.setText(levelData.getLevelName());

                int currentStar = levelData.getStar();
                int totalStar = levelData.getTotalStar();

                headerViewHolder.headerStars.setText(currentStar + "/" + totalStar);

                break;

            case 2:
                itemViewHolder itemViewHolder = (itemViewHolder) holder;

                itemViewHolder.textStageNumber.setText("Stage " + levelData.getStageNumber());

                // Check Stars
                int totalStageStar = 0;
                boolean[] statusStar = levelData.getTotalCompletedStar().get(0);
                // Count total star
                for (boolean status : statusStar) {
                    Log.d("totalStageStarStatus", status + "");
                    if (status) {
                        totalStageStar++;
                        Log.d("totalStageStar", totalStageStar + "");
                    }
                }
                // Set Stars Images
                switch (totalStageStar) {
                    case 1:
                        itemViewHolder.star1.setImageResource(R.drawable.stage_star_bronze);
                        break;
                    case 2:
                        itemViewHolder.star1.setImageResource(R.drawable.stage_star_silver_fix);
                        itemViewHolder.star2.setImageResource(R.drawable.stage_star_silver_fix);
//                            holder.star1.setImageResource(R.drawable.stage_star_silver);
//                            holder.star2.setImageResource(R.drawable.stage_star_silver);
                        break;
                    case 3:
                        itemViewHolder.star1.setImageResource(R.drawable.stage_star_gold);
                        itemViewHolder.star2.setImageResource(R.drawable.stage_star_gold);
                        itemViewHolder.star3.setImageResource(R.drawable.stage_star_gold);
                        break;
                    default:
                }

                // OnClick Listener
                itemViewHolder.stageLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toCameraPassData(levelData, position);
                    }
                });

                break;
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class headerViewHolder extends RecyclerView.ViewHolder {

//        public RecyclerView levelRecycler;
//        public LevelItemAdapter levelItemAdapter;

        private ImageView headerImage;
        private TextView headerTitle;
        private TextView headerStars;

        public headerViewHolder(@NonNull View itemView) {
            super(itemView);

            headerImage = itemView.findViewById(R.id.adventure_stage_image);
            headerTitle = itemView.findViewById(R.id.adventure_stage_title);
            headerStars = itemView.findViewById(R.id.adventure_stage_stars);

        }

//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            levelRecycler = itemView.findViewById(R.id.item_recycler_parent);
//            levelRecycler.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
//            levelRecycler.setNestedScrollingEnabled(false);
//
//        }
    }

    public class itemViewHolder extends RecyclerView.ViewHolder {

        private View statusLine;
        private TextView textStageNumber;
        private ImageView star1;
        private ImageView star2;
        private ImageView star3;
        private ConstraintLayout stageLayout;

        public itemViewHolder(@NonNull View itemView) {
            super(itemView);

            statusLine = itemView.findViewById(R.id.status_line);
            textStageNumber = itemView.findViewById(R.id.text_stage_number);
            star1 = itemView.findViewById(R.id.star_dialog_1);
            star2 = itemView.findViewById(R.id.star_dialog_2);
            star3 = itemView.findViewById(R.id.star_dialog_3);
            stageLayout = itemView.findViewById(R.id.adventure_layout_stage);


        }
    }

    private void toCameraPassData(LevelModel dataSet, int position) {
//        startButton.setEnabled(false);
        Intent toCamera = new Intent(mContext, Camera.class);
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CAMERA}, 100);
        toCamera.putExtra("dataSet", dataSet);
        toCamera.putExtra("position", position);
        mContext.startActivity(toCamera);
    }

}
