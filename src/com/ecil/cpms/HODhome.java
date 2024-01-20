package com.ecil.cpms;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HODhome extends Activity {
	TextView em;
	SQLiteDatabase db;
	Button b2,b3,b4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hodhome);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		em=(TextView)findViewById(R.id.textView2);
		em.setText(globalvariabel.GetUsername().toString());
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.button4);
		db=openOrCreateDatabase("USERDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS HOD(Name VARCHAR PRIMARY KEY,Mobile VARCHAR,EmailId VARCHAR, Password NUMBER);");
		db.execSQL("CREATE TABLE IF NOT EXISTS StudentP(Name VARCHAR PRIMARY KEY,Hname VARCHAR,PIname VARCHAR, IGname VARCHAR);");
		
		b4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent aa=new Intent(HODhome.this,MainActivity.class);
			startActivity(aa);
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor c=db.rawQuery("SELECT * FROM StudentP", null);
	    		if(c.getCount()==0)
	    		{
	    			showMessage("Error", "No records found");
	    			return;
	    		}
	    		StringBuffer buffer=new StringBuffer();
	    		while(c.moveToNext())
	    		{
	    			buffer.append("Name: "+c.getString(0)+"\n");
	    			buffer.append("Hod Name: "+c.getString(1)+"\n");
	    			buffer.append("PI Name: "+c.getString(2)+"\n");
	    			buffer.append("IG Name: "+c.getString(3)+"\n");
	    			buffer.append("\n");
	    		}
	    		showMessage("Project Details", buffer.toString());
				
			}
		});
		
		b3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor c=db.rawQuery("SELECT * FROM HOD WHERE EmailId='"+em.getText()+"'", null);
	    		if(c.getCount()==0)
	    		{
	    			showMessage("Error", "No records found");
	    			return;
	    		}
	    		StringBuffer buffer=new StringBuffer();
	    		while(c.moveToNext())
	    		{
	    			buffer.append("Name: "+c.getString(0)+"\n");
	    			buffer.append("Mobile: "+c.getString(1)+"\n");
	    			buffer.append("Password: "+c.getString(3)+"\n");
	    		}
	    		showMessage("User Profile", buffer.toString());
				
			}
		});
		
		
	}
	public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
}
