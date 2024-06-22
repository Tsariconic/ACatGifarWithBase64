package HelloWorld;

public class Main
{
    public static void main(String[] args)
    {
        // Function to calculate moon phase
function getMoonPhase(year, month, day) {
    var moonPhaseNames = ["New Moon", "Waxing Crescent", "First Quarter", "Waxing Gibbous", 
                          "Full Moon", "Waning Gibbous", "Last Quarter", "Waning Crescent"];
    var moonPhases = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22];
    var c = 0;
    var e = 0;
    var jd = 0;
    var b = 0;

    if (month < 3) {
        year--;
        month += 12;
    }

    ++month;
    c = 365.25 * year;
    e = 30.6 * month;
    jd = c + e + day - 694039.09; // jd is total days elapsed
    jd /= 29.5305882; // divide by the moon cycle
    b = parseInt(jd); // int(jd) -> b, take integer part of jd
    jd -= b; // subtract integer part to leave fractional part of original jd
    b = Math.round(jd * 8); // scale fraction from 0-8 and round

    if (b >= 8 ) {
        b = 0;
    }

    return moonPhaseNames[b];
}

// Function to get current date and time in the desired format
function getCurrentDateTime() {
    var now = new Date();
    var dayOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    var monthNames = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
    var seconds = now.getSeconds();
    var date = now.getDate();
    var month = monthNames[now.getMonth()];
    var year = now.getFullYear();
    var day = dayOfWeek[now.getDay()];
    var moonPhase = getMoonPhase(year, now.getMonth() + 1, date);

    var dateTimeString = sprintf("%a:%b:%c %d %e/%f/%g %h", now.getHours(), now.getMinutes(), seconds, day, date, month, year, moonPhase);
    return dateTimeString;
}

        System.out.println(getCurrentDateTime());
    }
}
