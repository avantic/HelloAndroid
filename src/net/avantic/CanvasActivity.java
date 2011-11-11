package net.avantic;

import net.avantic.canvas.Circle;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

public class CanvasActivity extends Activity implements OnTouchListener  {
	
	private FrameLayout canvas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.canvas);

		canvas = (FrameLayout) findViewById(R.id.canvasView);
		canvas.setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View view, MotionEvent event) {
		canvas.addView(new Circle(this, event.getX(), event.getY()));
		
		return true;
	}
	
}
