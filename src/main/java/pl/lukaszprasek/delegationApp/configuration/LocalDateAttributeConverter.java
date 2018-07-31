package pl.lukaszprasek.delegationApp.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.*;


@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    public static final ZoneId ZONE_EUROPE_BERLIN = ZoneId.of("Europe/Berlin");

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        if (locDate == null) {
            return null;
        }

        // Untested, probably something like this

        ZonedDateTime zonedDateTime = locDate.atStartOfDay(ZONE_EUROPE_BERLIN);
        LocalDate producerLocalDate = zonedDateTime.toLocalDate();
        Date date = Date.valueOf(producerLocalDate);

        return date;
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        if (sqlDate == null) {
            return null;
        }

        // Fixed implementation considering server timezone

        Instant instant = Instant.ofEpochMilli(sqlDate.getTime());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONE_EUROPE_BERLIN);
        LocalDate localDate = localDateTime.toLocalDate();

        return localDate;
    }
}