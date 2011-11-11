package net.avantic.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Circle extends View {

	private float x = 100;
	
	private float y = 100;
	
	private final float radius = 50;
	
	private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	public Circle(Context context) {
		super(context);
		paint.setColor(0xFFFF0000);
	}
	
	public Circle(Context context, float x, float y) {
		super(context);
		this.x = x;
		this.y = y;
		paint.setColor(0xFFFF0000);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawCircle(x, y, radius, paint);
	}

}
