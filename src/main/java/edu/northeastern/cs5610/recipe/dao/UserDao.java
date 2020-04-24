package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.model.User;
import edu.northeastern.cs5610.recipe.util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


@Singleton
@Slf4j
public class UserDao implements Dao {

    /**
     * The User collection.
     */
    @Inject
  MongoCollection<User> userCollection;

    /**
     * Instantiates a new User dao.
     */
    @Inject
  public UserDao() {
  }

    /**
     * Sets user collection.
     *
     * @param userCollection the user collection
     */
    public void setUserCollection(MongoCollection<User> userCollection) {
    this.userCollection = userCollection;
  }

  @Override
  public void register() {
    log.info("UserDao > register");
  }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(@Nonnull ObjectId id) {
    log.info("UserDao > getUser " + id.toHexString());

    return userCollection.find(eq("_id", id)).first();
  }



    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
    log.info("UserDao > getUsers");
    return userCollection.find().into(new ArrayList<>());
  }

    /**
     * Add user object id.
     *
     * @param user the user
     * @return the object id
     * @throws NullKeyException the null key exception
     */
    @Nonnull
  public ObjectId addUser(@Nonnull User user) throws NullKeyException {
    log.debug("UserController > addUser(...)");
    userCollection.insertOne(user);
    ObjectId id = user.getId();
    if (id == null) {
      throw new NullKeyException("insert failed!");
    }
    return id;
  }



    /**
     * Delete user long.
     *
     * @param id the id
     * @return the long
     * @throws KeyNotFoundException the key not found exception
     */
    public long deleteUser(@Nonnull ObjectId id) throws KeyNotFoundException {
    log.debug("UserDao > deleteUser(...)");
    DeleteResult deleteResult = userCollection.deleteOne(eq("_id", id));
    long res = deleteResult.getDeletedCount();
    if (res == 0) {
      throw new KeyNotFoundException("Cannot find the key to delete");
    }
    return res;
  }



    /**
     * Gets user by username.
     *
     * @param username the username
     * @return the user by username
     */
    public User getUserByUsername(String username) {
    log.debug("UserDao > getUserByUsername(...)");
    User user = userCollection.find(eq("username", username)).first();
    return user;
  }

    /**
     * Gets user by email.
     *
     * @param email the email
     * @return the user by email
     */
    public User getUserByEmail(String email) {
    log.debug("UserDao > getUserByEmail" + email);
    User user = userCollection.find(eq("email", email)).first();
    return user;
  }
}
