package com.example.androsip;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		final Button btnDial = (Button)findViewById(R.id.btnDial);
		final EditText number = (EditText) findViewById(R.id.txtNumber);
	
		btnDial.setOnClickListener(new View.OnClickListener() {
			
			@Override
			
		public void onClick(View v) {

			Intent dialIntent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+(number.getText()).toString()));

			startActivity(dialIntent);
			   }
			  });
	}

}
