package HelloWorld;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
public class Main
{
    // Function to calculate moon phase
    public static String getMoonPhase(int year, int month, int day) {
        String[] moonPhaseNames = {"New Moon", "Waxing Crescent", "First Quarter", "Waxing Gibbous",
                               "Full Moon", "Waning Gibbous", "Last Quarter", "Waning Crescent"};

    // Convert month and year to astronomical year and month
    if (month < 3) {
        year--;
        month += 12;
    }
    int a = year / 100;
    int b = a / 4;
    int c = 2 - a + b;
    int e = (int) (365.25 * (year + 4716));
    int f = (int) (30.6001 * (month + 1));

    double jd = c + day + e + f - 1524.5; // Julian date for 0 hours UT
    double daysSinceNewMoon = jd - 2451550.1; // Number of days since New Moon
    double newMoons = daysSinceNewMoon / 29.53; // Number of synodic months since 2000 Jan 6.0 (New Moon)
    int phase = (int) ((newMoons - Math.floor(newMoons)) * 8); // 0, 1, 2, ... 7

    return moonPhaseNames[phase];
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
