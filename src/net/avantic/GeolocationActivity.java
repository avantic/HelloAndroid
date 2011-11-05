package net.avantic;

import java.util.List;

import net.avantic.maps.SimpleItemizedOverlay;
import net.avantic.utils.UserMessages;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class GeolocationActivity extends MapActivity {

	private UserMessages messages;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geolocation);
		
		messages = new UserMessages(this);
		
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		Drawable positionIcon = this.getResources().getDrawable(R.drawable.ic_blue_flag);
		LocationListener locationListener = new SimpleLocationListener(positionIcon, this);
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
		
		messages.showAlways("Waiting to find the current location ...");
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	private class SimpleLocationListener implements LocationListener {

		private Drawable positionIcon;
		
		private Context context;
		
		public SimpleLocationListener(Drawable positionIcon, Context context) {
			this.positionIcon = positionIcon;
			this.context = context;
		}
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {}
		
		@Override
		public void onProviderEnabled(String provider) {}
		
		@Override
		public void onProviderDisabled(String provider) {}
		
		@Override
		public void onLocationChanged(Location location) {
			MapView mapView = (MapView) findViewById(R.id.mapview);
			mapView.setBuiltInZoomControls(true);
			
			List<Overlay> mapOverlays = mapView.getOverlays();
			SimpleItemizedOverlay itemizedOverlay = new SimpleItemizedOverlay(positionIcon, context);
			
			int latitude = (int) (location.getLatitude() * 1e6);
			int longitude = (int) (location.getLongitude() * 1e6);
			GeoPoint tenerife = new GeoPoint(latitude, longitude);
	        OverlayItem overlayTenerife = new OverlayItem(tenerife, "User", "Estás aquí!!!");
	        
	        itemizedOverlay.addOverlay(overlayTenerife);
	        mapOverlays.add(itemizedOverlay);
	        
	        mapView.refreshDrawableState();
		}
		
	}

}
