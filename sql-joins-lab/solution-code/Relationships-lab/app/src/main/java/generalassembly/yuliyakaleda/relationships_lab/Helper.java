package generalassembly.yuliyakaleda.relationships_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class Helper extends SQLiteOpenHelper {

    // --------------------------------------------------------------------------------
    // Constants
    // --------------------------------------------------------------------------------
    public static abstract class EmployeeTable implements BaseColumns {
        public static final String TABLE_NAME = "employee";
        public static final String COLUMN_SSN = "ssn";
        public static final String COLUMN_FIRST_NAME = "firstName";
        public static final String COLUMN_LAST_NAME = "lastName";
        public static final String COLUMN_YEAR = "year";
        public static final String COLUMN_CITY = "city";
    }

    public static abstract class JobTable implements BaseColumns {
        public static final String TABLE_NAME = "job";
        public static final String COLUMN_SSN = "ssn";
        public static final String COLUMN_COMPANY = "company";
        public static final String COLUMN_SALARY = "salary";
        public static final String COLUMN_EXPERIENCE = "experience";
    }

    private static final String SQL_CREATE_ENTRIES_EMPLOYEES = "CREATE TABLE " +
            EmployeeTable.TABLE_NAME + " (" +
            EmployeeTable._ID + " INTEGER PRIMARY KEY," +
            EmployeeTable.COLUMN_SSN + " TEXT," +
            EmployeeTable.COLUMN_FIRST_NAME + " TEXT," +
            EmployeeTable.COLUMN_LAST_NAME + " TEXT," +
            EmployeeTable.COLUMN_YEAR + " INTEGER," +
            EmployeeTable.COLUMN_CITY + " TEXT" + ")";

    private static final String SQL_DELETE_ENTRIES_EMPLOYEES = "DROP TABLE IF EXISTS " +
            EmployeeTable.TABLE_NAME;

    private static final String SQL_CREATE_ENTRIES_JOB = "CREATE TABLE " +
            JobTable.TABLE_NAME + " (" +
            JobTable._ID + " INTEGER PRIMARY KEY," +
            JobTable.COLUMN_SSN + " TEXT," +
            JobTable.COLUMN_COMPANY + " TEXT," +
            JobTable.COLUMN_SALARY + " INTEGER," +
            JobTable.COLUMN_EXPERIENCE + " INTEGER" + ")";

    private static final String SQL_DELETE_ENTRIES_JOB = "DROP TABLE IF EXISTS " +
            JobTable.TABLE_NAME;


    // --------------------------------------------------------------------------------
    // Singleton components
    // --------------------------------------------------------------------------------
    private static Helper sInstance;

    private Helper(Context context) {
        super(context, "db", null, 1);
    }

    public static Helper getInstance(Context context) {
        if (sInstance == null)
            sInstance = new Helper(context.getApplicationContext());
        return sInstance;
    }

    // --------------------------------------------------------------------------------
    // Required SQLiteOpenHelper methods
    // --------------------------------------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_EMPLOYEES);
        db.execSQL(SQL_CREATE_ENTRIES_JOB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES_EMPLOYEES);
        db.execSQL(SQL_DELETE_ENTRIES_JOB);
        onCreate(db);
    }

    // --------------------------------------------------------------------------------
    // Methods to check whether tables are populated and add rows to tables
    // --------------------------------------------------------------------------------
    public boolean employeeTableIsEmpty() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(EmployeeTable.TABLE_NAME, null, null, null, null, null, null);
        boolean isEmpty = !cursor.moveToFirst();
        cursor.close();
        return isEmpty;
    }

    public boolean jobTableIsEmpty() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(JobTable.TABLE_NAME, null, null, null, null, null, null);
        boolean isEmpty = !cursor.moveToFirst();
        cursor.close();
        return isEmpty;
    }

    public void addEmployee(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EmployeeTable.COLUMN_SSN, employee.getSsn());
        values.put(EmployeeTable.COLUMN_FIRST_NAME, employee.getFirstName());
        values.put(EmployeeTable.COLUMN_LAST_NAME, employee.getLastName());
        values.put(EmployeeTable.COLUMN_YEAR, employee.getYear());
        values.put(EmployeeTable.COLUMN_CITY, employee.getCity());

        db.insertOrThrow(EmployeeTable.TABLE_NAME, null, values);
        db.close();
    }

    public void addJob(Job job) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(JobTable.COLUMN_SSN, job.getSsn());
        values.put(JobTable.COLUMN_COMPANY, job.getCompany());
        values.put(JobTable.COLUMN_SALARY, job.getSalary());
        values.put(JobTable.COLUMN_EXPERIENCE, job.getExperience());

        db.insertOrThrow(JobTable.TABLE_NAME, null, values);
        db.close();
    }

    // --------------------------------------------------------------------------------
    // Queries requiring JOINS
    // --------------------------------------------------------------------------------
    public List<String> getEmployeesWorkingAtTheSameCompany() {
        SQLiteDatabase db = getReadableDatabase();

        // Building query using INNER JOIN keyword
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(
                EmployeeTable.TABLE_NAME + " INNER JOIN " + JobTable.TABLE_NAME +
                        " ON " + EmployeeTable.TABLE_NAME + "." + EmployeeTable.COLUMN_SSN +
                        " = " + JobTable.TABLE_NAME + "." + JobTable.COLUMN_SSN
        );

        Cursor cursor = builder.query(db,
                new String[]{EmployeeTable.COLUMN_FIRST_NAME, EmployeeTable.COLUMN_LAST_NAME},  // projection (columns we want)
                JobTable.COLUMN_COMPANY + " = ?",           // selection (WHERE clause)
                new String[]{"Macys"},                      // selectionArgs
                null, null, null                            // groupBy, having, orderBy
        );

        List<String> employees = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String firstName = cursor.getString(cursor.getColumnIndex(EmployeeTable
                        .COLUMN_FIRST_NAME));
                String lastName = cursor.getString(cursor.getColumnIndex(EmployeeTable
                        .COLUMN_LAST_NAME));
                String name = firstName + " " + lastName;
                employees.add(name);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return employees;
    }

    public List<String> getCompaniesLocatedInBoston() {
        SQLiteDatabase db = getReadableDatabase();

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(
                EmployeeTable.TABLE_NAME + " INNER JOIN " + JobTable.TABLE_NAME +
                        " ON " + EmployeeTable.TABLE_NAME + "." + EmployeeTable.COLUMN_SSN +
                        " = " + JobTable.TABLE_NAME + "." + JobTable.COLUMN_SSN
        );

        Cursor cursor = builder.query(db,
                new String[]{JobTable.COLUMN_COMPANY},          // projection (columns we want)
                EmployeeTable.COLUMN_CITY + " = ?",             // selection (WHERE clause)
                new String[]{"Boston"},                         // selectionArgs
                null, null, null                                // groupBy, having, orderBy
        );

        List<String> companies = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String company = cursor.getString(cursor.getColumnIndex(JobTable
                        .COLUMN_COMPANY));
                companies.add(company);
                cursor.moveToNext();
            }
        }

        cursor.close();
        return companies; // If there are no companies in Boston, the list will be empty.
    }

    public List<String> getEmployeeWithHighestSalary() {
        SQLiteDatabase db = getReadableDatabase();

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(
                EmployeeTable.TABLE_NAME + " INNER JOIN " + JobTable.TABLE_NAME +
                        " ON " + EmployeeTable.TABLE_NAME + "." + EmployeeTable.COLUMN_SSN +
                        " = " + JobTable.TABLE_NAME + "." + JobTable.COLUMN_SSN
        );

        Cursor cursor = builder.query(db,
                new String[]{EmployeeTable.COLUMN_FIRST_NAME, EmployeeTable.COLUMN_LAST_NAME},  // projection (columns we want)
                null, null, null, null,     // selection, selectionArgs, groupBy, having
                JobTable.COLUMN_SALARY + " DESC"
        );

        List<String> employees = new ArrayList<>();

        if (cursor.moveToFirst()) {
            String firstName = cursor.getString(cursor.getColumnIndex(EmployeeTable.COLUMN_FIRST_NAME));
            String lastName = cursor.getString(cursor.getColumnIndex(EmployeeTable.COLUMN_LAST_NAME));
            employees.add(firstName + " " + lastName);
        }

        cursor.close();
        return employees; // could be empty if database is empty!
    }
}
