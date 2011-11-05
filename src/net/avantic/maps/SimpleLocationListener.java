package net.avantic.maps;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class SimpleLocationListener implements LocationListener {

	private Drawable positionIcon;
	
	private Context context;
	
	private MapView mapView;
	
	public SimpleLocationListener(Drawable positionIcon, Context context, MapView mapView) {
		this.positionIcon = positionIcon;
		this.context = context;
		this.mapView = mapView;
	}
	
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {}
	
	@Override
	public void onProviderEnabled(String provider) {}
	
	@Override
	public void onProviderDisabled(String provider) {}
	
	@Override
	public void onLocationChanged(Location location) {
		mapView.setBuiltInZoomControls(true);
		
		List<Overlay> mapOverlays = mapView.getOverlays();
		SimpleItemizedOverlay itemizedOverlay = new SimpleItemizedOverlay(positionIcon, context);
		
		int latitude = (int) (location.getLatitude() * 1e6);
		int longitude = (int) (location.getLongitude() * 1e6);
		GeoPoint tenerife = new GeoPoint(latitude, longitude);
        OverlayItem overlayTenerife = new OverlayItem(tenerife, "User", "Estás aquí!!!");
        
        itemizedOverlay.addOverlay(overlayTenerife);
        mapOverlays.add(itemizedOverlay);
        
        mapView.invalidate();
	}
	
}
