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

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MyStarredStopsActivity extends Activity {
    //
    // The only thing this is used for anymore is to create
    // a shortcut to the starred stops list.
    //
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent myIntent = getIntent();
        if (Intent.ACTION_CREATE_SHORTCUT.equals(myIntent.getAction())) {
            setResult(RESULT_OK, getShortcutIntent());
        }
        finish();
    }

    private Intent getShortcutIntent() {
        final Uri uri = MyTabActivityBase.getDefaultTabUri(MyRecentStopsFragment.TAB_NAME);
        return UIHelp.makeShortcut(this,
                    getString(R.string.starred_stops_shortcut),
                    new Intent(this, MyStopsActivity.class)
                        .setData(uri));
    }
}
