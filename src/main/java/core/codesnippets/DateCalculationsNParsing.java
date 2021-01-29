package core.codesnippets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateCalculationsNParsing {

  public static void main(String[] args) {
      String timeDateStr = "Aug-30-14:14:15";
      LocalDateTime ldt = LocalDateTime.now();

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd-HH:mm:ss");
      LocalDateTime dateTime = LocalDateTime.parse(  ldt.getYear() + "-"+timeDateStr,formatter);

      //Convert LocalDateTime to Time Zone ISO8601 String.
      // Reading based on a format.

      ZonedDateTime zdt = ldt.atZone(ZoneOffset.UTC); //you might use a different zone
      String iso8601 = zdt.toString();

      System.out.println(dateTime.toString());
      // Printing the based on a format.
      // --------------------------- //
      //   Date d = new Date();
      //   LocalDateTime ldt = LocalDateTime.of(2019,8,30,14,57,10);
      //   The given pattern matches exactly with timeDateStr;
      //   SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-HH:mm:ss");
  }
}