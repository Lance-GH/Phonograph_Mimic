package com.example.phonograph_mimic.adapter.song;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.afollestad.materialcab.MaterialCab;
import com.example.phonograph_mimic.adapter.base.MediaEntryViewHolder;
import com.example.phonograph_mimic.model.Song;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

public class SongAdapter extends AbsMultiSelectAdapter<SongAdapter.ViewHolder, Song> implements MaterialCab.Callback, FastScrollRecyclerView.SectionedAdapter {
    @Override
    public boolean onCabCreated(MaterialCab cab, Menu menu) {
        return false;
    }

    @Override
    public boolean onCabItemClicked(MenuItem item) {
        return false;
    }

    @Override
    public boolean onCabFinished(MaterialCab cab) {
        return false;
    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        return null;
    }

    public class ViewHolder extends MediaEntryViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
