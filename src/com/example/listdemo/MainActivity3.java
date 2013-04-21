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
		String data = "{\"data\":[{\"name\":\"С��\",\"sex\":\"�Ա���\",\"year\":\"���䣺21\",\"zhiwei\":\"ְλ��ѧ��\"},{\"name\":\"С��\",\"sex\":\"�Ա�Ů\",\"year\":\"���䣺20\",\"zhiwei\":\"ְλ��ѧ��\"},{\"name\":\"Сǿ\",\"sex\":\"�Ա���\",\"year\":\"���䣺23\",\"zhiwei\":\"ְλ������\"},{\"name\":\"С��\",\"sex\":\"�Ա���\",\"year\":\"���䣺42\",\"zhiwei\":\"ְλ������\"},{\"name\":\"С��\",\"sex\":\"�Ա���\",\"year\":\"���䣺31\",\"zhiwei\":\"ְλ����ʦ\"}]}";
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
