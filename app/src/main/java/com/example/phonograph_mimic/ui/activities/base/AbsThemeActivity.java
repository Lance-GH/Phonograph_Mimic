package com.example.phonograph_mimic.ui.activities.base;

import android.os.Build;
import android.os.Bundle;

import com.example.phonograph_mimic.util.PreferenceUtil;
import com.example.phonograph_mimic.util.Util;
import com.kabouzeid.appthemehelper.ATH;
import com.kabouzeid.appthemehelper.common.ATHToolbarActivity;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */

public abstract class AbsThemeActivity extends ATHToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(PreferenceUtil.getInstance(this).getGeneralTheme());
        super.onCreate(savedInstanceState);
    }

    protected void setDrawUnderStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Util.setAllowDrawUnderStatusBar(getWindow());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Util.setStatusBarTranslucent(getWindow());
        }
    }
}
