package generalassembly.yuliyakaleda.relationships_lab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Populate database
        addDataToDb();

        // TODO - Set up a RecyclerView to show the results of your queries
        // Each item in the RecyclerView can just be a String shown in
        // the android.R.layout.simple_list_item_1 layout (or more complicated if you like!)

        // TODO - Set up buttons to trigger queries; show results in the RecyclerView
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
}
