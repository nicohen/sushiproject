package com.nmc.HelloAndroid.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.nmc.HelloAndroid.R;

public class OrderCursorAdapter extends SimpleCursorAdapter {

	private LayoutInflater mInflater;
	private Cursor mCursor;
	
	public OrderCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
		super(context, layout, c, from, to);
		this.mInflater = LayoutInflater.from(context);
		this.mCursor = c;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.order_list_row, null);
			
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.order_title);
			holder.image = (ImageView) convertView.findViewById(R.id.TextView01);
		
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		mCursor.moveToPosition(position);
		
		int index = mCursor.getColumnIndex("title");
		String title = mCursor.getString(index);
		holder.title.setText(title);
		holder.image.setBackgroundResource(products[position]);

		return convertView;
	}
	
	static class ViewHolder {
		ImageView image;
		TextView title;
	}

	public int getCount() {
		return products.length;
	}

	private static final int[] products = { R.drawable.buenosaires,
		R.drawable.california, R.drawable.crazy, R.drawable.feel,
		R.drawable.futurama, R.drawable.geishas, R.drawable.honey,
		R.drawable.hot, R.drawable.newyork, R.drawable.philadelphia,
		R.drawable.placerreal, R.drawable.salmonskin, R.drawable.sc,
		R.drawable.smoke, R.drawable.soul, R.drawable.spf,
		R.drawable.tamago, R.drawable.tiago };
}
