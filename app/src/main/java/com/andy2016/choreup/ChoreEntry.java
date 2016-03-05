package com.andy2016.choreup;

import android.provider.BaseColumns;

/**
 * Created by Andy2015 on 3/4/2016.
 */
public final class ChoreEntry {

    //columns
    //TODO make column names for choreEntry into abstract class
    public static final String TABLE_NAME = "Chores";
    public static final String COLUMN_NAME_ENTRY_ID = "entryid";
    public static final String COLUMN_NAME_CHORE_NAME = "name";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_ENTRY_ID  + " INTERGER PRIMARY KEY,"
            + COLUMN_NAME_CHORE_NAME + TEXT_TYPE
            +" )";

    public static final  String SQL_DELETE_ENTRIES = "DROP TABLE " + TABLE_NAME;

    public ChoreEntry(){}
}
