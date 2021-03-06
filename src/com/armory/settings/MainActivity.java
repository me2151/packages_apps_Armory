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

package com.armory.settings;

import android.os.Bundle;

import com.android.settings.R;

import com.armory.settings.ui.InvictrixSettingsFragment;

public class MainActivity extends InvictrixSettingsFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getResources().getString(R.string.main_settings_title);
        addPreferencesFromResource(R.xml.settings_main);
    }

}
