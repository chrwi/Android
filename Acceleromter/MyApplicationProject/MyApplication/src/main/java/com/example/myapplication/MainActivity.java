package com.example.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView title, tv, tv1, tv2;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the sensor service
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // Get the accelerometer sensor
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // get layout
        layout = (RelativeLayout) findViewById(R.id.relative);
        // get textviews
        title = (TextView) findViewById(R.id.name);
        tv  =   (TextView) findViewById(R.id.xval);
        tv1 =   (TextView) findViewById(R.id.yval);
        tv2 =   (TextView) findViewById(R.id.zval);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        // Display values using TextView
        title.setText(R.string.app_name);
        tv.setText("X axis"  + "\t\t"+x);
        tv1.setText("Y axis" + "\t\t"+y);
        tv2.setText("Z axis" + "\t\t"+z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
       // Do something when accuracy changes
    }

    @Override
    protected  void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
