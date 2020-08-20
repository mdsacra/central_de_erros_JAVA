package com.mdsacra.centraldeerros.util;

import com.google.gson.*;
import org.springframework.format.datetime.DateFormatter;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateCoverter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDate.format(dateTimeFormatter));
    }

    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDate.parse(json.getAsString(), dateTimeFormatter);
    }
}
