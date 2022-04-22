package com.example.phonograph_mimic.ui.fragments.mainactivity.library.pager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.phonograph_mimic.adapter.song.SongAdapter;
import com.example.phonograph_mimic.model.Song;

import java.util.List;

public class SongsFragment extends AbsLibraryPagerRecyclerViewCustomGridSizeFragment<SongAdapter, GridLayoutManager>
    implements LoaderManager.LoaderCallbacks<List<Song>> {

    private static final int LOADER_ID;

    @NonNull
    @Override
    public Loader<List<Song>> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Song>> loader, List<Song> data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Song>> loader) {

    }
}
