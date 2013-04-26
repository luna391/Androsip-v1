package com.example.androsip;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	   final Button reg = (Button)findViewById(R.id.bouton);
	   final EditText sip = (EditText) findViewById(R.id.sip);
	   final EditText passwd = (EditText) findViewById(R.id.password);
       reg.setOnClickListener(new View.OnClickListener()
       		{
                       public void onClick(View aView)
                       {
                    	   if (sip.getText().toString().matches("")) {
                    		    Toast.makeText(MainActivity.this, "SIP acount missing", Toast.LENGTH_SHORT).show();}
                    	   else if (passwd.getText().toString().matches("")) {
                   		    Toast.makeText(MainActivity.this, "Password missing", Toast.LENGTH_SHORT).show();}
                    		    else {
                              Intent toAnotherActivity = new Intent(aView.getContext(),SecondActivity.class);
                              startActivityForResult(toAnotherActivity, 0);
                       }
                       }
       		});
}
}
