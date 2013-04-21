package com.example.listdemo;

import java.util.List;
import java.util.Map;

import com.example.adapter.AsyJsonData;
import com.example.adapter.Demo3Adapter;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity3 extends Activity {
	private ListView list = null;
	private Map<?, ?> datamap = null;
	Demo3Adapter adapter;
	List<Map> listdata=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		list = (ListView) findViewById(R.id.demo3_listView);
		getData();
		showList();

	}

	private void getData() {
		String data = "{\"data\":[{\"name\":\"小李\",\"sex\":\"性别：男\",\"year\":\"年龄：21\",\"zhiwei\":\"职位：学生\"},{\"name\":\"小红\",\"sex\":\"性别：女\",\"year\":\"年龄：20\",\"zhiwei\":\"职位：学生\"},{\"name\":\"小强\",\"sex\":\"性别：男\",\"year\":\"年龄：23\",\"zhiwei\":\"职位：工人\"},{\"name\":\"小宋\",\"sex\":\"性别：男\",\"year\":\"年龄：42\",\"zhiwei\":\"职位：保安\"},{\"name\":\"小明\",\"sex\":\"性别：男\",\"year\":\"年龄：31\",\"zhiwei\":\"职位：老师\"}]}";
		AsyJsonData asyJsonData = new AsyJsonData();
		Map<?, ?> resultMap = asyJsonData
				.parseData(data);
		
		//datamap = (Map<?, ?>) 
		listdata=(List<Map>) resultMap.get("data");
		
	}

	private void showList() {
		adapter = new Demo3Adapter(this);
		for(int i=0;i<listdata.size();i++){
			
			adapter.addSeparatorItem1(listdata.get(i).get("name").toString());
			adapter.addSeparatorItem2(listdata.get(i).get("sex").toString());
			Log.e("111", listdata.get(i).get("year").toString());
			adapter.addSeparatorItem3(listdata.get(i).get("year").toString());
			adapter.addSeparatorItem4(listdata.get(i).get("zhiwei").toString());
		}
		list.setAdapter(adapter);
		
	}
}
