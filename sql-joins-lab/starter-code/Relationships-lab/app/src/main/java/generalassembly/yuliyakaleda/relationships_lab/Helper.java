package generalassembly.yuliyakaleda.relationships_lab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

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

    // TODO - complete the addEmployee() and addJob() methods
    public void addEmployee(Employee employee) {
        // TODO - complete me
    }

    public void addJob(Job job) {
        // TODO - complete me
    }

    // --------------------------------------------------------------------------------
    // Queries requiring JOINS
    // --------------------------------------------------------------------------------

    // TODO - write methods to perform each of the 3 required queries; each will require a JOIN
    // Suggestion: Have each one return List<String> so you can just update the same RecyclerView
    // with whatever results you get
}
