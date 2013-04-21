package com.example.adapter;

import com.example.listdemo.R;
import com.example.listdemo.R.id;
import com.example.listdemo.R.layout;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyList1Adapter extends BaseAdapter {
int[] num={0,1,2,3,4,5,6,7,8,9,10,11};
Context c;
public MyList1Adapter(Context c){
	this.c=c;
}
	public int getCount() {

		return num.length;
	}

	public Object getItem(int position) {

		return num[position];
	}

	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
View row=convertView;
		if(row==null){
			row=LayoutInflater.from(c).inflate(R.layout.list1_row, null);
		}
		ImageView img=(ImageView)row.findViewById(R.id.imageView1);
		TextView text=(TextView)row.findViewById(R.id.textView1);
		text.setText(String.valueOf(num[position]));
		Log.v("ItemView", "=======>>>"+row.toString()+"   "+num[position]);
		return row;
	}

}
