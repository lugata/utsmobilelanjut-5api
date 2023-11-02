package com.lugata_ata.uts_5api;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadBahasaDaerahData();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadBeritaIndonesiaData();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadKodePosData();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDoaDoaData();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAyatAlQuranData();
            }
        });
    }

    private void loadBahasaDaerahData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.codespade.com:4517/codespade/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BahasaDaerahService service = retrofit.create(BahasaDaerahService.class);
        Call<List<BahasaDaerah>>call = service.getBahasaDaerah();
        call.enqueue(new Callback<List<BahasaDaerah>>() {
            @Override
            public void onResponse(Call<List<BahasaDaerah>> call, Response<List<BahasaDaerah>> response) {
                if (response.isSuccessful()) {
                    List<BahasaDaerah> bahasaDaerahList = response.body();
                    adapter = new BahasaDaerahAdapter(bahasaDaerahList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Gagal mengambil data Bahasa Daerah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BahasaDaerah>> call, Throwable t) {
                Log.e("Retrofit Error", "Error: " + t.getMessage()); // Add this line for error logging
                Toast.makeText(MainActivity.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void loadBeritaIndonesiaData() {
        // Buat instance Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-berita-indonesia.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BeritaIndonesiaService service = retrofit.create(BeritaIndonesiaService.class);

        // Mengambil data dari API
        Call<BeritaIndonesiaResponse> call = service.getBeritaIndonesia();
        call.enqueue(new Callback<BeritaIndonesiaResponse>() {
            @Override
            public void onResponse(Call<BeritaIndonesiaResponse> call, Response<BeritaIndonesiaResponse> response) {
                if (response.isSuccessful()) {
                    BeritaIndonesiaResponse beritaResponse = response.body();
                    List<Post> posts = beritaResponse.getData().getPosts();
                    adapter.setHasStableIds(posts);

                } else {
                    Toast.makeText(MainActivity.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BeritaIndonesiaResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadKodePosData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kodepos-2d475.firebaseio.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KodePosService service = retrofit.create(KodePosService.class);
        Call<List<KodePos>> call = service.getKodePos();
        call.enqueue(new Callback<List<KodePos>>() {
            @Override
            public void onResponse(Call<List<KodePos>>call, Response<List<KodePos> >response) {
                if (response.isSuccessful()) {
                    List<KodePos> kodePosList = response.body();
                    adapter = new KodePosAdapter(kodePosList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Gagal mengambil data Kode Pos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<KodePos>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadDoaDoaData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://doa-doa-api-ahmadramadhan.fly.dev")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DoaService service = retrofit.create(DoaService.class);
        Call<List<Doa>> call = service.getDoaDoa();
        call.enqueue(new Callback<List<Doa>>() {
            @Override
            public void onResponse(Call<List<Doa>> call, Response<List<Doa>>response) {
                if (response.isSuccessful()) {
                    List<Doa> doaList = response.body();
                    adapter = new DoaAdapter(doaList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Gagal mengambil data Doa-doa", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Doa>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadAyatAlQuranData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://al-quran-8d642.firebaseio.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AyatAlQuranService service = retrofit.create(AyatAlQuranService.class);
        Call<List<AyatAlQuran>> call = service.getAyatAlQuran();
        call.enqueue(new Callback<List<AyatAlQuran>>() {
            @Override
            public void onResponse(Call<List<AyatAlQuran>> call, Response<List<AyatAlQuran>>response) {
                if (response.isSuccessful()) {
                    List<AyatAlQuran> ayatAlQuranList = response.body();
                    adapter = new AyatAlQuranAdapter(ayatAlQuranList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Gagal mengambil data Ayat Al-Qur'an", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<AyatAlQuran>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
