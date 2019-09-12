package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Model.LevelModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {

    private Context mContext;
    private List<LevelModel> dataSet = new ArrayList<>();

    public LevelAdapter(Context mContext, List<LevelModel> dataSet) {
        this.mContext = mContext;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public LevelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LevelAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CardView levelCard;
        public ImageView levelImage;
        public RecyclerView levelRecycler;
        public LevelItemAdapter levelItemAdapter;

        List<LevelModel> tempData = new ArrayList<>();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tempData.add(new LevelModel());
            tempData.add(new LevelModel());

            levelItemAdapter = new LevelItemAdapter(mContext, tempData);
            levelRecycler = itemView.findViewById(R.id.item_recycler_parent);
            levelRecycler.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
            levelRecycler.setAdapter(levelItemAdapter);
//            levelCard = itemView.findViewById(R.id.card_level);
//            levelImage = itemView.findViewById(R.id.image_level);
        }
    }

}
