package com.example.my_game;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class SectorActivity extends Activity {

	GridView gvMain;
	ArrayAdapter<String> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sector);

		Resources res = getResources();
		String[] section = res.getStringArray(R.array.array_section_name);
		adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText,
				section);
		gvMain = (GridView) findViewById(R.id.gvMain);

		gvMain.setAdapter(adapter);
		adjustGridView();

		gvMain.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// Toast.makeText(SectorActivity.this, "" + position,
				// Toast.LENGTH_SHORT).show();
				Intent intent = new Intent();
				intent.putExtra("position", position);
				setResult(RESULT_OK, intent);
				finish();

			}
		});

	}

	private void adjustGridView() {

	}

}
