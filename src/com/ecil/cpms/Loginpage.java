package com.ecil.cpms;




import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage extends Activity {
	EditText email, pass;
	Button a;
	 String e;
	 String p;
	 SQLiteDatabase db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loginpage);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		email = (EditText) findViewById(R.id.editText1);
		pass = (EditText) findViewById(R.id.editText2);
		a=(Button) findViewById(R.id.login_btn);
		db=openOrCreateDatabase("USERDB", Context.MODE_PRIVATE, null);
		a.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub			
				if(email.getText().toString().equals("")||pass.getText().toString().equals("")){
					
					Toast.makeText(Loginpage.this, "PLz enter the fields..!", Toast.LENGTH_LONG).show();
				}else{	 
					 e = email.getText().toString();
					 p = pass.getText().toString();
					 try{
						 db=openOrCreateDatabase("USERDB", Context.MODE_PRIVATE, null);					    
					        }catch(Exception exception){
					            exception.printStackTrace();
					        }try{
					        	 Cursor cc = db.rawQuery("select * from Student where EmailId = '"+e+"' and Password = '"+p+"' ", null);
					        	 Cursor cc1 = db.rawQuery("select * from HOD where EmailId = '"+e+"' and Password = '"+p+"' ", null);
					        	 Cursor cc2 = db.rawQuery("select * from Incharge where EmailId = '"+e+"' and Password = '"+p+"' ", null);
					        	 Cursor cc3 = db.rawQuery("select * from Guide where EmailId = '"+e+"' and Password = '"+p+"' ", null);
					        	 if(email.getText().toString().equals("admin")&& pass.getText().toString().equals("admin")){
					        		 Toast.makeText(Loginpage.this, "Welcome To Admin Home Page "  + e , Toast.LENGTH_LONG).show();
					            		Intent i = new Intent(Loginpage.this,Adminhome.class);
					            		startActivity(i);
									}
					        	 // Student Login
					        	 else if(cc.moveToFirst())
					        		 {String temp="";					       
						            if (cc != null) {
						            	if(cc.getCount() > 0)
						            	{
						            	//return true;
						            scan g=new scan();
						            g.execute();
						            
						            		Toast.makeText(Loginpage.this, "Welcome To Student Home Page "  + e , Toast.LENGTH_LONG).show();
						            		globalvariabel.Setusername(email.getText().toString());
						            		Intent i = new Intent(Loginpage.this,Studenthome.class);
						            		startActivity(i);
						            	}else{
						            		 Toast.makeText(Loginpage.this, "Enter Correct Username And Password..!", Toast.LENGTH_LONG).show();
						            	}
						            	}
					        		 }
					        	 // HOD Login
					        	 else if(cc1.moveToFirst())
					        		 {
					        		 String temp="";					       
						            if (cc1 != null) {
						            	if(cc1.getCount() > 0)
						            	{
						            	//return true;
						            		scan g=new scan();
						            		g.execute();
						            
						            		Toast.makeText(Loginpage.this, "Welcome To HOD Home Page "  + e , Toast.LENGTH_LONG).show();
						            		globalvariabel.Setusername(email.getText().toString());
						            		Intent i = new Intent(Loginpage.this,HODhome.class);
						            		startActivity(i);
						            	}else{
						            		 Toast.makeText(Loginpage.this, "Enter Correct Username And Password..!", Toast.LENGTH_LONG).show();
						            	}
						            	}
					        		 }
					        	 // Icharge Login
					        	 else if(cc2.moveToFirst())
					        		 {String temp="";					       
						            if (cc2 != null) {
						            	if(cc2.getCount() > 0)
						            	{
						            	//return true;
						            scan g=new scan();
						            g.execute();
						            
						            		Toast.makeText(Loginpage.this, "Welcome To Incharge Home Page "  + e , Toast.LENGTH_LONG).show();
						            		globalvariabel.Setusername(email.getText().toString());
						            		Intent i = new Intent(Loginpage.this,Inchargehome.class);
						            		startActivity(i);
						            	}else{
						            		 Toast.makeText(Loginpage.this, "Enter Correct Username And Password..!", Toast.LENGTH_LONG).show();
						            	}
						            	}
					        		 }


					        	//Guide Login
					        	 else if(cc3.moveToFirst())
					        	 {
					        		 String temp="";					       
							            if (cc3 != null) {
							            	if(cc3.getCount() > 0)
							            	{
							            	//return true;
							            		scan g=new scan();
							            		g.execute();
							            		Toast.makeText(Loginpage.this, "Welcome To Guide Home Page "  + e , Toast.LENGTH_LONG).show();
							            		globalvariabel.Setusername(email.getText().toString());	
						            		Intent i = new Intent(Loginpage.this,Guidehome.class);
							            		startActivity(i);
							            	}
							            	}
						        		 } 
						            //	return false;
					        	 else
					            	{
					            		 Toast.makeText(Loginpage.this, "Enter Correct Username And Password..!", Toast.LENGTH_LONG).show();
					            	}
					        }catch(Exception exception){
					            exception.printStackTrace();
					        }
						}	 	
				}
		});
		
	
		
		
	}
	public class scan extends AsyncTask<String, String, String>{

		private ProgressDialog pd;

		protected void onPreExecute() {
			super.onPreExecute();
		 pd = new ProgressDialog(Loginpage.this);
		 pd.setTitle("Please Wait");
		 pd.setMessage("Logging....");
		 pd.setMax(200);
		 pd.show();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	

	

}
