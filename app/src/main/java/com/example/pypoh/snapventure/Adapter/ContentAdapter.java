package com.example.pypoh.snapventure.Adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.R;

import java.util.List;
import java.util.Locale;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private Context mContext;
    private List<String> wordsData;

    // Text to Speech
    private TextToSpeech textToSpeech;

    public ContentAdapter(Context mContext, List<String> wordsData) {
        this.mContext = mContext;
        this.wordsData = wordsData;
        textToSpeech = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content_lesson, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String word = wordsData.get(position);

        holder.text.setText(word);
        holder.voiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(word, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return wordsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView text;
        private ImageView voiceBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.item_text);
            voiceBtn = itemView.findViewById(R.id.item_voice);

        }
    }
}
