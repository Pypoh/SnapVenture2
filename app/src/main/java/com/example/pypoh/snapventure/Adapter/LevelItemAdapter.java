package com.example.pypoh.snapventure.Adapter;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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

public class LevelItemAdapter extends RecyclerView.Adapter<LevelItemAdapter.ViewHolder>{

    private Context mContext;
    private List<LevelModel> dataSet = new ArrayList<>();

    public LevelItemAdapter(Context mContext, List<LevelModel> dataSet) {
        this.mContext = mContext;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_level, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LevelItemAdapter.ViewHolder holder, int position) {
        holder.levelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CardView levelCard;
        public ImageView levelImage;
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
        }
    }

    private void createDialog() {
        final Dialog stageDialog = new Dialog(mContext);
        stageDialog.setContentView(R.layout.dialog_stage);
        stageDialog.show();

        Button startButton = stageDialog.findViewById(R.id.dialog_stage_btn_start);
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
            ActivityCompat.requestPermissions((Activity) mContext, new String[] {Manifest.permission.CAMERA}, 100);
            mContext.startActivity(toCamera);
    }
}
