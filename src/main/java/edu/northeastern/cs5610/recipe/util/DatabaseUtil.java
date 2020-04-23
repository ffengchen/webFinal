package edu.northeastern.cs5610.recipe.util;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.lang.reflect.Field;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/**
 * Create a db connection
 */
public class DatabaseUtil {

  /**
   * The constant DATABASE_NAME.
   */
  public static final String DATABASE_NAME = "recipe";
  /**
   * The constant USERNAME.
   */
  public static final String USERNAME = "fengchen";
  /**
   * The constant PASSWORD.
   */
  public static final String PASSWORD = "123";
  /**
   * The constant URI.
   */
  public static final String URI ="mongodb+srv://fengchen:123@cluster0-0lpae.mongodb.net/test?authSource=admin&replicaSet=Cluster0-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass&retryWrites=true&ssl=true";



  /**
   * Given the pojo, the corresponding ObjectId and the MongoCollection update all non-null fields
   * Use "id" field as the index to search, and ignore updating this field.
   *
   * @param <T> the type parameter
   * @param source The Pojo to update
   * @param id The ObjectId of the source.
   * @param collection The MongoCollection object to perform updating.
   */
  public static <T> void updateHelper(T source, ObjectId id, MongoCollection<T> collection) {
    try {
      // get all fields from the class using reflection
      Field[] fs = source.getClass().getDeclaredFields();
      for (Field f : fs) {
        // set the accessbility to visit private field
        f.setAccessible(true);
        String fieldName = f.getName();
        Object value = f.get(source);
        // if the field Name is "id" or the value is empty, then don't update.
        if (!fieldName.equals("id") && value != null) {
          collection.updateOne(eq("_id", id), set(fieldName, value));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
