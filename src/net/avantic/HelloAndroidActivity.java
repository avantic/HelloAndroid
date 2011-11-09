package net.avantic;

import net.avantic.utils.UserMessages;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class HelloAndroidActivity extends Activity implements OnClickListener {
	
	UserMessages messages;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setListenerForMenuButtons();
        
        messages = new UserMessages(getApplicationContext());
        
        messages.show("onCreate call");
    }

	private void setListenerForMenuButtons() {
		prepareButton(R.id.mapButton);
        prepareButton(R.id.weatherButton);
        prepareButton(R.id.accelerometerButton);
        prepareButton(R.id.photoButton);
	}
    
    private void prepareButton(int buttonId) {
    	View button = findViewById(buttonId);
    	button.setOnClickListener(this);
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	messages.show("onStart call");
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	messages.show("onResume call");
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	messages.show("onPause call");
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	messages.show("onStop call");
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	messages.show("onDestroy call");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.options, menu);
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
			case R.id.messagesItem:
				if (item.isChecked()) {
					messages.showAlways("Now I will not show messages anymore");
					messages.disable();
					item.setChecked(false);
				} else {
					messages.showAlways("Now I'll show messages");
					messages.enable();
					item.setChecked(true);
				}
				break;
			default:
				messages.showAlways("I shouldn't be here, something is wrong");
				break;
		}
    	return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.mapButton:
				navigateToActivity(GeolocationActivity.class);
				break;
			case R.id.weatherButton:
				navigateToActivity(WeatherActivity.class);
				break;
			case R.id.accelerometerButton:
				navigateToActivity(AccelerometerActivity.class);
				break;
			case R.id.photoButton:
				navigateToActivity(PhotoActivity.class);
				break;
			default: 
				messages.showAlways("I shouldn't be here, something is wrong");
				break;
		}
	}
		
	private void navigateToActivity(Class activityClass) {
		Intent intent = new Intent(this, activityClass);
		startActivity(intent);
	}
    
}