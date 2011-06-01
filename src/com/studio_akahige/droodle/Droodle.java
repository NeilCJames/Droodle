package com.studio_akahige.droodle;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class Droodle extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Doodle d = (Doodle) findViewById(R.id.doodle);
        d.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//float w = d.getStrokeWidth();
				float x = event.getX();
				float y = event.getY();
				
				d.setX(x);
				d.setY(y);
				d.invalidate(
						Math.round(x)-1,
						Math.round(y)-1,
						Math.round(x)+1,
						Math.round(y)+1);
				return true;
			}
		});
    }
}