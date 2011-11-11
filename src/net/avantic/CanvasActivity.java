package net.avantic;

import net.avantic.canvas.Circle;
import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class CanvasActivity extends Activity  {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.canvas);
		
		FrameLayout canvas = (FrameLayout) findViewById(R.id.canvasView);
		canvas.addView(new Circle(this));
	}
	
}
