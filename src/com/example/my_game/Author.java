package com.example.my_game;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Author extends Activity {

	TextView tView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.author);

		tView = (TextView) findViewById(R.id.tView01);
		tView.setText(R.string.author);

	}

}
