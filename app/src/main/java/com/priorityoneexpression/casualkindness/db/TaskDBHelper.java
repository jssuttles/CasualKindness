package com.priorityoneexpression.casualkindness.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jason on 2/9/2015.
 */
public class TaskDBHelper extends SQLiteOpenHelper{

	public TaskDBHelper(Context context) {
        super(context, TaskContract.DB_NAME, null, TaskContract.DB_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase sqlDB) {
		String sqlQuery =
				String.format("CREATE TABLE %s (" +
								"_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
								"%s TEXT, %s TEXT)", TaskContract.TABLE,
						TaskContract.Columns.NAME, TaskContract.Columns.DESCRIPTION);

		Log.d("TaskDBHelper","Query to form table: "+sqlQuery);
		sqlDB.execSQL(sqlQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
		sqlDB.execSQL("DROP TABLE IF EXISTS "+TaskContract.TABLE);
		onCreate(sqlDB);
	}
}
