package com.example.my_game;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Ger extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ger2);

		TextView textView002 = (TextView) findViewById(R.id.textView002);
		TextView textView001 = (TextView) findViewById(R.id.textView001);
		
		textView001.setTypeface(Typeface.createFromAsset(getAssets(),
				"MTCORSVA.TTF"));
		
		textView002.setTypeface(Typeface.createFromAsset(getAssets(),
				"MTCORSVA.TTF"));
		
		textView002.setText(R.string.rule);
		
	}
}
