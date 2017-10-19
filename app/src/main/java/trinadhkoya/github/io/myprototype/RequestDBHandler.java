package trinadhkoya.github.io.myprototype;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by trinadhkoya on 19/10/17.
 */


public class RequestDBHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "requests.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_REQUESTS = "requests";
    public static final String COLUMN_ID = "requestId";
    public static final String COLUMN_REQUEST_DATA = "requestdata";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_CREATED_DATE = "hiredata";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_REQUESTS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_REQUEST_DATA + " TEXT, " +
                    COLUMN_STATUS + " TEXT, " +
                    COLUMN_CREATED_DATE + " NUMERIC)";


    public RequestDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REQUESTS);
        db.execSQL(TABLE_CREATE);
    }
}