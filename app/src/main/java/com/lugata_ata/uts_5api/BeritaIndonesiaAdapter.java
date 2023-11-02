package com.lugata_ata.uts_5api;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class BeritaIndonesiaAdapter extends RecyclerView.Adapter<BeritaIndonesiaAdapter.ViewHolder> {
    private List<Post> beritaIndonesiaPosts;

    public void setData(List<Post> posts) {
        beritaIndonesiaPosts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita_indonesia, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = beritaIndonesiaPosts.get(position);

        holder.titleTextView.setText(post.getTitle());
        holder.descriptionTextView.setText(post.getDescription());
        Picasso.get().load(post.getThumbnail()).into(holder.thumbnailImageView);
    }

    @Override
    public int getItemCount() {
        return beritaIndonesiaPosts != null ? beritaIndonesiaPosts.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView thumbnailImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            descriptionTextView = itemView.findViewById(R.id.textViewDescription);
            thumbnailImageView = itemView.findViewById(R.id.imageViewThumbnail);
        }
    }
}

