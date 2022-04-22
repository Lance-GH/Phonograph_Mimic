package com.example.phonograph_mimic.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.phonograph_mimic.model.CategoryInfo;
import com.example.phonograph_mimic.ui.fragments.mainactivity.library.pager.SongsFragment;
import com.example.phonograph_mimic.util.PreferenceUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MusicLibraryPagerAdapter extends FragmentPagerAdapter {

    private final SparseArray<WeakReference<Fragment>> mFragmentArray = new SparseArray<>();

    private final List<Holder> mHolderList = new ArrayList<>();

    private final Context mContext;

    public MusicLibraryPagerAdapter(@NonNull final Context context, @NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
        setCategoryInfos(PreferenceUtil.getInstance(context).getLibraryCategoryInfos());
    }

    public void setCategoryInfos(@NonNull List<CategoryInfo> categoryInfos) {
        mHolderList.clear();

        for (CategoryInfo categoryInfo : categoryInfos) {
            if (categoryInfo.visible) {
                MusicFragments fragment = MusicFragments.valueOf(categoryInfo.category.toString());
                Holder holder = new Holder();
                holder.mClassName = fragment.getFragmentClass().getName();
                holder.title = mContext.getResources()
                        .getString(categoryInfo.category.stringRes)
                        .toUpperCase(Locale.getDefault());
                mHolderList.add(holder);
            }
        }

        alignCache();
        notifyDataSetChanged();
    }

    /**
     * Aligns the fragment cache with the current category layout.
     */
    private void alignCache() {

    }

    public Fragment getFragment(final int position) {
        final WeakReference<Fragment> mWeakFragment = mFragmentArray.get(position);
        if (mWeakFragment != null && mWeakFragment.get() != null) {
            return mWeakFragment.get();
        }
        return getItem(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    public enum MusicFragments {
        SONGS(SongsFragment.class),
        ALBUMS(AlbumsFragment.class),
        ARTISTS(ArtistsFragment.class),
        GENRES(GenresFragment.class),
        PLAYLISTS(PlaylistsFragment.class);

        private final Class<? extends Fragment> mFragmentClass;

        MusicFragments(final Class<? extends Fragment> fragmentClass) {
            mFragmentClass = fragmentClass;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return mFragmentClass;
        }

        public static MusicFragments of(Class<?> cl) {
            MusicFragments[] fragments = All.FRAGMENTS;
            for (MusicFragments fragment : fragments) {
                if (cl.equals(fragment.mFragmentClass)) {
                    return fragment;
                }
            }
        }

        private static class All {
            public static final MusicFragments[] FRAGMENTS = values();
        }
    }

    private final static class Holder {
        String mClassName;
        Bundle mParams;
        String title;
    }
}
