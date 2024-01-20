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
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class AddProject extends Activity implements OnClickListener{
	TextView em;
	EditText Name,Mobile,EmailId,Password;
	Button Register;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_project);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		em=(TextView)findViewById(R.id.textView2);
		em.setText(globalvariabel.GetUsername().toString());
		Name=(EditText)findViewById(R.id.editText1);
        Mobile=(EditText)findViewById(R.id.editText2);
        EmailId=(EditText)findViewById(R.id.editText3);
        Password=(EditText)findViewById(R.id.editText4);
        Register=(Button)findViewById(R.id.button1);
        Register.setOnClickListener(this);
        db=openOrCreateDatabase("USERDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS StudentP(Name VARCHAR PRIMARY KEY,Hname VARCHAR,PIname VARCHAR, IGname VARCHAR);");
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
    		
    		else{
    		db.execSQL("INSERT INTO StudentP VALUES('"+Name.getText()+"','"+Mobile.getText()+
    				   "','"+EmailId.getText()+"','"+Password.getText()+"');");
    		showMessage("Success", "Registered Successfully");
    		clearText();
			  }
    	}
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