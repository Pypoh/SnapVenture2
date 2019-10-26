package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.Model.ModeModel;
import com.example.pypoh.snapventure.R;

import java.util.List;
import java.util.Objects;

public class ModeAdapter extends RecyclerView.Adapter<ModeAdapter.ViewHolder>{

    private Context mContext;
    private List<ModeModel> dataSet;
    private OnItemClickListener onItemClickListener;

    public ModeAdapter(Context mContext, List<ModeModel> dataSet) {
        this.mContext = mContext;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game_modes, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ModeModel modeData = dataSet.get(position);
        holder.bind(modeData, onItemClickListener);
        holder.modeText.setText(modeData.getModeName());
        switch (modeData.getMode()) {
            case 1:
                holder.modeImage.setImageResource(R.drawable.play_snap);
                break;
            case 2:
                holder.modeImage.setImageResource(R.drawable.play_pronounce);
                break;
            case 3:
                holder.modeImage.setImageResource(R.drawable.play_quiz);
                break;
        }

        holder.modeDesc.setText(modeData.getModeDesc());

//        holder.modeCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                toModePlay(modeData.getMode());
//            }
//        });
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public interface OnItemClickListener {
        void onItemClick(ModeModel modeModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView modeImage;
        private TextView modeText;
        private TextView modeDesc;

        private CardView modeCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            modeImage = itemView.findViewById(R.id.image_mode);
            modeText = itemView.findViewById(R.id.text_mode);
            modeDesc = itemView.findViewById(R.id.text_mode_desc);

            modeCard = itemView.findViewById(R.id.card_mode);
        }

        public void bind(final ModeModel modeModel, final OnItemClickListener listener) {
            modeCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(modeModel);
                }
            });
        }
    }
}
