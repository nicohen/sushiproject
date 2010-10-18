package com.nmc.HelloAndroid;

import android.app.ListActivity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;

import com.nmc.HelloAndroid.adapter.DbAdapter;
import com.nmc.HelloAndroid.adapter.OrderCursorAdapter;

public class OrderActivity extends ListActivity {

	private DbAdapter mDbHelper;
	private Cursor mCursor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_layout);
		mDbHelper = new DbAdapter(this);
		mDbHelper.open();
		initProducts(getResources());
		fillData();
		registerForContextMenu(getListView());
	}

	private void initProducts(Resources resources) {
		for (int i = 0; i < products.length; i++) {
			mDbHelper.createProduct(
					capitalize(resources.getResourceEntryName(products[i])), 1,
					"");
		}
	}

	private void fillData() {
		// Get all of the rows from the database and create the item list
		mCursor = mDbHelper.fetchAllProducts();
		startManagingCursor(mCursor);

		// Create an array to specify the fields we want to display in the list
		// (TITLE)
		String[] from = new String[] { DbAdapter.KEY_TITLE };

		// and an array of the fields we want to bind those fields to (in this
		// case just order_row)
		int[] to = new int[] { R.id.order_title };

		// Now create a simple cursor adapter and set it to display
		OrderCursorAdapter notes = new OrderCursorAdapter(this,
				R.layout.order_list_row, mCursor, from, to);
		setListAdapter(notes);
	}

	public static String capitalize(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	private static final int[] products = { R.drawable.buenosaires,
			R.drawable.california, R.drawable.crazy, R.drawable.feel,
			R.drawable.futurama, R.drawable.geishas, R.drawable.honey,
			R.drawable.hot, R.drawable.newyork, R.drawable.philadelphia,
			R.drawable.placerreal, R.drawable.salmonskin, R.drawable.sc,
			R.drawable.smoke, R.drawable.soul, R.drawable.spf,
			R.drawable.tamago, R.drawable.tiago };

}
