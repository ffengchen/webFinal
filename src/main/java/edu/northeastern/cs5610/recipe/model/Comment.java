package edu.northeastern.cs5610.recipe.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import edu.northeastern.cs5610.recipe.util.CustomDateSerializer;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * The type Comment.
 */
@Data
public class Comment {

  @JsonSerialize(using = ToStringSerializer.class)
  private ObjectId id;

  @JsonSerialize(using = ToStringSerializer.class)
  private ObjectId recipeId;

  // @JsonSerialize(using = ToStringSerializer.class)
  // private ObjectId UserId;

  private String username;

  private String content;
  private Integer rating;

  @JsonSerialize(using = CustomDateSerializer.class)
  private Date createTime;
}
