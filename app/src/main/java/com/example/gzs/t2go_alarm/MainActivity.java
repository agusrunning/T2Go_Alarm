/*
MainActivity.java

History

Developer      Date         Comments
—————————————————————————
Alex T.          11Aug2018   Initial Release
Neha S.
Kush S.

Description: MainActivity

This java file is a test harness and will call two CSCs

How it works:
1) Test UI has button user can set ttime
2) Use selects "Set Time" button
3) T2Go_Activity is called and new time is set by user
4) T2Go_Activity sets title and saves new time
5) T2Go_Activity has current timeout that T2Go_Receiver uses to trigger alarm



Input: user enter timeout value hours, minutes or seconds

Output: timeout gets displayed in test UI and saved to T2Go_Activity that later can be
used to trigger alarm.

Stuff needed to be coded by Neha and Kush:

1) within T2Go_Activity set up get and set function calls that can be used by MainActivity
and T2Go_Utils.java.

2) Set up method for resetting timeout values to current time

*/

package com.example.gzs.t2go_alarm;

import java.util.Calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private TextView time;
    private static final String TAG = "Neha Test Code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Starting program");
        updateViews();
    }

    private void updateViews(){
        time = (TextView) findViewById(R.id.time);
    }

    public void showPicker(View v){
        Calendar now = Calendar.getInstance();

        T2Go_Activity mTimePicker = new T2Go_Activity(this, new T2Go_Activity.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute, int seconds) {
                // TODO Auto-generated method stub
                time.setText(getString(R.string.time) + String.format("%02d", hourOfDay)+
                        ":" + String.format("%02d", minute) +
                        ":" + String.format("%02d", seconds));
            }
        }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND), true);


        mTimePicker.show();
    }

    @Override
    // Auto-generated and does nothing for app. Included for future use
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
