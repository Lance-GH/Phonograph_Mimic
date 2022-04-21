package com.example.phonograph_mimic.ui.activities.base;

import com.example.phonograph_mimic.interfaces.MusicServiceEventListener;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsMusicServiceActivity extends AbsBaseActivity implements MusicServiceEventListener {

    private final List<MusicServiceEventListener> mMusicServiceEventListener = new ArrayList<>();




    @Override
    public void onServiceConnected() {

    }

    @Override
    public void onServiceDisconnected() {

    }

    @Override
    public void onQueueChanged() {

    }

    @Override
    public void onPlayingMetaChanged() {

    }

    @Override
    public void onPlayStateChanged() {

    }

    @Override
    public void onRepeatModeChanged() {

    }

    @Override
    public void onShuffleModeChanged() {

    }

    @Override
    public void onMediaStoreChanged() {

    }
}
