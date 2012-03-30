/*
 * Copyright (C) 2010 Paul Watts (paulcwatts@gmail.com)
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
package com.joulespersecond.seattlebusbot;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ActionBar;

public class AlertActivity extends MyTabActivityBase {
    //private static final String TAG = "AlertActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ensureSupportActionBarAttached();
        final Resources res = getResources();
        final ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

        bar.addTab(bar.newTab()
                .setTag(MySearchRoutesFragment.TAB_NAME)
                .setText(res.getString(R.string.my_set_alert))
                .setIcon(res.getDrawable(R.drawable.ic_tab_search))
                .setTabListener(new TabListener<MySearchRoutesFragment>(
                        this,
                        MySearchRoutesFragment.TAB_NAME,
                        MySearchRoutesFragment.class)));
        bar.addTab(bar.newTab()
                .setTag(MyRecentRoutesFragment.TAB_NAME)
                .setText(res.getString(R.string.my_view_alert))
                .setIcon(res.getDrawable(R.drawable.ic_tab_recent))
                .setTabListener(new TabListener<MyRecentAlertFragment>(
                        this,
                        MyRecentAlertFragment.TAB_NAME,
                        MyRecentAlertFragment.class)));
        
        
        restoreDefaultTab();
    }

    @Override
    protected String getLastTabPref() {
        return "AlertActivity.LastTab";
    }

}
