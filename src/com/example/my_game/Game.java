package com.example.my_game;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Game extends Activity {

	public TextView text;
	final int REQUEST = 1;
	public Resources res;
	String[] section;
	int pos;
	Button btn01;
	int cnt = 0;
	ScrollView scrollview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_2);

		res = getResources();
		final String[] section = res.getStringArray(R.array.section_array);

		text = (TextView) findViewById(R.id.tvView01);
		text.setTypeface(Typeface.createFromAsset(getAssets(), "MTCORSVA.TTF"));
		text.setText(R.string.start);

		final Button btn01 = (Button) findViewById(R.id.btn01);

		scrollview = ((ScrollView) findViewById(R.id.scrollview));

		btn01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent;
				switch (v.getId()) {
				case R.id.btn01:
					intent = new Intent(Game.this, SectorActivity.class);
					startActivityForResult(intent, REQUEST);
					break;
				}
			}
		});

	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("count", pos);

	}

	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		pos = savedInstanceState.getInt("count");
		res = getResources();
		final String[] section = res.getStringArray(R.array.section_array);
		Resources res2 = getResources();
		final String[] section2 = res
				.getStringArray(R.array.array_section_name);
		text.setText(section2[pos] + "\n" + section[pos] + "\n");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d("myLogs", "requestCode = " + requestCode + ", resultCode = "
				+ resultCode);
		// если пришло ОК
		if (resultCode == RESULT_OK) {
			int position = data.getIntExtra("position", REQUEST);

			pos = position;

		}
		res = getResources();
		final String[] section = res.getStringArray(R.array.section_array);
		Resources res2 = getResources();
		final String[] section2 = res
				.getStringArray(R.array.array_section_name);
		text.setText(section2[pos] + "\n" + section[pos] + "\n");
		scrollview.post(new Runnable() {
			@Override
			public void run() {
				scrollview.fullScroll(ScrollView.FOCUS_UP);
			}
		});

	}

}