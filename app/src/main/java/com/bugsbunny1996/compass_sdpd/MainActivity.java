package com.bugsbunny1996.compass_sdpd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.text.Html;
import android.widget.ImageView;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private ImageView image;

    // record the compass picture angle turned
    private float currentDegree = 0f;

    // device sensor manager
    private SensorManager mSensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // for the system's orientation sensor registered listeners
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // to stop the listener and save battery
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        Float degrees = event.values[0];
        String st = degrees.toString();
        ImageView img = (ImageView) findViewById(R.id.image);
        img.setRotation(-1*degrees);

        //TextView t = (TextView) findViewById(R.id.text);
        //t.setText(st);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
}
