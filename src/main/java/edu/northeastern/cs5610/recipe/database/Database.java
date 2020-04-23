package edu.northeastern.cs5610.recipe.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.northeastern.cs5610.recipe.model.Comment;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.Tag;
import edu.northeastern.cs5610.recipe.model.User;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import static edu.northeastern.cs5610.recipe.util.DatabaseUtil.DATABASE_NAME;
import static edu.northeastern.cs5610.recipe.util.DatabaseUtil.URI;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


@Singleton
public class Database {

  /**
   * The Recipe collection.
   */
  MongoCollection<Recipe> recipeCollection;
  /**
   * The Comment collection.
   */
  MongoCollection<Comment> commentCollection;
  /**
   * The Tag collection.
   */
  MongoCollection<Tag> tagCollection;
  /**
   * The User collection.
   */
  MongoCollection<User> userCollection;

  /**
   * Instantiates a new Database.
   */
  @Inject
  public Database() {
    CodecRegistry pojoCodecRegistry =
        fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    MongoClientURI mongoClientURI =
        new MongoClientURI(URI, MongoClientOptions.builder().codecRegistry(pojoCodecRegistry));
    MongoClient mongoClient = new MongoClient(mongoClientURI);
    MongoDatabase db = mongoClient.getDatabase(DATABASE_NAME);
    recipeCollection = db.getCollection("tb_recipe", Recipe.class);
    commentCollection = db.getCollection("tb_comment", Comment.class);
    userCollection = db.getCollection("tb_user", User.class);
    tagCollection = db.getCollection("tb_tag", Tag.class);
  }

  /**
   * Gets recipe collection.
   *
   * @return the recipe collection
   */
  public MongoCollection<Recipe> getRecipeCollection() {
    return recipeCollection;
  }

  /**
   * Gets comment collection.
   *
   * @return the comment collection
   */
  public MongoCollection<Comment> getCommentCollection() {
    return commentCollection;
  }

  /**
   * Gets tag collection.
   *
   * @return the tag collection
   */
  public MongoCollection<Tag> getTagCollection() {
    return tagCollection;
  }

  /**
   * Gets user collection.
   *
   * @return the user collection
   */
  public MongoCollection<User> getUserCollection() {
    return userCollection;
  }
}
