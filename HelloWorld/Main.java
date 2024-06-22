package HelloWorld;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
public class Main
{
    public static void main(String[] args)
    {
    // Function to calculate moon phase
    public static String getMoonPhase(int year, int month, int day) {
        String[] moonPhaseNames = {"New Moon", "Waxing Crescent", "First Quarter", "Waxing Gibbous", 
                                   "Full Moon", "Waning Gibbous", "Last Quarter", "Waning Crescent"};
        int[] moonPhases = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22};
        double c, e, jd;
        int b;

        if (month < 3) {
            year--;
            month += 12;
        }

        month++;
        c = 365.25 * year;
        e = 30.6 * month;
        jd = c + e + day - 694039.09; // jd is total days elapsed
        jd /= 29.5305882; // divide by the moon cycle
        b = (int) Math.round(jd * 8); // scale fraction from 0-8 and round

        if (b >= 8) {
            b = 0;
        }

        return moonPhaseNames[b];
    }

    // Function to get current date and time in the desired format
    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss EEEE dd/MM/yyyy", Locale.ENGLISH);
        String dayOfWeek = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String moonPhase = getMoonPhase(now.getYear(), now.getMonthValue(), now.getDayOfMonth());

        return now.format(formatter) + " " + moonPhase;
    }

    public static void main(String[] args) {
        System.out.println(getCurrentDateTime());
    }

    }
}
