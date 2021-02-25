package com.hfad.bitsandpizza.adapter;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.bitsandpizza.R;

public class CaptionImagesAdapter extends
        RecyclerView.Adapter<CaptionImagesAdapter.CaptionImagesViewHolder> {

    private String[] captions;
    private int[] img;

    private CaptionImagesAdapterOnClickListener listener;

    public interface CaptionImagesAdapterOnClickListener {
        void onClick(int position);
    }

    public CaptionImagesAdapter(String[] captions, int[] img) {
        this.captions = captions;
        this.img = img;
    }

    @NonNull
    @Override
    public CaptionImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView)
                LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.card_captioned_image, parent, false);
        return new CaptionImagesViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull CaptionImagesViewHolder holder, final int position) {
        CardView cardView = holder.cardView;

        ImageView cardImg = (ImageView) cardView.findViewById(R.id.card_img);
        cardImg.setImageDrawable(ContextCompat.getDrawable(cardView.getContext(), img[position]));
        cardImg.setContentDescription(captions[position]);

        TextView cardCaption = (TextView) cardView.findViewById(R.id.card_caption);
        cardCaption.setText(captions[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null)
                    listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public void setCaptionImagesViewHolderListener(CaptionImagesAdapterOnClickListener listener) {
        this.listener = listener;
    }

    public static class CaptionImagesViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public CaptionImagesViewHolder(@NonNull CardView v) {
            super(v);
            cardView = v;
        }
    }

}
