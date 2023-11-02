package com.lugata_ata.uts_5api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KodePosService {
    @GET("kota_kab/k69.json")
    Call<List<KodePos>> getKodePos();
}
