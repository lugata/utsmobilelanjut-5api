package com.lugata_ata.uts_5api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeritaIndonesiaResponse {
    private boolean success;
    private String message;
    private BeritaIndonesia data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public BeritaIndonesia getData() {
        return data;
    }
}
