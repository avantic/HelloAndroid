package net.avantic;

import java.util.List;

import net.avantic.utils.UserMessages;
import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;

public class FlashTorchActivity extends Activity {
	
	private UserMessages userMessages;
	
	private Camera camera;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flashtorch);
		
		userMessages = new UserMessages(getApplicationContext());
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		camera = Camera.open();
		camera.startPreview();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		// turn light on
		Parameters parameters = camera.getParameters();
		List<String> supportedModes = parameters.getSupportedFlashModes();
		if (supportedModes == null) {
			userMessages.showAlways("This device have no flash or it is not accesible by API");
			return;
		}
		if (supportedModes.contains(Parameters.FLASH_MODE_TORCH)) {
			parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(parameters);
		} else
			userMessages.showAlways("Torch mode is not supported by this device");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		// turn light off
		Parameters parameters = camera.getParameters();
		parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
		camera.setParameters(parameters);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		
		camera.stopPreview();
		camera.release();
	}
	
}
