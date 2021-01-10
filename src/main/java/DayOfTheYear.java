import java.util.Calendar;

public class DayOfTheYear {
    public static void main(String[] args) {
        DayOfTheYear dayOfTheYear = new DayOfTheYear();
        System.out.println(dayOfTheYear.dayOfYear("2019-02-10"));
    }

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }
}
