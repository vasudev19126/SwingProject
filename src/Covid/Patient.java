package Covid;
import java.util.ArrayList;
import java.util.Date;

public class Patient {
    String name;
    int age;
    String tower;
    Date date_of_Reporting;
    Date date_of_Recovery;
    static ArrayList<Patient> covid_Data = new ArrayList<>();
    Patient(String name, int age, String tower,Date date_of_Reporting){
        this.name =name;
        this.age = age;
        this.tower = tower;
        this.date_of_Reporting = date_of_Reporting;
        covid_Data.add(this);
    }
}
