package com.project.group4.propertymanagerassistant.database;

/**
 * Created by benhoelzel on 11/12/14.
 */

import android.content.ContentValues;
import android.database.Cursor;

/**
 * A class representation of a row in table "Property".
 */
public class ActiveTenant {

    // SQL convention says Table name should be "singular"
    public static final String TABLE_NAME = "Tenant";
    // Naming the id column with an underscore is good to be consistent
    // with other Android things. This is ALWAYS needed
    public static final String COL_ID = "_id";
    // These fields can be anything you want.
    public static final String COL_LAST_NAME = "last_name";
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_ADDRESS = "address";
    public static final String COL_CITY = "city";
    public static final String COL_STATE = "state";
    public static final String COL_ZIP = "zip";
    public static final String COL_FICO = "fico";

    // For database projection so order is consistent
    public static final String[] FIELDS = { COL_ID, COL_LAST_NAME, COL_FIRST_NAME,
            COL_ADDRESS, COL_CITY, COL_STATE, COL_ZIP, COL_ZIP };

    /*
     * The SQL code that creates a Table for storing Persons in.
     * Note that the last row does NOT end in a comma like the others.
     * This is a common source of error.
     */
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_LAST_NAME + " TEXT NOT NULL DEFAULT '',"
                    + COL_FIRST_NAME + " TEXT NOT NULL DEFAULT '',"
                    + COL_ADDRESS + " TEXT NOT NULL DEFAULT '',"
                    + COL_CITY + " TEXT NOT NULL DEFAULT '',"
                    + COL_STATE + " TEXT NOT NULL DEFAULT '',"
                    + COL_ZIP + " TEXT NOT NULL DEFAULT '',"
                    + COL_FICO + " TEXT NOT NULL DEFAULT '' "
                    + ")";

    // Fields corresponding to database columns
    public long id = -1;
    public String lastName = "";
    public String firstName = "";
    public String address = "";
    public String city = "";
    public String state = "";
    public String zip = "";
    public String fico = "";

    /**
     * No need to do anything, fields are already set to default values above
     */
    public ActiveTenant() {
    }

    /**
     * Convert information from the database into a Person object.
     */
    public ActiveTenant(final Cursor cursor) {
        // Indices expected to match order in FIELDS!
        this.id = cursor.getLong(0);
        this.lastName = cursor.getString(1);
        this.firstName = cursor.getString(2);
        this.address = cursor.getString(3);
        this.city = cursor.getString(4);
        this.state = cursor.getString(5);
        this.zip = cursor.getString(6);
        this.fico = cursor.getString(7);
    }

    /**
     * Return the fields in a ContentValues object, suitable for insertion
     * into the database.
     */
    public ContentValues getContent() {
        final ContentValues values = new ContentValues();
        // Note that ID is NOT included here

        values.put(COL_LAST_NAME, lastName);
        values.put(COL_FIRST_NAME, firstName);
        values.put(COL_ADDRESS, address);
        values.put(COL_CITY, city);
        values.put(COL_STATE, state);
        values.put(COL_ZIP, zip);
        values.put(COL_FICO, fico);

        return values;
    }
}
