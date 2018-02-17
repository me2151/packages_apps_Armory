/*
 * Copyright (C) 2018 Invictrix ROM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.armory.settings.ui;

import android.content.ContentResolver;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;

import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;

import com.android.settings.preferences.CustomSeekBarPreference;
import com.android.settings.R;

public class StatusBarSettings extends InvictrixSettingsFragment implements OnPreferenceChangeListener {

    public static String NETWORK_TRAFFIC_KEY = "network_traffic_autohide_threshold";

    private ContentResolver resolver;
    private CustomSeekBarPreference mThreshold;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getResources().getString(R.string.statusbar_settings_title);
        addPreferencesFromResource(R.xml.settings_statusbar);

        resolver = getActivity().getContentResolver();

        int value = Settings.System.getIntForUser(resolver, NETWORK_TRAFFIC_KEY, 1, UserHandle.USER_CURRENT);
        mThreshold = (CustomSeekBarPreference) findPreference(NETWORK_TRAFFIC_KEY);
        mThreshold.setValue(value);
        mThreshold.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        int val = (Integer) newValue;
        Settings.System.putIntForUser(resolver, NETWORK_TRAFFIC_KEY, val, UserHandle.USER_CURRENT);
        return true;
    }

}
