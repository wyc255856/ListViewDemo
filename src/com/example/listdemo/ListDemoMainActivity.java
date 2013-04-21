package com.example.listdemo;

import android.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ListDemoMainActivity extends Activity implements OnClickListener {

	private Button demo1;
	private Button demo2;
	private Button demo3;
	private Button demo4;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		demo1 = (Button) findViewById(R.id.button1);
		demo2 = (Button) findViewById(R.id.button2);
		demo3 = (Button) findViewById(R.id.button3);
		demo4 = (Button) findViewById(R.id.button4);
		demo1.setOnClickListener(this);
		demo2.setOnClickListener(this);
		demo3.setOnClickListener(this);
		demo4.setOnClickListener(this);

	}

	public void onClick(View v) {
		Intent it = new Intent();
		switch (v.getId()) {
		case R.id.button1:
			it.setClass(this, MainActivity.class);
			startActivity(it);
			break;
		case R.id.button2:
			it.setClass(this, MainActivity2.class);
			startActivity(it);
			break;
		case R.id.button3:
			it.setClass(this, MainActivity3.class);
			startActivity(it);
			break;
		case R.id.button4:
			it.setClass(this, MainActivity4.class);
			startActivity(it);
			break;

		default:
			break;
		}

	}
}
