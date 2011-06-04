package com.studio_akahige.droodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Doodle extends View {

	private Paint p = new Paint();
	private Paint eraserPaint = new Paint();
	private float x;
	private float y;
	private boolean eraser = false;
	
	public Doodle(Context context) {
		super(context);
		initializePaint();
		// TODO Auto-generated constructor stub
	}

	public Doodle(Context context, AttributeSet attrs) {
		super(context, attrs);
		initializePaint();
		// TODO Auto-generated constructor stub
	}

	public Doodle(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initializePaint();
		// TODO Auto-generated constructor stub
	}
	
	public void onDraw(Canvas c) {
		// draw a point on the screen
		if (eraser) c.drawPoint(x, y, eraserPaint);
		else c.drawPoint(x, y, p);
	}
	
	public void setX(float rawX) {
		x = rawX;
	}

	public void setY(float rawY) {
		y = rawY;
	}
	
	public float getStrokeWidth() {
		return p.getStrokeWidth();
	}
	
	private void initializePaint() {
		p.setColor(Color.YELLOW);
		p.setStrokeWidth(5);
		p.setStrokeCap(Paint.Cap.SQUARE);
		p.setStyle(Paint.Style.STROKE);
		eraserPaint.setColor(Color.BLACK);
		eraserPaint.setStrokeWidth(50);
		eraserPaint.setStrokeCap(Paint.Cap.SQUARE);
		eraserPaint.setStyle(Paint.Style.STROKE);
	}
	
	public void setEraser(boolean b) {
		eraser = b;
	}
}