package com.example.phonograph_mimic.interfaces;

import androidx.annotation.NonNull;

import com.afollestad.materialcab.MaterialCab;

public interface CabHolder {

    @NonNull
    MaterialCab openCab(final int menuRes, final MaterialCab.Callback callback);
}
