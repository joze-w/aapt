package com.sg.a_test;

import com.sg.R;
import android.app.Activity;
import android.os.Bundle;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
=

public class MainActivity extends Activity {
	
	 //TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Person person = new Person("张三");
		person.printName();
		//text = (TextView)findViewById(R.id.text);
	}

	
	private void getContacts(){
		   Uri uri = Uri.parse("content://sms/");
		    ContentResolver resolver = getContentResolver();
		    //获取的是哪些列的信息
		    Cursor cursor = resolver.query(uri, new String[]{"address","date","type","body"}, null, null, null);
		    while(cursor.moveToNext())
		    {
		        String address = cursor.getString(0);
		        String date = cursor.getString(1);
		        String type = cursor.getString(2);
		        String body = cursor.getString(3);
		    //  text.append("/n地址:" + address + ",时间:" + date + ",类型:" + type + "/n" +"内容:" + body);
		     
		    }
		    cursor.close();
	}
	
}
