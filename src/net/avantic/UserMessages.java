package net.avantic;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class UserMessages {
	
	private Context context;
	
	private boolean showMessages = false;
	
	public UserMessages(Context context) {
		this.context = context;
	}

	public void show(String message) {
		if (showMessages) 
			showAlways(message);
	}

	public void showAlways(String message) {
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, message, duration);
		toast.setGravity(Gravity.CENTER, 10, 10);
		toast.show();
	}
	
	public void enable() {
		showMessages = true;
	}

	public void disable() {
		showMessages = false;
	}

}
