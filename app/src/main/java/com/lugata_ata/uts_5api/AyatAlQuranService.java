package com.lugata_ata.uts_5api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AyatAlQuranService {
    @GET("data.json")
    Call<List<AyatAlQuran>> getAyatAlQuran();
}
