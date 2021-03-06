package edu.northeastern.cs5610.recipe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.StringWriter;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import spark.ResponseTransformer;

/**
 * The type Json transformer.
 */
@Slf4j
public class JsonTransformer implements ResponseTransformer {

  /**
   * Instantiates a new Json transformer.
   */
  @Inject
  JsonTransformer() {
    super();
  }

  @Override
  public String render(Object model) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.enable(SerializationFeature.INDENT_OUTPUT);
      StringWriter sw = new StringWriter();
      mapper.writeValue(sw, model);
      return sw.toString();
    } catch (IOException e) {
      log.error("JsonTransformer > render > IOException?");
      e.printStackTrace();
    }
    return "{\"status\": \"ERROR\"}";
  }
}
