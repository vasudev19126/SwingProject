package Covid;
import java.util.Calendar;
import java.util.Date;

class AddDate {
    static Date Add21Days(Date oldDate){
        Calendar c = Calendar.getInstance();
        c.setTime(oldDate);
        //Number of Days to add
        c.add(Calendar.DAY_OF_MONTH, 21);
        //Date after adding the days to the given date
        Date newDate = c.getTime();
        return newDate;
    }
}