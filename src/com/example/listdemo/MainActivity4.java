package com.example.listdemo;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.MyAdapter;
import com.example.adapter.MyListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

public class MainActivity4 extends Activity {
	private MyAdapter mAdapter;  
	private MyListView mListView;  
	private List<String> mList;  
	    @Override  
	    public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.activity_main);  
	        init();  
	    }  
	  
	    private void init() {  
	        mList=new ArrayList<String>();  
	        String a="";  
	        for(int i=0;i<26;i++){  
	            a=((char)('A'+i))+"";  
	            mList.add(a);  
	            mList.add(a);  
	            mList.add(a);  
	        }  
	        mListView=(MyListView)findViewById(R.id.lv);  
	        mAdapter=new MyAdapter();  
	        mAdapter.update(mList,MainActivity4.this);  
	        mListView.setTitle(LayoutInflater.from(MainActivity4.this).inflate(R.layout.title, mListView, false));  
	        mListView.setAdapter(mAdapter);  
	        mListView.setOnScrollListener(mAdapter);  
	          
	    }  
	}  