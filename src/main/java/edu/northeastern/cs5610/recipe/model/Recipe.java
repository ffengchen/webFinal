package edu.northeastern.cs5610.recipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import edu.northeastern.cs5610.recipe.util.CustomDateSerializer;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

/**
 * The type Recipe.
 */
@Data
public class Recipe {

  @JsonSerialize(using = ToStringSerializer.class)
  private ObjectId id;

  private String title;
  private String description;
  private String content;


  @JsonSerialize(using = CustomDateSerializer.class)
  private Date createTime;

  private ObjectId userId;
  private List<Tag> tags;
  private List<String> images;
  private String thumbnail;


  @JsonSerialize(using = CustomDateSerializer.class)
  private Date lastEditTime;

  /**
   * Is invalid boolean.
   *
   * @return true if this recipe is valid
   */
  @JsonIgnore
  public boolean isInvalid() {
    return title == null || title.isEmpty();
  }
}
