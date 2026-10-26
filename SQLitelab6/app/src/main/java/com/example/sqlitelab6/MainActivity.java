package com.example.sqlitelab6;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import java.util.Arrays;

import com.example.sqlitelab6.FeedReaderContract.FeedEntry;

import com.example.sqlitelab6.FeedReaderContract.FeedEntry;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Initialize the database helper.
        FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(this);


// Open the database for writing.
        SQLiteDatabase db = dbHelper.getWritableDatabase();

// Prepare the values to insert.
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, "Android");
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, "SQLite");

// Insert the new entry into the database.
        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);

// Log the inserted row ID.
        Log.d("SQLiteLab6", "Inserted row ID: " + newRowId);
        // Define the columns to retrieve.
        String[] projection = {
                FeedEntry._ID,
                FeedEntry.COLUMN_NAME_TITLE,
                FeedEntry.COLUMN_NAME_SUBTITLE
        };

// Read the entries from the database.
        Cursor cursor = db.query(
                FeedEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

// Display the retrieved entries.
        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(FeedEntry._ID)
            );

            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE)
            );

            String subtitle = cursor.getString(
                    cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE)
            );

            Log.d("SQLiteLab6", "ID: " + itemId
                    + ", Title: " + title
                    + ", Subtitle: " + subtitle);
        }

// Release the cursor resources.
        cursor.close();

        // Define the row to delete.
        String selection = FeedEntry._ID + " = ?";
        String[] selectionArgs = {"1"};

        // Delete the selected row.
        int deletedRows = db.delete(
                FeedEntry.TABLE_NAME,
                selection,
                selectionArgs
        );

// Log the number of deleted rows.
        Log.d("SQLiteLab6", "Deleted rows: " + deletedRows);

        // Prepare the new values.
        ContentValues updatedValues = new ContentValues();
        updatedValues.put(FeedEntry.COLUMN_NAME_TITLE, "Java");

// Select the row to update.
        String updateSelection = FeedEntry._ID + " = ?";
        String[] updateSelectionArgs = {"2"};

// Update the selected row.
        int updatedRows = db.update(
                FeedEntry.TABLE_NAME,
                updatedValues,
                updateSelection,
                updateSelectionArgs
        );

// Log the number of updated rows.
        Log.d("SQLiteLab6", "Updated rows: " + updatedRows);

    }


}