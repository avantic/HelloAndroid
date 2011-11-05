package net.avantic;

import android.os.Bundle;

import com.google.android.maps.MapActivity;

public class GeolocationActivity extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geolocation);
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
