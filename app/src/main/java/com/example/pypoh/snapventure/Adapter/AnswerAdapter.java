package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Chat;
import com.example.pypoh.snapventure.LevelPronounceFragment;
import com.example.pypoh.snapventure.Model.ChatModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

    private Context mContext;
    List<String> mDataSet = new ArrayList<>();

    private int selectedPosition = -1;
    private String selectedKey = "";

    public AnswerAdapter(Context mContext, List<String> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_answer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String key = mDataSet.get(position);
        final ChatModel message = LevelPronounceFragment.dataConversation.get(key);

        assert message != null;
        holder.answerMessage.setText(message.getMessage());
        if (key.equalsIgnoreCase(selectedKey)) {
            holder.layoutAnswer.setBackgroundResource(R.drawable.rounded_layout_yellow);
            holder.answerMessage.setTextColor(mContext.getResources().getColor(R.color.white));
        } else {
            holder.layoutAnswer.setBackgroundResource(R.drawable.rounded_layout_grey);
            holder.answerMessage.setTextColor(mContext.getResources().getColor(R.color.defaultTextColor));
        }

        // Setup Select Listener
        holder.layoutAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!key.equalsIgnoreCase(selectedKey)) {
                    selectedKey = key;
                } else {
                    selectedKey = "";
                }
                Chat.refreshData();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public String getSelectedAnswer() {
        return selectedKey;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout layoutAnswer;
        TextView answerMessage;
        ImageView voiceButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutAnswer = itemView.findViewById(R.id.layout_answer);
            answerMessage = itemView.findViewById(R.id.chat_answer);
            voiceButton = itemView.findViewById(R.id.chat_answer_voice);
        }
    }
}
