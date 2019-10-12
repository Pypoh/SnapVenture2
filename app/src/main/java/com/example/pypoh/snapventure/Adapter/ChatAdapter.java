package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment;
import com.example.pypoh.snapventure.LevelPronounceFragment;
import com.example.pypoh.snapventure.Model.ChatModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment.currentState;
import static com.example.pypoh.snapventure.LevelPronounceFragment.tempChapterOneState;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mDataSet = new ArrayList<>();

    private Animation shakeAnimation;
    private Animation bubbleAnimation;

    private int currentLayerCount = 0;

    public ChatAdapter(Context mContext, List<String> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
//        checkLayer();
        shakeAnimation = AnimationUtils.loadAnimation(mContext, R.anim.shake_horizontal);
        bubbleAnimation = AnimationUtils.loadAnimation(mContext, R.anim.bubble);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_their, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_me, parent, false);
                break;
            case -1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_end, parent, false);
                break;
            default:
        }
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        String key = mDataSet.get(position);
        ChatModel message = LevelPronounceFragment.dataConversation.get(key);
        return message.getUser();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String key = mDataSet.get(position);
        ChatModel message = LevelPronounceFragment.dataConversation.get(key);
        TextView messageText;
        View inflatedStub;
//        if (message.getUser() == 0) {
//            holder.chatPlaceholder.setLayoutResource(R.layout.chat_item_their);
//            inflatedStub = holder.chatPlaceholder.inflate();
//            messageText = inflatedStub.findViewById(R.id.text_chat_their);
//        } else {
//            holder.chatPlaceholder.setLayoutResource(R.layout.chat_item_me);
//            inflatedStub = holder.chatPlaceholder.inflate();
//            messageText = inflatedStub.findViewById(R.id.text_chat_me);
//        }
//        ImageView profileImage = holder.chatPlaceholder.findViewById(R.id.profile_image);
//        messageText.setText(message.getMessage());
        holder.chatMessage.setText(message.getMessage());
        if (!message.isAnswerStatus()) {
            holder.chatMessage.startAnimation(shakeAnimation);
        }
        if (message.isBubbleAnimation()) {
            holder.chatMessage.startAnimation(bubbleAnimation);
        }
    }

    @Override
    public int getItemCount() {
//        return currentLayerCount;
        return tempChapterOneState.size();
    }

    private void checkLayer() {
        char[] stateToArray = currentState.toCharArray();
        Log.d("currentLayourState", currentState + "");
        for (char item : stateToArray) {
            if (item == '3' || item == '4' || item == '5') {
                currentLayerCount++;
                if (tempChapterOneState.size() != 1) {
                    currentState = tempChapterOneState.get(tempChapterOneState.size() - 2);
                    checkLayer();
                }
            }
            if (item == '0' || item == '1' || item == '2') {
                currentLayerCount++;
            }
        }
        Log.d("currentLayourCount", currentLayerCount + "");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Component
//        private ViewStub chatPlaceholder;
        private TextView chatMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            chatPlaceholder = itemView.findViewById(R.id.viewstub_chat_placeholder);
            chatMessage = itemView.findViewById(R.id.text_chat);
        }
    }


}
