package com.example.androsip;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	
		final Button dialer = (Button)findViewById(R.id.dialer);
		final Button log = (Button)findViewById(R.id.log);
		final Button contact = (Button)findViewById(R.id.contact);
		final Button config = (Button)findViewById(R.id.config);
		dialer.setOnClickListener(new View.OnClickListener() {
			
			@Override

            public void onClick(View aView)
            {
                   Intent intent = new Intent(aView.getContext(),CallActivity.class);
                   startActivityForResult(intent, 1);
            }
			
		}
		);
	contact.setOnClickListener(new View.OnClickListener() {
			
			@Override

            public void onClick(View aView)
            {
                   Intent intent = new Intent(aView.getContext(),ContactActivity.class);
                   startActivityForResult(intent, 2);
            }
			
		}
		);
	log.setOnClickListener(new View.OnClickListener() {
		
		@Override

        public void onClick(View aView)
        {
               Intent intent = new Intent(aView.getContext(),LogActivity.class);
               startActivityForResult(intent, 3);
        }
		
	}
	);
	config.setOnClickListener(new View.OnClickListener() {
		
		@Override

        public void onClick(View aView)
        {
               Intent intent = new Intent(aView.getContext(),SettingsActivity.class);
               startActivityForResult(intent, 4);
        }
		
	}
	);
	
	}

}
