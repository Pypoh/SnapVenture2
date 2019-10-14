package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Chat;
import com.example.pypoh.snapventure.Model.ChapterModel;
import com.example.pypoh.snapventure.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChapterRecyclerAdapter extends RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<ChapterModel> mDataSet = new ArrayList<>();

    public ChapterRecyclerAdapter(Context mContext, List<ChapterModel> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pronounce_chapter_locked, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pronounce_chapter_complete, parent, false);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pronounce_chapter_incomplete, parent, false);
                break;
            default:
        }
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSet.get(position).getLockStatus();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ChapterModel data = mDataSet.get(position);
        holder.chapterNumberText.setText(data.getChapterNumber() + "");
        holder.chapterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent toChat = new Intent(mContext, Chat.class);
                    toChat.putExtra("chapterNumber", data.getChapterNumber());
//                toChat.putExtra("dataState", (Serializable) data.getStateData());
//                toChat.putExtra("dataConversation", (Serializable) data.getConversationData());
                    mContext.startActivity(toChat);
                } else {
                    Toast.makeText(mContext, "Under Development, Available: Chapter One", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView chapterNumberText;
        private ConstraintLayout chapterLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            chapterLayout = itemView.findViewById(R.id.chapter_layout);
            chapterNumberText = itemView.findViewById(R.id.chapter_number);
        }
    }
}
