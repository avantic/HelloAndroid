package net.avantic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HelloAndroidActivity extends Activity {
	
	UserMessages messages;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        messages = new UserMessages(getApplicationContext());
        
        messages.show("onCreate call");
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
				messages.show("I shouldn't be here, something is wrong");
				break;
		}
    	return super.onOptionsItemSelected(item);
    }
    
}