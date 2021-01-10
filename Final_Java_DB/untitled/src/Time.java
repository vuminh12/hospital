import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    private static  String  convertIntoTimeStamp(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        return format.format(date);
    }

    private static void convertIntoLong(String convertDate) {
        try {

            DateFormat formatter ;
            Date date ;
            formatter = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
            date = (Date) formatter.parse(String.valueOf(convertDate));
            long longDate=date.getTime();
            System.out.println("Today is " +longDate );
        }
        catch (ParseException e){
            System.out.println("Exception :"+e);
        }
    }

    public static void main(String[] args) {
        convertIntoLong(2004.07.18);
        System.out.println( " "+ convertIntoTimeStamp(3600000));
    }
}
