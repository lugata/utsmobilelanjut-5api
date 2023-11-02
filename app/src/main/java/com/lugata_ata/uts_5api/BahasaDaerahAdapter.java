package com.lugata_ata.uts_5api;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BahasaDaerahAdapter extends RecyclerView.Adapter<BahasaDaerahAdapter.ViewHolder> {
    private List<BahasaDaerah> bahasaDaerahList;

    public BahasaDaerahAdapter(List<BahasaDaerah> bahasaDaerahList) {
        this.bahasaDaerahList = bahasaDaerahList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bahasa_daerah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BahasaDaerah bahasaDaerah = bahasaDaerahList.get(position);
        holder.idTextView.setText(bahasaDaerah.getNomor());
        holder.nameTextView.setText(bahasaDaerah.getBahasa());
    }

    @Override
    public int getItemCount() {
        return bahasaDaerahList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idTextView;
        TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.textViewId);
            nameTextView = itemView.findViewById(R.id.textViewTitle);
        }
    }
}

