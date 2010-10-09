package com.nmc.HelloAndroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.order_id:
			order();
			return true;
		case R.id.cart_id:
			cart();
			return true;
		case R.id.about_id:
			about();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void about() {
		Intent myIntent = new Intent(MainActivity.this, AboutActivity.class);
		MainActivity.this.startActivity(myIntent);
	}

	private void cart() {
		Intent myIntent = new Intent(MainActivity.this, CartActivity.class);
		MainActivity.this.startActivity(myIntent);
	}

	private void order() {
		Intent myIntent = new Intent(MainActivity.this, OrderActivity.class);
		MainActivity.this.startActivity(myIntent);
	}


}