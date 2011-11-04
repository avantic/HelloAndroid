package net.avantic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class HelloAndroidActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        showToast("onCreate call");
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	showToast("onStart call");
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	showToast("onResume call");
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	showToast("onPause call");
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	showToast("onStop call");
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	showToast("onDestroy call");
    }
    
    private void showToast(String msg) {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, msg, duration);
		toast.setGravity(Gravity.CENTER, 10, 10);
		toast.show();
	}
    
}