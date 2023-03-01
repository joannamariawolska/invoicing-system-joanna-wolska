package pl.futurecollars.invoicing.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonService {

  private final ObjectMapper objectMapper;

  {
    objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  public String invoiceAsJson(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed to convert string to Json" ,e);
    }
  }

  public <T> T invoiceFromFile(String json, Class<T> clazz) {
    try {
      return objectMapper.readValue(json, clazz);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed to parse Json" ,e);
    }
  }
}
