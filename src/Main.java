import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        OffsetDateTime ieri = OffsetDateTime.parse("2023-12-21T00:16:25+01:00");
        System.out.println("Ieri: " + ieri);

        //possiamo stampare un solo FormatStyle per avere sia data che ora, oppure due e decidere la lunghezza di ciascuno
        String dateString = ieri.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT));

        //oppure possiamo stampare solo date o solo time:
        String dateString2 = ieri.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        String dateString3 = ieri.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));

        System.out.println("Time and date: " + dateString);
        System.out.println("Date: " + dateString2);
        System.out.println("Time: " + dateString3);

        String dateStringManuale = ieri.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        //posso decidere se mettere / - o niente e se stampare MM in numero, MMM corto, MMMM esteso a lettere
        //posso mettere ...ofPattern("dd MM yyyy", Locale.GERMANY e avrò la data in tedesco
        System.out.println(dateStringManuale);

        String dateStringIso = ieri.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(dateStringIso); //2023-12-21T00:16:25+01:00

        ZonedDateTime ieri2 = OffsetDateTime.parse("2023-12-21T00:16:25+01:00").toZonedDateTime();
        System.out.println("Ieri2: " + ieri2); //2023-12-21T00:16:25+01:00
        ZonedDateTime ieri3 = OffsetDateTime.parse("2023-12-21T00:16:25+01:00").atZoneSimilarLocal(ZoneId.of("Europe/Rome"));
        System.out.println("Ieri3: " + ieri3); //2023-12-21T00:16:25+01:00[Europe/Rome]

        String dateStringIeri2 = ieri2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
        System.out.println(dateStringIeri2); //giovedì 21 dicembre 2023 00:16:25 +01:00

        String dateStringIeri3 = ieri3.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
        System.out.println(dateStringIeri3); //giovedì 21 dicembre 2023 00:16:25 Ora standard dell’Europa centrale

        OffsetDateTime oggi = ieri.plusDays(1).minusHours(1); //abbiamo aggiunto un giorno a ieri e tolta un'ora
        String dateStringOggi = oggi.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        System.out.println("Data oggi: " + dateStringOggi); //Data oggi: 21 dic 2023, 23:16:25
    }
}