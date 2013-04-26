package com.example.androsip;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FilterQueryProvider;

public class ContactActivity extends Activity {
	private ContactDB dbHelper;
	 private SimpleCursorAdapter dataAdapter;
	 final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
	Button add = (Button) findViewById(R.id.addcontact);
    dbHelper = new ContactDB(this);
	 dbHelper.open();
	  
	displayListView();
	
	add.setOnClickListener(new View.OnClickListener() {
		
		@Override

        public void onClick(View aView)
        {
               Intent intent = new Intent(aView.getContext(),AddconActivity.class);
               startActivityForResult(intent, 5);
        }});
	}
	
	
	private void displayListView() {
		 
		 
		  Cursor cursor = dbHelper.fetchAllContacts();
		 
		  // The desired columns to be bound
		  String[] columns = new String[] {
				  ContactDB.COL_NAME,
				ContactDB.COL_IMAGE
		  };
		 
		  // the XML defined views which the data will be bound to
		  int[] to = new int[] {
		    R.id.namecon,
		  R.id.imagecon
		  };
		 
		  // create the adapter using the cursor pointing to the desired data 
		  //as well as the layout information
		  dataAdapter = new SimpleCursorAdapter(
		    this, R.layout.affichage_liste, cursor,  columns,  to,0);
		 
		  ListView listView = (ListView) findViewById(R.id.list);
		  // Assign adapter to ListView
		  listView.setAdapter(dataAdapter);
		
		 
		  listView.setOnItemClickListener(new OnItemClickListener() {
		   @Override
		   public void onItemClick(AdapterView<?> listView, View view, 
		     int position, long id) {
		   // Get the cursor, positioned to the corresponding row in the result set
		   Cursor cursor = (Cursor) listView.getItemAtPosition(position);
		  final String namecontact =cursor.getString(cursor.getColumnIndexOrThrow("name"));
		final Dialog dialog = new Dialog(context);
			dialog.setContentView(R.layout.dialog);
			dialog.setTitle("Settings");
			dialog.getWindow().setLayout(400, 400);
			Button modif = (Button) dialog.findViewById(R.id.modif);
			Button supp = (Button) dialog.findViewById(R.id.supp);
			modif.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View aView) {
					Intent intent = new Intent(aView.getContext(),ModifconActivity.class);
	                   startActivityForResult(intent, 7);
					
				}	
			}
			);
			supp.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View aView) {
					dbHelper.removeContactwithName(namecontact);
					Intent intent = new Intent(aView.getContext(),ContactActivity.class);
	                   startActivityForResult(intent, 8);
				
			}});
			dialog.show();
		   }
		  });
		 
		  EditText myFilter = (EditText) findViewById(R.id.myFilter);
		  myFilter.addTextChangedListener(new TextWatcher() {
		 
		   public void afterTextChanged(Editable s) {
		   }
		 
		   public void beforeTextChanged(CharSequence s, int start, 
		     int count, int after) {
		   }
		 
		   public void onTextChanged(CharSequence s, int start, 
		     int before, int count) {
		    dataAdapter.getFilter().filter(s.toString());
		   }
		  });
		   
		  dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
		         public Cursor runQuery(CharSequence constraint) {
		             return dbHelper.fetchContactByName(constraint.toString());
		         }
		     });
		 
		 }
}
