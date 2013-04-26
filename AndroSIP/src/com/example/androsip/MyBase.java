package com.example.androsip;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyBase extends SQLiteOpenHelper {
 
	private static final String TABLE_NAME = "table_Contact";
	private static final String COL_ID = "ID";
	private static final String COL_SIP = "SIP";
	private static final String COL_NAME = "NAME";
	private static final String COL_IMAGE = "IMAGE";
	
	private static final String CREATE_BDD = "CREATE TABLE " + TABLE_NAME + " ("
			+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_SIP + " TEXT NOT NULL, "
			+ COL_NAME + " TEXT NOT NULL" + COL_IMAGE + " TEXT NOT NULL);";
	
	public MyBase(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BDD);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE " + TABLE_NAME + ";");
		onCreate(db);
	}
 
}