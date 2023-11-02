package com.lugata_ata.uts_5api;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AyatAlQuranAdapter extends RecyclerView.Adapter<AyatAlQuranAdapter.ViewHolder> {
    private List<AyatAlQuran> ayatAlQuranList;

    public AyatAlQuranAdapter(List<AyatAlQuran> ayatAlQuranList) {
        this.ayatAlQuranList = ayatAlQuranList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ayat_al_quran, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AyatAlQuran ayatAlQuran = ayatAlQuranList.get(position);

        holder.ayatTextView.setText(ayatAlQuran.getAyat());
        holder.surahTextView.setText(ayatAlQuran.getNama());
        holder.textTextView.setText(ayatAlQuran.getArti());
    }

    @Override
    public int getItemCount() {
        return ayatAlQuranList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView surahTextView;
        TextView ayatTextView;
        TextView textTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            surahTextView = itemView.findViewById(R.id.textViewSurah);
            ayatTextView = itemView.findViewById(R.id.textViewAyat);
            textTextView = itemView.findViewById(R.id.textViewText);
        }
    }
}
