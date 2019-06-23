package generalassembly.yuliyakaleda.relationships_lab;

public class Employee {
    private String mSsn;
    private String mFirstName;
    private String mLastName;
    private int mYear;
    private String mCity;
    private String mCompany;
    private int mSalary;
    private int mExperience;

    public Employee(String ssn, String firstName, String lastName, int year, String city) {
        mSsn = ssn;
        mFirstName = firstName;
        mLastName = lastName;
        mYear = year;
        mCity = city;
    }

    public String getSsn() {
        return mSsn;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getYear() {
        return mYear;
    }

    public String getCity() {
        return mCity;
    }

    public String getCompany() {
        return mCompany;
    }

    public int getSalary() {
        return mSalary;
    }

    public int getExperience() {
        return mExperience;
    }
}

