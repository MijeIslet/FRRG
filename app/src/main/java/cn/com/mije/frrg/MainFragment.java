package cn.com.mije.frrg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.preference.Preference;

import com.takisoft.fix.support.v7.preference.PreferenceFragmentCompatDividers;

import cn.com.mije.frrg.preference.ClearPatternPreference;
import cn.com.mije.frrg.utils.PreferenceContract;

/**
 * Created by Administrator on 2017/5/17.
 */
public class MainFragment extends PreferenceFragmentCompatDividers
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case PreferenceContract.KEY_THEME:
                getActivity().recreate();
        }
    }

    @Override
    public void onCreatePreferencesFix(@Nullable Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.main_prefernce);
    }

    @Override
    public void onDisplayPreferenceDialog(Preference preference) {
        if (!ClearPatternPreference.onDisplayPreferenceDialog(this, preference)) {
            super.onDisplayPreferenceDialog(preference);
        }
    }
}
