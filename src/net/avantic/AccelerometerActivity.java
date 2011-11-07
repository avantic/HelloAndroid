package net.avantic;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends Activity implements SensorEventListener {

	private SensorManager sensorManager;
	
	private Sensor accelerometer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accelerometer);
		
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;
		
		TextView xaxisTextView = (TextView) findViewById(R.id.xaxisText);
		xaxisTextView.setText(Float.toString(event.values[0]));
		TextView yaxisTextView = (TextView) findViewById(R.id.yaxisText);
		yaxisTextView.setText(Float.toString(event.values[1]));
		TextView zaxisTextView = (TextView) findViewById(R.id.zaxisText);
		zaxisTextView.setText(Float.toString(event.values[2]));
	}
	
}
