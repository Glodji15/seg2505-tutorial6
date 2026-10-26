package com.example.sqlitelab6;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // Prevent instantiation of the contract class

    private FeedReaderContract (){}
    // Define the table name and column names.

    public static class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

}
