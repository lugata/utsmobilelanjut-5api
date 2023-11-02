package com.lugata_ata.uts_5api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DoaAdapter extends RecyclerView.Adapter<DoaAdapter.ViewHolder> {
    private List<Doa> doaList;

    public DoaAdapter(List<Doa> doaList) {
        this.doaList = doaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doa doa = doaList.get(position);

        holder.doaTextView.setText(doa.getDoa());
        holder.artinyaTextView.setText(doa.getArtinya());
    }

    @Override
    public int getItemCount() {
        return doaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView doaTextView;
        TextView artinyaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doaTextView = itemView.findViewById(R.id.textViewDoa);
            artinyaTextView = itemView.findViewById(R.id.textViewArtinya);
        }
    }
}

