package com.example.pypoh.snapventure.Adapter;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Camera;
import com.example.pypoh.snapventure.Model.LevelModel;
import com.example.pypoh.snapventure.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LevelItemAdapter extends RecyclerView.Adapter<LevelItemAdapter.ViewHolder> {

    private Context mContext;
    private List<LevelModel> dataSet = new ArrayList<>();
    private LevelModel mData;
    private View view;

    // Dataset
    List<LevelModel> data = new ArrayList<>();

    // Recycler Utils
    private RecyclerView dialogStageList;
    private StageDialogAdapter stageDialogAdapter;
    private Button startButton;
    private boolean selectedStatus;

    public LevelItemAdapter(Context mContext, List<LevelModel> dataSet) {
        this.mContext = mContext;
        this.dataSet = dataSet;
    }

    public LevelItemAdapter(Context mContext, LevelModel mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_level, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LevelItemAdapter.ViewHolder holder, int position) {
        List<Boolean[]> resultAllStar = mData.getTotalCompletedStar();
        Boolean[] resultData = mData.getTotalCompletedStar().get(position);
        ViewStub viewStub = view.findViewById(R.id.viewstub_level);

        // Count Total Star
        int totalStarInLevel = 0;
        for (Boolean[] starList : resultAllStar) {
            totalStarInLevel += starList.length;
        }

        // Count Collected Star
        int completedStage = 0;
        for (Boolean[] starList : resultAllStar) {
            for (Boolean resultStar : starList) {
                if (resultStar) completedStage++;
            }
        }

        holder.levelCount.setText(completedStage + "/" + totalStarInLevel);

        if (mData.getStar() == 1) {
            if (mData.isLockStatus()) {
                viewStub.setLayoutResource(R.layout.level_1_star);
            } else {
                viewStub.setLayoutResource(R.layout.level_1_star_locked);
            }
            viewStub.inflate();
        } else if (mData.getStar() == 2) {
            if (mData.isLockStatus()) {
                viewStub.setLayoutResource(R.layout.level_2_star);
            } else {
                viewStub.setLayoutResource(R.layout.level_2_star_locked);
            }
            viewStub.inflate();
        } else {
            if (mData.isLockStatus()) {
                viewStub.setLayoutResource(R.layout.level_3_star);
            } else {
                viewStub.setLayoutResource(R.layout.level_3_star_locked);
            }
            viewStub.inflate();
        }

        holder.levelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData.isLockStatus()) {
                    createDialog();
                } else {
                    Toast.makeText(mContext, "This Level is Locked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.levelProgressBar.setMax(totalStarInLevel);
        holder.levelProgressBar.setProgress(completedStage);
    }

    @Override
    public int getItemCount() {
        return mData.getStageCount();
    }

    private void setStartButtonDisabled() {
        startButton.setTextColor(mContext.getResources().getColor(R.color.white));
        startButton.setBackgroundResource(R.drawable.rounded_button_full_white_border);
        startButton.setEnabled(false);
    }

    private void setStartButtonEnabled() {
        startButton.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        startButton.setBackgroundResource(R.drawable.rounded_button_full_white_border_disabled);
        startButton.setEnabled(true);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView levelCard;
        ImageView levelImage;
        ProgressBar levelProgressBar;
        TextView levelCount;
//        public RecyclerView itemRecycler;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            levelCard = itemView.findViewById(R.id.card_level);
            levelImage = itemView.findViewById(R.id.image_level);
            levelProgressBar = itemView.findViewById(R.id.custom_progress_bar_level);
            levelCount = itemView.findViewById(R.id.level_count);
        }
    }

    public void createDialog() {
        final Dialog stageDialog = new Dialog(mContext);
        stageDialog.setContentView(R.layout.dialog_stage);
        stageDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView levelName = stageDialog.findViewById(R.id.dialog_stage_level_name);
        levelName.setText("Basic");

        data = new ArrayList<>();

        dialogStageList = stageDialog.findViewById(R.id.dialog_stage_list);
        dialogStageList.setLayoutManager(new LinearLayoutManager(mContext));
        stageDialogAdapter = new StageDialogAdapter(mContext, mData, new StageDialogAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(LevelModel levelModel, int position) {
                data.clear();
                if (!stageDialogAdapter.isSelected(position)) {
                    stageDialogAdapter.setSelected(stageDialogAdapter.getPositionChecked(), false);
                    stageDialogAdapter.setSelected(position, true);
                    stageDialogAdapter.setPositionChecked(position);
                    stageDialogAdapter.notifyDataSetChanged();
                    selectedStatus = true;
                    setStartButtonEnabled();
                    data.add(levelModel);
                    Log.i("SelectedStatus", "true");
                } else {
                    stageDialogAdapter.setSelected(position, false);
                    stageDialogAdapter.notifyDataSetChanged();
                    selectedStatus = false;
                    setStartButtonDisabled();
                    Log.i("SelectedStatus", "false");
                }
            }
        });
        dialogStageList.setAdapter(stageDialogAdapter);
        stageDialog.show();

        startButton = stageDialog.findViewById(R.id.dialog_stage_btn_start);
        setStartButtonDisabled();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!data.isEmpty()) {
                    stageDialog.dismiss();
                    toCamera();
                }
            }
        });

        stageDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                setAllStageHighlightOff();
            }
        });
    }

    private void setAllStageHighlightOff() {
        selectedStatus = false;
        stageDialogAdapter.setSelected(stageDialogAdapter.getPositionChecked(), false);
        stageDialogAdapter.notifyDataSetChanged();
    }

    private void toCamera() {
//        startButton.setEnabled(false);
        Intent toCamera = new Intent(mContext, Camera.class);
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CAMERA}, 100);
        toCamera.putExtra("dataClass", data.get(0));
        toCamera.putExtra("position", stageDialogAdapter.getPositionChecked());
        mContext.startActivity(toCamera);
    }

}
