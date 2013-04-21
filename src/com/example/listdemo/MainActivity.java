package com.example.listdemo;

import com.example.adapter.MyList1Adapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView list = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void initView() {
		list = (ListView) findViewById(R.id.test_list1);
        MyList1Adapter adapter=new MyList1Adapter(this);
        list.setAdapter(adapter);
	}
	
}
