package com.nmc.HelloAndroid;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OrderActivity extends Activity {
	
	private static class EfficientAdapter extends BaseAdapter {
		private LayoutInflater mInflater;
		private Resources resources;

		public EfficientAdapter(Context context, Resources resources) {
			mInflater = LayoutInflater.from(context);
			this.resources = resources;
		}

		public int getCount() {
			return products.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.listview, null);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView.findViewById(R.id.TextView01);
				holder.description = (TextView) convertView.findViewById(R.id.TextView02);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.image.setBackgroundResource(products[position]);
			holder.description.setText(resources.getResourceEntryName(products[position]));

			return convertView;
		}

		static class ViewHolder {
			ImageView image;
			TextView description;
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_layout);
		ListView l1 = (ListView) findViewById(R.id.ListView01);
		l1.setAdapter(new EfficientAdapter(this,getResources()));
	}

	private static final int[] products = { R.drawable.buenosaires, R.drawable.california, 
		R.drawable.crazy, R.drawable.feel, R.drawable.futurama, R.drawable.geishas, R.drawable.honey, 
		R.drawable.hot, R.drawable.newyork, R.drawable.philadelphia, R.drawable.placerreal, R.drawable.salmonskin, 
		R.drawable.sc, R.drawable.smoke, R.drawable.soul, R.drawable.spf, R.drawable.tamago, R.drawable.tiago};

}
