package edu.northeastern.cs5610.recipe.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import edu.northeastern.cs5610.recipe.util.CustomDateSerializer;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

/**
 * The type User.
 */
@Data
public class User {

  @JsonSerialize(using = ToStringSerializer.class)
  private ObjectId id;

  private String username;
  private String password;

  @JsonSerialize(using = CustomDateSerializer.class)
  private Date createTime;

  private String email;

  private Integer userGroup;

  private String thumbnail;

  private List<ObjectId> favorite;

  private List<ObjectId> followed;

    /**
     * Instantiates a new User.
     */
    public User() {
  }
}
