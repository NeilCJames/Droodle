package com.studio_akahige.droodle;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class Droodle extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ToggleButton etb = (ToggleButton) findViewById(R.id.eraserToggle);
        final Doodle d = (Doodle) findViewById(R.id.doodle);
        final Spinner s = (Spinner) findViewById(R.id.colorSpinner);
        final SeekBar sb = (SeekBar) findViewById(R.id.brushWidth);
        
        // Brush Width Change Event Handler
        sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
        	/** Not worried about managing app while SeekBar being manipulated,
        	/   so these abstracts just return immediately */
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// Do nothing
				return;
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// Do nothing
				return;
			}
			
			// d.setStrokeWidth handles the int->float cast
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				d.setStrokeWidth(progress+5);
				return;
			}
		});
        
        // ArrayAdapter to build drop-down menu from string-array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, 
        		R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        
        // Color Picker Event Handler
        s.setOnItemSelectedListener(new OnItemSelectedListener() {
        	@Override
        	public void onItemSelected(AdapterView<?> parent, View view, int pos,
        			long id) {
        		// TODO Auto-generated method stub
        		d.setBrushColor(pos);
        		return;
        	}

        	@Override
        	public void onNothingSelected(AdapterView<?> arg0) {
        		// Do Nothing
        		return;
        	}
		});
        
        // Draw-by-Touch Event Handler
        d.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float x = event.getX();
				float y = event.getY();
				
				d.setX(x);
				d.setY(y);
				if (etb.isChecked()) {
					float w = d.getEraserStroke()/2.0f;
					d.invalidate (
						Math.round(x-w),
						Math.round(y-w),
						Math.round(x+w),
						Math.round(y+w));
				}
				else {
					float w = d.getStrokeWidth()/2.0f;
					d.invalidate(
						Math.round(x-w),
						Math.round(y-w),
						Math.round(x+w),
						Math.round(y+w));
				}
				return true;
			}
		});
        
        // Eraser Toggle Event Handler
        etb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (etb.isChecked()) d.setEraser(true);
				else d.setEraser(false);
			}
		});
    }
}