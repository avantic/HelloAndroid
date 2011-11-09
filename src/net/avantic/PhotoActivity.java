package net.avantic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class PhotoActivity extends Activity implements OnClickListener {
	
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		
		Button button = (Button) findViewById(R.id.takePhotoButton);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			Bitmap bitmap = (Bitmap) data.getExtras().get("data");
			ImageView image = (ImageView)findViewById(R.id.showPhotoView);
			image.setImageBitmap(bitmap);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
}
