package edu.northeastern.cs5610.recipe.database;

import com.mongodb.client.MongoCollection;
import dagger.Module;
import dagger.Provides;
import edu.northeastern.cs5610.recipe.model.Comment;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.Tag;
import edu.northeastern.cs5610.recipe.model.User;


@Module
public class DatabaseModule {


  /**
   * Provide recipe collection mongo collection.
   *
   * @param db the db
   * @return the mongo collection
   */
  @Provides
  public MongoCollection<Recipe> provideRecipeCollection(Database db) {
    return db.getRecipeCollection();
  }

  /**
   * Provide user collection mongo collection.
   *
   * @param db the db
   * @return the mongo collection
   */
  @Provides
  public MongoCollection<User> provideUserCollection(Database db) {
    return db.getUserCollection();
  }

  /**
   * Provide comment collection mongo collection.
   *
   * @param db the db
   * @return the mongo collection
   */
  @Provides
  public MongoCollection<Comment> provideCommentCollection(Database db) {
    return db.getCommentCollection();
  }

  /**
   * Provide tag collection mongo collection.
   *
   * @param db the db
   * @return the mongo collection
   */
  @Provides
  public MongoCollection<Tag> provideTagCollection(Database db) {
    return db.getTagCollection();
  }


}
