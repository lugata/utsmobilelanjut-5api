package com.lugata_ata.uts_5api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class KodePosAdapter extends RecyclerView.Adapter<KodePosAdapter.ViewHolder> {
    private List<KodePos> kodePosList;

    public KodePosAdapter(List<KodePos> kodePosList) {
        this.kodePosList = kodePosList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kode_pos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KodePos kodePos = kodePosList.get(position);

        holder.kecamatanTextView.setText(kodePos.getKecamatan());
        holder.kelurahanTextView.setText(kodePos.getKelurahan());
        holder.kodePosTextView.setText(kodePos.getKodepos());
    }

    @Override
    public int getItemCount() {
        return kodePosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView kecamatanTextView;
        TextView kelurahanTextView;
        TextView kodePosTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kecamatanTextView = itemView.findViewById(R.id.textViewKecamatan);
            kelurahanTextView = itemView.findViewById(R.id.textViewKelurahan);
            kodePosTextView = itemView.findViewById(R.id.textViewKodePos);
        }
    }
}
