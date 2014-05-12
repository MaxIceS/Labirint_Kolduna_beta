package com.example.my_game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;

	TextView text_1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		text_1 = (TextView) findViewById(R.id.tvOut);

		text_1.setTypeface(Typeface
				.createFromAsset(getAssets(), "MTCORSVA.TTF"));

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
				MainActivity.this);
		alertDialog.setTitle("Выйти?");

		alertDialog
				.setMessage("Выйти действительно хотите выйти из Страны Сказок?");

		alertDialog.setPositiveButton("Да",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.addCategory(Intent.CATEGORY_HOME);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
					}
				});

		alertDialog.setNegativeButton("Нет",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

		alertDialog.show();
		return;

	}

	@Override
	public void onClick(View v) {
		Intent intent;

		switch (v.getId()) {
		case R.id.btn1:
			intent = new Intent(this, Game.class);
			
			startActivity(intent);
			break;
		case R.id.btn2:
			intent = new Intent(this, Game.class);
			startActivity(intent);
			break;
		case R.id.btn3:
			intent = new Intent(this, Author.class);
			startActivity(intent);
			break;
		case R.id.btn4:
			intent = new Intent(this, Ger.class);
			startActivity(intent);
			break;

		}

	}

}