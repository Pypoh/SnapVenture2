package com.example.pypoh.snapventure.Adapter;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Camera;
import com.example.pypoh.snapventure.Model.LevelModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;

public class LevelItemAdapter extends RecyclerView.Adapter<LevelItemAdapter.ViewHolder> {

    private Context mContext;
    private List<LevelModel> dataSet = new ArrayList<>();
    private LevelModel mData;
    private View view;

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

        ViewStub viewStub = view.findViewById(R.id.viewstub_level);

        if (mData.getStar() == 1) {
            viewStub.setLayoutResource(R.layout.level_1_star);
            viewStub.inflate();
        } else if (mData.getStar() == 2) {
            viewStub.setLayoutResource(R.layout.level_2_star);
            viewStub.inflate();
        } else {
            viewStub.setLayoutResource(R.layout.level_3_star);
            viewStub.inflate();
        }

        holder.levelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });
        holder.levelProgressBar.setMax(5);
        holder.levelProgressBar.setProgress(3);
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
//        public RecyclerView itemRecycler;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            itemRecycler = itemView.findViewById(R.id.recycler_level);
//
//            levelItemAdapter = new LevelItemAdapter(mContext, tempData);
//            levelRecycler = itemView.findViewById(R.id.item_recycler_parent);
//            levelRecycler.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
//            levelRecycler.setAdapter(levelItemAdapter);

            levelCard = itemView.findViewById(R.id.card_level);
            levelImage = itemView.findViewById(R.id.image_level);
            levelProgressBar = itemView.findViewById(R.id.custom_progress_bar_level);



        }
    }

    private void createDialog() {
        final Dialog stageDialog = new Dialog(mContext);
        stageDialog.setContentView(R.layout.dialog_stage);
        stageDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialogStageList = stageDialog.findViewById(R.id.dialog_stage_list);
        dialogStageList.setLayoutManager(new LinearLayoutManager(mContext));
        stageDialogAdapter = new StageDialogAdapter(mContext, mData, new StageDialogAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(LevelModel levelModel, int position) {
                if (!stageDialogAdapter.isSelected(position)) {
                    stageDialogAdapter.setSelected(stageDialogAdapter.getPositionChecked(), false);
                    stageDialogAdapter.setSelected(position, true);
                    stageDialogAdapter.setPositionChecked(position);
                    stageDialogAdapter.notifyDataSetChanged();
                    selectedStatus = true;
                    setStartButtonEnabled();
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
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCamera();
            }
        });
    }

    private void toCamera() {
        Intent toCamera = new Intent(mContext, Camera.class);
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CAMERA}, 100);
        mContext.startActivity(toCamera);
    }
}
