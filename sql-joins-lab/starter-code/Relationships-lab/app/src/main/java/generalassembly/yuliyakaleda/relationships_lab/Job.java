package generalassembly.yuliyakaleda.relationships_lab;

public class Job {
    private String mSsn;
    private String mCompany;
    private int mSalary;
    private int mExperience;

    public Job(String ssn, String company, int salary, int experience) {
        mSsn = ssn;
        mCompany = company;
        mSalary = salary;
        mExperience = experience;
    }

    public String getSsn() {
        return mSsn;
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
