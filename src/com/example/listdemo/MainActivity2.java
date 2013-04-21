package com.example.listdemo;

import com.example.adapter.Demo2Adapter;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity2 extends Activity {
	private Demo2Adapter adapter=null;
private ListView list=null;
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main2);
	char[] strA={'A','B','C','D','E'};
	String[] strB={"Asef","BssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBssBss","Be","Cc","Ccc","Dd","De","Ea"};
	list=(ListView)findViewById(R.id.list_demo2);
	adapter=new Demo2Adapter(this);
	for (int i = 0; i < strA.length; i++) {
		 adapter.addSeparatorItem(String.valueOf(strA[i]));
		for(int j=0;j<strB.length;j++){
			
			if(strB[j].charAt(0)==strA[i]||strB[j].charAt(0)==strA[i]+26){
				Log.v("item", String.valueOf(strB[j].charAt(0)));
				 adapter.addItem(strB[j]);
			}
		}
//       adapter.addItem("item " + i);
//        if (i % 4 == 0) {
//            adapter.addSeparatorItem("separator " + i);
  //      }
    }
	list.setAdapter(adapter);
	
}




}
