package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Model.BattleModel;
import com.example.pypoh.snapventure.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BattleAdapter extends RecyclerView.Adapter<BattleAdapter.ViewHolder>{

    private Context mContext;
    private List<BattleModel> mDataBattle;

    public BattleAdapter(Context mContext, List<BattleModel> mDataBattle) {
        this.mContext = mContext;
        this.mDataBattle = mDataBattle;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_battle, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BattleModel battleData = mDataBattle.get(position);
        holder.nameBattle.setText(battleData.getName());
        holder.scoreBattle.setText(battleData.getScore1() + " : " + battleData.getScore2());
        holder.resultBattle.setText(battleData.getResult());

        switch (battleData.getStatus()) {
            case 1:
                holder.resultBattle.setTextColor(mContext.getResources().getColor(R.color.garden_green));
                holder.statusBattle.setBackgroundColor(mContext.getResources().getColor(R.color.garden_green));
                break;
            case 2:
                holder.resultBattle.setTextColor(mContext.getResources().getColor(R.color.classroom_red));
                holder.statusBattle.setBackgroundColor(mContext.getResources().getColor(R.color.classroom_red));
                break;
            case 3:
                break;
            case 0:
                holder.resultBattle.setText("");
        }
    }

    @Override
    public int getItemCount() {
        if (mDataBattle.size() > 3) {
            return 3;
        }
        return mDataBattle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View statusBattle;
        private CircleImageView profilePicBattle;
        private TextView nameBattle;
        private TextView scoreBattle;
        private TextView resultBattle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            statusBattle = itemView.findViewById(R.id.status_battle);
            profilePicBattle = itemView.findViewById(R.id.profile_image_battle);
            nameBattle = itemView.findViewById(R.id.name_battle);
            scoreBattle = itemView.findViewById(R.id.score_battle);
            resultBattle = itemView.findViewById(R.id.result_battle);
        }
    }
}
