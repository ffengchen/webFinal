package edu.northeastern.cs5610.recipe.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import edu.northeastern.cs5610.recipe.util.CustomDateSerializer;
import java.util.Date;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * The type Tag.
 */
@Data
public class Tag {

  @JsonSerialize(using = ToStringSerializer.class)
  private ObjectId id;

  private String name;

  @JsonSerialize(using = CustomDateSerializer.class)
  private Date createTime;
}
