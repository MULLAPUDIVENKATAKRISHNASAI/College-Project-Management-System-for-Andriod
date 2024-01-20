package com.ecil.cpms;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Studentregistration extends Activity implements OnClickListener{
	EditText Name,Mobile,EmailId,Password;
	Button Register;
	SQLiteDatabase db;
	String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studentregistration);
        Name=(EditText)findViewById(R.id.editText1);
        Mobile=(EditText)findViewById(R.id.editText2);
        EmailId=(EditText)findViewById(R.id.editText3);
        Password=(EditText)findViewById(R.id.editText4);
        Register=(Button)findViewById(R.id.button1);
        Register.setOnClickListener(this);
        db=openOrCreateDatabase("USERDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Student(Name VARCHAR PRIMARY KEY,Mobile VARCHAR,EmailId VARCHAR, Password NUMBER);");
	}
	public void onClick(View ad)
    {
    	if(ad==Register)
    	{
    		if(Name.getText().toString().trim().length()==0||
    		   Mobile.getText().toString().trim().length()==0||
    		   EmailId.getText().toString().trim().length()==0||
    		   
    		   Password.getText().toString().trim().length()==0)
    		{
    			showMessage("Error", "Please enter all values");
    			return;
    		}
    		else if(Mobile.getText().toString().length()!=10){
				  Toast.makeText(Studentregistration.this, "Enter 10 digits",Toast.LENGTH_LONG).show();
			  }
    		else if(!EmailId.getText().toString().trim().matches(emailPattern))
    		{
    			Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
    		}
    		
    		
    		else{
    		db.execSQL("INSERT INTO Student VALUES('"+Name.getText()+"','"+Mobile.getText()+
    				   "','"+EmailId.getText()+"','"+Password.getText()+"');");
    		showMessage("Success", "Student Registered Successfully");
    		clearText();
			  }
    	}
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.studentregistration, menu);
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
    	Mobile.setText("");
    	EmailId.setText("");
    	Password.setText("");
    	EmailId.requestFocus();
    }

}
