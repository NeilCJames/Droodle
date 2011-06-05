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
	
	public void setStrokeWidth(int w) {
		p.setStrokeWidth((float)w);
		return;
	}
	
	private void initializePaint() {
		p.setColor(Color.BLUE);
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
	
	public float getEraserStroke() {
		return eraserPaint.getStrokeWidth();
	}
	
	public void setBrushColor(int c) {
		switch (c) {
		case 0:
			p.setColor(Color.BLUE);
			break;
		case 1:
			p.setColor(Color.CYAN);
			break;
		case 2:
			p.setColor(Color.GRAY);
			break;
		case 3:
			p.setColor(Color.GREEN);
			break;
		case 4:
			p.setColor(Color.MAGENTA);
			break;
		case 5:
			p.setColor(Color.RED);
			break;
		case 6:
			p.setColor(Color.WHITE);
			break;
		case 7:
			p.setColor(Color.YELLOW);
			break;
		}
		return;
	}
}