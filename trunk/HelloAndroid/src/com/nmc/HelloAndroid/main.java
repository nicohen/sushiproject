package com.nmc.HelloAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class main extends Activity {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.new2:
			newGame();
			return true;
		case R.id.open:
			quit();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void quit() {
		TextView text = (TextView) findViewById(R.id.text);
		text.setText("Apreto quit");
	}

	private void newGame() {
		TextView text = (TextView) findViewById(R.id.text);
		text.setText("Apreto new_game");
	}
}