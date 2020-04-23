package edu.northeastern.cs5610.recipe.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Custom date serializer.
 */
public class CustomDateSerializer extends JsonSerializer {

  public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
      throws IOException {

    Date value = (Date) arg0;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String formattedDate = formatter.format(value);
    arg1.writeString(formattedDate);
  }
}
