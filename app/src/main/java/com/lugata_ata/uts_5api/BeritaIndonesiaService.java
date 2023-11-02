package com.lugata_ata.uts_5api;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BeritaIndonesiaService {
    @GET("cnn/terbaru")
    Call<BeritaIndonesiaResponse> getBeritaIndonesia();
}
