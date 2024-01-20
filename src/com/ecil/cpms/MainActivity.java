package com.ecil.cpms;





import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends Activity 
{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		    Button sr,hr,ir,gr,log;
	        sr=(Button)findViewById(R.id.button1);
	        hr=(Button)findViewById(R.id.button2);
	        ir=(Button)findViewById(R.id.button3);
	        gr=(Button)findViewById(R.id.button4);
	        log=(Button)findViewById(R.id.button5);
	        
	        sr.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
		 			// TODO Auto-generated method stub
					Intent ad= new Intent(MainActivity.this,Studentregistration.class);
					startActivity(ad);
				}
	        	 });
	        
	        hr.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
		 			// TODO Auto-generated method stub
					Intent ad= new Intent(MainActivity.this,HODregistration.class);
					startActivity(ad);
				}
	        	 });
	        ir.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
		 			// TODO Auto-generated method stub
					Intent ad= new Intent(MainActivity.this,Inchargeregistration.class);
					startActivity(ad);
				}
	        	 });
	        gr.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
		 			// TODO Auto-generated method stub
					Intent ad= new Intent(MainActivity.this,Guideregistration.class);
					startActivity(ad);
				}
	        	 });
	        log.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
		 			// TODO Auto-generated method stub
					Intent ad= new Intent(MainActivity.this,Loginpage.class);
					startActivity(ad);
				}
	        	 });
		
		
	}
	
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
}



}
