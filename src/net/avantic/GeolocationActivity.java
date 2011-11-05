package net.avantic;

import net.avantic.maps.SimpleLocationListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class GeolocationActivity extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geolocation);
		
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		LocationListener locationListener = buildSimpleLocationListener();
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
	}
	
	private LocationListener buildSimpleLocationListener() {
		Drawable positionIcon = this.getResources().getDrawable(R.drawable.ic_blue_flag);
		MapView mapView = (MapView) findViewById(R.id.mapview);
		return new SimpleLocationListener(positionIcon, this, mapView);
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
