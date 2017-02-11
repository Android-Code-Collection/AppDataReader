package com.awesomedroidapps.inappstoragereader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.awesomedroidapps.inappstoragereader.entity.Person;

/**
 * Created by anshul on 11/2/17.
 */

public class DataReaderSqliteOpenHelper extends SQLiteOpenHelper {

  public static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "person.db";
  public static final String TABLE_NAME = "person_info";
  public static final String COLUMN_ID = "id";
  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_SURNAME = "surname";
  private SQLiteDatabase sqLiteDatabase;

  private static final String SQL_CREATE_ENTRIES =
      "CREATE TABLE " + TABLE_NAME + " (" +
          COLUMN_ID + " INTEGER PRIMARY KEY," +
          COLUMN_NAME + " TEXT," +
          COLUMN_SURNAME + " TEXT)";

  public DataReaderSqliteOpenHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  public void insert(Person person) {
// Gets the data repository in write mode
    SQLiteDatabase db = getWritableDatabase();

// Create a new map of values, where column names are the keys
    ContentValues values = new ContentValues();
    values.put(COLUMN_NAME, person.getName());
    values.put(COLUMN_SURNAME, person.getSurName());

    db.insert(TABLE_NAME, null, values);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    System.out.println("inside on Create");
    System.out.println(SQL_CREATE_ENTRIES);
    sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    //Do nothing
  }

  public void getAllTables(){
    Cursor c = getWritableDatabase().rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

    if (c.moveToFirst()) {
      while ( !c.isAfterLast() ) {
        System.out.println(c.getString(0));
        c.moveToNext();
      }
    }
  }
}
