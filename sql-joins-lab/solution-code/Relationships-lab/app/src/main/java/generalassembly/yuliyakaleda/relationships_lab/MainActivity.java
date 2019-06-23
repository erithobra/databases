package generalassembly.yuliyakaleda.relationships_lab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import generalassembly.yuliyakaleda.relationships_lab.recyclerview.JoinsRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private JoinsRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Populate database
        addDataToDb();

        // Set up RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new JoinsRecyclerViewAdapter(new ArrayList<String>());
        recyclerView.setAdapter(mAdapter);

        // Set up buttons
        Button workAtMacys = (Button) findViewById(R.id.work_at_macys);
        Button bostonLocation = (Button) findViewById(R.id.boston_location);
        Button bestPaidCity = (Button) findViewById(R.id.best_paid_employee);

        workAtMacys.setOnClickListener(this);
        bostonLocation.setOnClickListener(this);
        bestPaidCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.work_at_macys:
                workAtMacys();
                break;

            case R.id.boston_location:
                bostonLocation();
                break;

            case R.id.best_paid_employee:
                highestSalary();
                break;
        }
    }

    private void addDataToDb() {
        Helper helper = Helper.getInstance(MainActivity.this);

        if (helper.employeeTableIsEmpty()) {
            Employee employee1 = new Employee("123-04-5678", "John", "Smith", 1973, "NY");
            Employee employee2 = new Employee("123-04-5679", "David", "McWill", 1982, "Seattle");
            Employee employee3 = new Employee("123-04-5680", "Katerina", "Wise", 1973, "Boston");
            Employee employee4 = new Employee("123-04-5681", "Donald", "Lee", 1992, "London");
            Employee employee5 = new Employee("123-04-5682", "Gary", "Henwood", 1987, "Las Vegas");
            Employee employee6 = new Employee("123-04-5683", "Anthony", "Bright", 1963, "Seattle");
            Employee employee7 = new Employee("123-04-5684", "William", "Newey", 1995, "Boston");
            Employee employee8 = new Employee("123-04-5685", "Melony", "Smith", 1970, "Chicago");

            helper.addEmployee(employee1);
            helper.addEmployee(employee2);
            helper.addEmployee(employee3);
            helper.addEmployee(employee4);
            helper.addEmployee(employee5);
            helper.addEmployee(employee6);
            helper.addEmployee(employee7);
            helper.addEmployee(employee8);
        }

        if (helper.jobTableIsEmpty()) {
            Job job1 = new Job("123-04-5678", "Fuzz", 60, 1);
            Job job2 = new Job("123-04-5679", "GA", 70, 2);
            Job job3 = new Job("123-04-5680", "Little Place", 120, 5);
            Job job4 = new Job("123-04-5681", "Macys", 78, 3);
            Job job5 = new Job("123-04-5682", "New Life", 65, 1);
            Job job6 = new Job("123-04-5683", "Believe", 158, 6);
            Job job7 = new Job("123-04-5684", "Macys", 200, 8);
            Job job8 = new Job("123-04-5685", "Stop", 299, 12);

            helper.addJob(job1);
            helper.addJob(job2);
            helper.addJob(job3);
            helper.addJob(job4);
            helper.addJob(job5);
            helper.addJob(job6);
            helper.addJob(job7);
            helper.addJob(job8);
        }
    }

    private void workAtMacys() {
        Helper helper = Helper.getInstance(MainActivity.this);
        List<String> employees = helper.getEmployeesWorkingAtTheSameCompany();
        mAdapter.replaceData(employees);
    }

    private void bostonLocation() {
        Helper helper = Helper.getInstance(MainActivity.this);
        List<String> companies = helper.getCompaniesLocatedInBoston();
        mAdapter.replaceData(companies);
    }

    private void highestSalary() {
        Helper helper = Helper.getInstance(MainActivity.this);
        List<String> employees = helper.getEmployeeWithHighestSalary();
        mAdapter.replaceData(employees);
    }
}
