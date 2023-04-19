package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVRead {

    public List<Employee> readCSV(String fileName) throws IOException {

        BufferedReader br = null;

        String line = "";

        // Create object to return
        List<Employee> employees = new ArrayList<>();

        FileReader fr = new FileReader(fileName);
        br = new BufferedReader(fr);

        // Skip the FILE_HEADER
        line = br.readLine();

        // Iterate through the file to read data and add to list
        while ((line = br.readLine()) != null) {

            String [] lineData = line.split(CSVWrite.COMMA_DELIMITER);

            if (lineData.length > 0) {

                Employee emp = new Employee(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], Integer.parseInt(lineData[5]));

                employees.add(emp);
            }
        }

        br.close();

        return employees;
    }
}
