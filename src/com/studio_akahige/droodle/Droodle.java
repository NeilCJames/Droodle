package com.studio_akahige.droodle;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ToggleButton;

public class Droodle extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ToggleButton etb = (ToggleButton) findViewById(R.id.eraserToggle);
        final Doodle d = (Doodle) findViewById(R.id.doodle);
        d.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float x = event.getX();
				float y = event.getY();
				
				d.setX(x);
				d.setY(y);
				if (etb.isChecked()) {
					d.invalidate (
						Math.round(x-24),
						Math.round(y-24),
						Math.round(x+25),
						Math.round(y+25));
				}
				else {
					d.invalidate(
						Math.round(x-(d.getStrokeWidth()/2.0f)),
						Math.round(y-(d.getStrokeWidth()/2.0f)),
						Math.round(x+(d.getStrokeWidth()/2.0f)),
						Math.round(y+(d.getStrokeWidth()/2.0f)));
				}
				return true;
			}
		});
        etb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (etb.isChecked()) d.setEraser(true);
				else d.setEraser(false);
			}
		});
    }
}