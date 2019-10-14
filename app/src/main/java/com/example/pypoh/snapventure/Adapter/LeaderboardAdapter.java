package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Model.LeaderboardModel;
import com.example.pypoh.snapventure.R;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>{

    private Context mContext;
    private List<LeaderboardModel> mDataSet;

    public LeaderboardAdapter(Context mContext, List<LeaderboardModel> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaderboard, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LeaderboardModel data = mDataSet.get(position);

        switch (position) {
            case 0:
                holder.leaderNumber.setTextSize(24);
                holder.leaderNumber.setTextColor(mContext.getResources().getColor(R.color.gold_leaderboard));
                break;
            case 1:
                holder.leaderNumber.setTextSize(24);
                holder.leaderNumber.setTextColor(mContext.getResources().getColor(R.color.silver_leaderboard));
                break;
            case 2:
                holder.leaderNumber.setTextSize(24);
                holder.leaderNumber.setTextColor(mContext.getResources().getColor(R.color.bronze_leaderboard));
                break;
            default:
                break;
        }

        holder.leaderNumber.setText(data.getNumber() + "");
        holder.name.setText(data.getName() + "");
        holder.starCount.setText(data.getStarCount() + "");
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView leaderNumber, name, starCount;
        ImageView profilePic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            leaderNumber = itemView.findViewById(R.id.leaderboard_number);
            name = itemView.findViewById(R.id.leaderboard_name);
            starCount = itemView.findViewById(R.id.leaderboard_star_count);
        }
    }
}
