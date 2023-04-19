package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        File newDirectory = new File(dirPath);

        if (!newDirectory.exists()) {
            newDirectory.mkdir();
        } else {
            System.out.println("Directory " + dirPath + " already exists");
        }

        File newFile = new File(dirPathFileName);

        if (!newFile.exists()) {
            newFile.createNewFile();
        } else {
            System.out.println("File " + fileName + " already exists");
        }

        CSVWrite csvWrite = new CSVWrite();
        List<Employee> empList = csvWrite.generateEmployees();
        csvWrite.writeToCSVFile(empList, dirPathFileName);

        CSVRead csvRead = new CSVRead();
        List<Employee> retrievedList = csvRead.readCSV(dirPathFileName);
        System.out.println(retrievedList.toString());
    }
}
