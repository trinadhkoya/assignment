package trinadhkoya.github.io.myprototype;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by trinadhkoya on 19/10/17.
 */


public class RequestOperations {
    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;


    private static final String[] allColumns = {
            RequestDBHandler.COLUMN_ID,
            RequestDBHandler.COLUMN_REQUEST_DATA,
            RequestDBHandler.COLUMN_STATUS,
            RequestDBHandler.COLUMN_CREATED_DATE
    };

    public RequestOperations(Context context) {
        dbhandler = new RequestDBHandler(context);
    }

    public void open() {
        Log.i(LOGTAG, "Database Opened");
        database = dbhandler.getWritableDatabase();


    }

    public void close() {
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }


    public Request addRequest(Request Request) {
        ContentValues values = new ContentValues();
        values.put(RequestDBHandler.COLUMN_REQUEST_DATA, Request.getRequestTitle());
        values.put(RequestDBHandler.COLUMN_STATUS, Request.getStatus());
        values.put(RequestDBHandler.COLUMN_CREATED_DATE, Request.getCreatedDate());
        long insertid = database.insert(RequestDBHandler.TABLE_REQUESTS, null, values);
        Request.setReqId(insertid);
        return Request;

    }

    // Getting single Request
    public Request getRequest(long id) {

        Cursor cursor = database.query(RequestDBHandler.TABLE_REQUESTS, allColumns, RequestDBHandler.COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Request e = new Request(Long.parseLong(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return Request
        return e;
    }

    public List<Request> getAllRequests() {

        Cursor cursor = database.query(RequestDBHandler.TABLE_REQUESTS, allColumns, null, null, null, null, null);

        List<Request> requests = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Request request = new Request();
                request.setReqId(cursor.getLong(cursor.getColumnIndex(RequestDBHandler.COLUMN_ID)));
                request.setRequestTitle(cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_REQUEST_DATA)));
                request.setStatus(cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_STATUS)));
                request.setCreatedDate(cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_CREATED_DATE)));
                requests.add(request);
            }
        }
        return requests;
    }


    public List<Request> getAcceptedRequests() {

        Cursor cursor = database.query(RequestDBHandler.TABLE_REQUESTS, allColumns, null, null, null, null, null);

        List<Request> requests = new ArrayList<>();


        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                Log.d("NEE YAMMA", cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_STATUS)));


                if (cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_STATUS))!=null && cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_STATUS)).equals("ACCEPTED")) {
                    Request request = new Request();
                    request.setReqId(cursor.getLong(cursor.getColumnIndex(RequestDBHandler.COLUMN_ID)));
                    request.setRequestTitle(cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_REQUEST_DATA)));
                    request.setStatus(cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_STATUS)));
                    request.setCreatedDate(cursor.getString(cursor.getColumnIndex(RequestDBHandler.COLUMN_CREATED_DATE)));
                    requests.add(request);

                }


            }
        }
        return requests;
    }


    // Updating Request
    public int updateRequest(Request request) {

        database = dbhandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RequestDBHandler.COLUMN_REQUEST_DATA, request.getRequestTitle());
        values.put(RequestDBHandler.COLUMN_STATUS, request.getStatus());
        values.put(RequestDBHandler.COLUMN_CREATED_DATE, request.getCreatedDate());


        System.out.println(database);

        // updating row
        return database.update(RequestDBHandler.TABLE_REQUESTS, values,
                RequestDBHandler.COLUMN_ID + "=?", new String[]{String.valueOf(request.getReqId())});
    }

    // Deleting Request
    public void removeRequest(Request request) {

        database.delete(RequestDBHandler.TABLE_REQUESTS, RequestDBHandler.COLUMN_ID + "=" + request.getReqId(), null);
    }


}
