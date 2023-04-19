package sg.edu.nus.iss;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWrite {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEWLINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "staffNo,fullName,department,role,emailAddress,salary";

    public List<Employee> employees = null;

    public List<Employee> generateEmployees() {
        employees = new ArrayList<>();

        Employee emp1 = new Employee("12345", "Tan", "Software Test", "Engineer", "tan@visa.com", 10_000);
        Employee emp2 = new Employee("23456", "Lim", "System", "Analyst", "lim@visa.com", 11_000);
        Employee emp3 = new Employee("34567", "Lee", "Cybersecurity", "Analyst", "lee@visa.com", 12_000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;
    }

    public void writeToCSVFile(List<Employee> employees, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);

        fw.append(FILE_HEADER);
        fw.append(NEWLINE_SEPARATOR);

        for (Employee emp : employees) {
            fw.append(emp.getStaffNo());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getFullName());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getDepartment());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getRole());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getEmailAddress());
            fw.append(COMMA_DELIMITER);
            fw.append(("" + emp.getSalary()));
            fw.append(NEWLINE_SEPARATOR);
        }
        
        fw.flush();
        fw.close();
    }
}
