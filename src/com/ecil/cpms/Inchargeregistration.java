package com.ecil.cpms;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Inchargeregistration extends Activity implements OnClickListener{
	EditText Name,EmailId,Password,Mobile;
	Button Register;
	SQLiteDatabase db;
	String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inchargeregistration);
        Name=(EditText)findViewById(R.id.editText1);
        EmailId=(EditText)findViewById(R.id.editText2);
        Password=(EditText)findViewById(R.id.editText3);
        Mobile=(EditText)findViewById(R.id.editText4);
        Register=(Button)findViewById(R.id.button1);
        Register.setOnClickListener(this);
        db=openOrCreateDatabase("USERDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Incharge(Name VARCHAR PRIMARY KEY,EmailId VARCHAR,Password VARCHAR, Mobile NUMBER);");
	}
	public void onClick(View ad)
    {
    	if(ad==Register)
    	{
    		if(Name.getText().toString().trim().length()==0||
    		   EmailId.getText().toString().trim().length()==0||
    		   Password.getText().toString().trim().length()==0||
    		   
    		   Mobile.getText().toString().trim().length()==0)
    		{
    			showMessage("Error", "Please enter all values");
    			return;
    		}
    		else if(Mobile.getText().toString().length()!=10){
				  Toast.makeText(Inchargeregistration.this, "Enter 10 digits",Toast.LENGTH_LONG).show();
			  }
    		else if(!EmailId.getText().toString().trim().matches(emailPattern))
    		{
    			Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
    		}
    		
    		
    		else{
    		db.execSQL("INSERT INTO Incharge VALUES('"+Name.getText()+"','"+EmailId.getText()+
    				   "','"+Password.getText()+"','"+Mobile.getText()+"');");
    		showMessage("Success", "Incharge Registered Successfully");
    		clearText();
			  }
    	}
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inchargeregistration, menu);
		return true;
	}
	public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
    public void clearText()
    {
    	Name.setText("");
    	EmailId.setText("");
    	Password.setText("");
    	Mobile.setText("");
    	EmailId.requestFocus();
    }

}
