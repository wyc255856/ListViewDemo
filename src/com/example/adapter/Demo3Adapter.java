package com.example.adapter;

import java.util.ArrayList;
import java.util.TreeSet;

import com.example.listdemo.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("ResourceAsColor")
public class Demo3Adapter extends BaseAdapter {


	 private static final int TYPE_ITEM1 = 0;
    private static final int  TYPE_ITEM2 = 1;
    private static final int  TYPE_ITEM3 = 2;
    private static final int  TYPE_ITEM4 = 3;
    private static final int TYPE_MAX_COUNT =  TYPE_ITEM4 + 1;

    private ArrayList mData = new ArrayList();
    private LayoutInflater mInflater;

    private TreeSet mSeparatorsSet1 = new TreeSet();
    private TreeSet mSeparatorsSet2 = new TreeSet();
    private TreeSet mSeparatorsSet3 = new TreeSet();
    private TreeSet mSeparatorsSet4 = new TreeSet();
   public Demo3Adapter(Context c) {
       mInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   }

   public void addItem(final String item) {
       mData.add(item);
       notifyDataSetChanged();
   }

   public void addSeparatorItem1(final String item) {
       mData.add(item);
       // save separator position
       mSeparatorsSet1.add(mData.size() - 1);
       notifyDataSetChanged();
   }
   public void addSeparatorItem2(final String item) {
       mData.add(item);
       // save separator position
       mSeparatorsSet2.add(mData.size() - 1);
       notifyDataSetChanged();
   }
   public void addSeparatorItem3(final String item) {
       mData.add(item);
       // save separator position
       mSeparatorsSet3.add(mData.size() - 1);
       notifyDataSetChanged();
   }
   public void addSeparatorItem4(final String item) {
       mData.add(item);
       // save separator position
       mSeparatorsSet4.add(mData.size() - 1);
       notifyDataSetChanged();
   }

   @Override
   public int getItemViewType(int position) {
        if(mSeparatorsSet1.contains(position)){
        	return TYPE_ITEM1;
        }else if(mSeparatorsSet2.contains(position)){
        	return TYPE_ITEM2;
        }else if(mSeparatorsSet3.contains(position)){
        	return TYPE_ITEM3;
        }else if(mSeparatorsSet4.contains(position)){
        	return TYPE_ITEM4;
        }else{
        	return 0;
        }
	   
	
   }

   @Override
   public int getViewTypeCount() {
       return TYPE_MAX_COUNT;
   }

   @Override
   public int getCount() {
       return mData.size();
   }

   @Override
   public String getItem(int position) {
       return mData.get(position).toString();
   }

   @Override
   public long getItemId(int position) {
       return position;
   }

   @SuppressLint("ResourceAsColor")
@Override
   public View getView(int position, View convertView, ViewGroup parent) {
       
       int type = getItemViewType(position);
       System.out.println("getView " + position + " " + convertView + " type = " + type);
       TextView textView = null;
       if (convertView == null) {
       	
           switch (type) {
               case TYPE_ITEM1:
                   convertView = mInflater.inflate(R.layout.demo2_item1, null);
                  textView = (TextView)convertView.findViewById(R.id.demo2_textView1);
                   break;
               case TYPE_ITEM2:
                   convertView = mInflater.inflate(R.layout.demo2_item2, null);
                 textView = (TextView)convertView.findViewById(R.id.demo2_textView2);
                   break;
               case TYPE_ITEM3:
                   convertView = mInflater.inflate(R.layout.demo3_item1, null);
                 textView = (TextView)convertView.findViewById(R.id.demo3_textView1);
                
                   break;
               case TYPE_ITEM4:
                   convertView = mInflater.inflate(R.layout.demo3_item2, null);
                 textView = (TextView)convertView.findViewById(R.id.demo3_textView2);
         
                   break;
           }
           convertView.setTag(textView);
       } else {
           textView = (TextView)convertView.getTag();
       }
     textView.setText(mData.get(position).toString());
       return convertView;
   }

}
