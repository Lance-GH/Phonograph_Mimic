package com.example.phonograph_mimic;

import android.app.Application;
import android.os.Build;

import com.kabouzeid.appthemehelper.ThemeStore;

public class App extends Application {

    private static final String PRO_VERSION_PRODUCT_ID = "pro_version";

    private static App app;

    private BillingProcessor billingProcessor;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        // default theme
        if (ThemeStore.isConfigured(this, 1)) {
            ThemeStore.editTheme(this)
                    .primaryColorRes(R.color.md_indigo_500)
                    .accentColorRes(R.color.md_pink_A400)
                    .commit();
        }

        // Set up dynamic shortcuts
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            new DynamicShortcutManager(this).initDynamicShortcuts();
        }
    }

    public static boolean isProVersion() {
        return BuildConfig.DEBUG || app.billingProcessor.isPurchased(PRO_VERSION_PRODUCT_ID);
    }
}
