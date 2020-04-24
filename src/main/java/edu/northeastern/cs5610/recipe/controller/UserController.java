package edu.northeastern.cs5610.recipe.controller;

import edu.northeastern.cs5610.recipe.dao.RecipeDao;
import edu.northeastern.cs5610.recipe.dao.UserDao;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.User;
import edu.northeastern.cs5610.recipe.exception.DuplicateKeyException;
import edu.northeastern.cs5610.recipe.exception.UsernameNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * The type User controller.
 */
@Singleton
@Slf4j
public class UserController implements Controller {


    /**
     * The User dao.
     */
    @Inject
    UserDao userDao;

    /**
     * The Recipe dao.
     */
    @Inject
    RecipeDao recipeDao;

    /**
     * Instantiates a new User controller.
     */
    @Inject
  public UserController() {
  }

    /**
     * Sets recipe dao.
     *
     * @param recipeDao the recipe dao
     */
    public void setRecipeDao(RecipeDao recipeDao) {
    this.recipeDao = recipeDao;
  }

    /**
     * Sets user dao.
     *
     * @param userDao the user dao
     */
    public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void register() {
    log.info("UserController > register");
  }


    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(@Nonnull ObjectId id) {
    log.debug("UserController > getUser({})", id);
    return userDao.getUser(id);
  }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(@Nonnull String id) {
    return this.getUser(new ObjectId(id));
  }


    /**
     * Get all users in the database
     *
     * @return A List of User object.
     */
    public List<User> getUsers() {
    log.info("UserController > getUsers()");
    return userDao.getUsers();
  }

    /**
     * Add user object id.
     *
     * @param user the user
     * @return the object id
     * @throws NullKeyException the null key exception
     */
    public ObjectId addUser(User user) throws NullKeyException {


    User duplicateNameUser = userDao.getUserByUsername(user.getUsername());

    if (duplicateNameUser != null) {
      return duplicateNameUser.getId();
    }

    User duplicateEmailUser = userDao.getUserByEmail(user.getEmail());

    if (duplicateEmailUser != null) {
      return duplicateEmailUser.getId();

    }
    return userDao.addUser(user);
  }




    /**
     * Delete user long.
     *
     * @param id the id
     * @return the long
     * @throws KeyNotFoundException the key not found exception
     */
    public long deleteUser(@Nonnull ObjectId id) throws KeyNotFoundException {
    log.debug("UserController > deleteUser(...)");
    return userDao.deleteUser(id);
  }

    /**
     * Delete user long.
     *
     * @param id the id
     * @return the long
     * @throws KeyNotFoundException the key not found exception
     */
    public long deleteUser(@Nonnull String id) throws KeyNotFoundException {
    return this.deleteUser(new ObjectId(id));
  }

    /**
     * Get the User from a unique username
     *
     * @param username a unique username
     * @return A User object
     */
    public User getUserByUsername(@Nonnull String username) {
    log.debug("UserController > getUserByUsername(...)");
    return userDao.getUserByUsername(username);
  }











    /**
     * Gets user by email.
     *
     * @param email the email
     * @return the user by email
     */
    public User getUserByEmail(@Nonnull String email) {
    log.debug("UserController > getUserByEmail" + email);
    return userDao.getUserByEmail(email);
  }

    /**
     * User login boolean.
     *
     * @param email the email
     * @param password the password
     * @return the boolean
     * @throws UsernameNotFoundException the username not found exception
     */
    public boolean userLogin(@Nonnull String email, @Nonnull String password)
      throws UsernameNotFoundException {
    User user = this.getUserByEmail(email);
    if (user == null) {
      throw new UsernameNotFoundException("User doesn't exists");
    }
    return user.getPassword().equals(password);
  }

    /**
     * User register boolean.
     *
     * @param username the username
     * @param email the email
     * @param password the password
     * @return the boolean
     * @throws NullKeyException the null key exception
     */
    public boolean userRegister(@Nonnull String username, @Nonnull String email,
      @Nonnull String password) throws NullKeyException {
    User userWithSameEmail = this.getUserByEmail(email);
    if (userWithSameEmail != null) {
      return false;
    }
    User userWithSameName = this.getUserByUsername(username);
    if (userWithSameName != null) {
      return false;
    }
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(password);
    newUser.setUserGroup(1);
    newUser.setCreateTime(new Date());
    newUser.setEmail(email);
    try {
      this.addUser(newUser);
    } catch (NullKeyException e) {
      return false;
    }
    return true;
  }
}
