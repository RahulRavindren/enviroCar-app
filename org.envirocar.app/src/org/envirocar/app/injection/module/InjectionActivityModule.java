package org.envirocar.app.injection.module;


import android.app.Activity;
import android.content.Context;

import org.envirocar.app.BaseMainActivity;
import org.envirocar.app.TrackHandler;
import org.envirocar.app.activity.DashboardFragment;
import org.envirocar.app.activity.ListTracksFragment;
import org.envirocar.app.activity.LogbookFragment;
import org.envirocar.app.activity.LoginFragment;
import org.envirocar.app.activity.RegisterFragment;
import org.envirocar.app.activity.SettingsActivity;
import org.envirocar.app.activity.StartStopButtonUtil;
import org.envirocar.app.application.CarManager;
import org.envirocar.app.application.TermsOfUseManager;
import org.envirocar.app.injection.InjectionActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                BaseMainActivity.class,
                TermsOfUseManager.class,
                CarManager.class,
                DashboardFragment.class,
                ListTracksFragment.class,
                LogbookFragment.class,
                LoginFragment.class,
                RegisterFragment.class,
                SettingsActivity.class,
                StartStopButtonUtil.class,
                TrackHandler.class
        },
        addsTo = InjectionApplicationModule.class,
        library = true,
        complete = false
)
public class InjectionActivityModule {

    private Activity mActivity;

    /**
     * Constructor
     *
     * @param activity the activity of this scope.
     */
    public InjectionActivityModule(Activity activity) {
        this.mActivity = activity;
    }


    @Provides
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @InjectionActivityScope
    public Context provideContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    public DashboardFragment provideDashboardFragment(){
        return new DashboardFragment();
    }

    @Provides
    @Singleton
    TrackHandler provideTrackHandler(){
        return new TrackHandler(mActivity);
    }

}
