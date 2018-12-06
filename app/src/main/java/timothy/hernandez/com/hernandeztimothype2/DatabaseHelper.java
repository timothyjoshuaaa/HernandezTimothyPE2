package timothy.hernandez.com.hernandeztimothype2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    final static String DBName = "data.db";
    final static int VER = 1;
    Cursor res;
    final static String TABLE_NAME = "data";
    final static String Fname = "";

    public DatabaseHelper(Context context) {
        super(context, DBName, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE lgrade (ID_INTEGER_PRIMARY_KEY_AUTOINCREMENT, Fname_TEXT, Age_INTEGER, GENDER_TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "  + TABLE_NAME);
    onCreate(db);
    }

    public boolean save(String name, int age, String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Fname", name);
        cv.put("Age", age);
        cv.put("Gender", gender);
        long inserted = db.insert(TABLE_NAME, null, cv);
        if(inserted == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor selectAllRecords(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM data", null);
    }


}
