package com.example.irespond;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.irespond.ui.home.HomeFragment;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "irespond01";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "iresponders";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our name column
    private static final String FNAME_COL = "fName";
    private static final String MNAME_COL = "mName";
    private static final String LNAME_COL = "lName";
    private static final String EXT_COL = "ext";

    // below variable id for our gender column.
    private static final String GENDER_COL = "gender";

    // below variable id for our age column.
    private static final String AGE_COL = "age";

    // below variable for our email address column.
    private static final String EMAILADD_COL = "emailadd";

    // below variable is for our username column.
    private static final String USERNAME_COL = "username";

    // below variable is for our passowrd column.
    private static final String PASSWORD_COL = "password";

    // below variable is for our retype password column.
    private static final String REPASSWORD_COL = "repassword";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query

    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FNAME_COL + " TEXT,"
                + MNAME_COL + " TEXT,"
                + LNAME_COL + " TEXT,"
                + AGE_COL + " TEXT,"
                + USERNAME_COL + " TEXT,"
                + EMAILADD_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + REPASSWORD_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    public void addFirst(String getfName, String getmName, String getlName,
                         String getage, String getusername, String getemailadd, String getpassword, String getrepass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FNAME_COL, getfName);
        values.put(MNAME_COL, getmName);
        values.put(LNAME_COL, getlName);
        values.put(AGE_COL, getage);
        values.put(USERNAME_COL, getusername);
        values.put(EMAILADD_COL, getemailadd);
        values.put(PASSWORD_COL, getpassword);
        values.put(REPASSWORD_COL, getrepass);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /*public void add2ndPage(String gender, String age, String bDay, String fullName){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Update irespondusers SET gender = ?, age = ?, bDay = ? where fullname is = ?", new String[] {gender, age, bDay, fullName});

    }*/

    /*public Boolean checkaccount (String getusername, String getpass){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {getusername, getpass});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }*/

}