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
     * Update the user with all non-null fields except id.
     *
     * @param user The User Object
     * @throws NullKeyException thrown when key is null
     * @throws KeyNotFoundException thrown when that item is not in db
     */
    public void updateUser(User user) throws NullKeyException, KeyNotFoundException {
    log.debug("UserController > updateUser(...)");
    ObjectId id = user.getId();
    userDao.updateUser(user);
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
     * Update the follower’s following list to follow the target. Check if both user exists first.
     *
     * @param followerName A String of follower name
     * @param targetName A String of target name
     * @throws NullKeyException thrown when the key is null
     * @throws DuplicateKeyException thrown when there's already a key in the follow list
     * @throws KeyNotFoundException thrown when you cannot find the corresponding key
     * @throws UsernameNotFoundException thrown when the username not stored in the database
     */

    public void followUser(@Nonnull String followerName, @Nonnull String targetName)
      throws NullKeyException, DuplicateKeyException, KeyNotFoundException,
      UsernameNotFoundException {
    User currentUser = this.getUserByUsername(followerName);
    User targetUser = this.getUserByUsername(targetName);
    if (currentUser == null) {
      throw new UsernameNotFoundException("Cannot find current User");
    }
    if (targetUser == null) {
      throw new UsernameNotFoundException("Cannot find target User");
    }
    ObjectId id = targetUser.getId();
    if (id == null) {
      throw new NullKeyException("Cannot find the key of target User");
    }
    if (currentUser.getFollowed() == null) {
      currentUser.setFollowed(new ArrayList<>());

    }
    List<ObjectId> followList = currentUser.getFollowed();
    if (followList.contains(id)) {
      throw new DuplicateKeyException("Already followed that user");
    }
    followList.add(id);
    this.updateUser(currentUser);
  }

    /**
     * Update the follower’s following list to unfollow the target. Check if both user exists first.
     *
     * @param followerName A String of follower name
     * @param targetName A String of target name
     * @throws KeyNotFoundException thrown when the key is null
     * @throws NullKeyException thrown when there's already a key in the follow list
     * @throws UsernameNotFoundException thrown when the username not stored in the database
     */
    public void unfollowUser(@Nonnull String followerName, @Nonnull String targetName)
      throws KeyNotFoundException, NullKeyException,
      UsernameNotFoundException {
    User currentUser = this.getUserByUsername(followerName);

    User targetUser = this.getUserByUsername(targetName);


    if (currentUser == null) {
      throw new UsernameNotFoundException("Cannot find current User");
    }
    if (targetUser == null) {
      throw new UsernameNotFoundException("Cannot find target User");

    }
    ObjectId id = targetUser.getId();
    if (id == null) {
      throw new NullKeyException("Cannot find the key of target User");
    }
    if (currentUser.getFollowed() == null) {
      currentUser.setFollowed(new ArrayList<>());
    }
    List<ObjectId> followList = currentUser.getFollowed();
    if (!followList.contains(id)) {
      throw new KeyNotFoundException("Target user is not followed");
    }
    followList.remove(id);
    this.updateUser(currentUser);
  }


    /**
     * Add favourite boolean.
     *
     * @param recipeId the recipe id
     * @param userId the user id
     * @return the boolean
     * @throws NullKeyException the null key exception
     * @throws KeyNotFoundException the key not found exception
     */
    public boolean addFavourite(ObjectId recipeId, ObjectId userId)

      throws NullKeyException, KeyNotFoundException {
    User currentUser = this.getUser(userId);
    List<ObjectId> list = currentUser.getFavorite();
    if (!list.contains(recipeId)) {
      list.add(recipeId);
      this.updateUser(currentUser);
      return true;
    } else {
      list.remove(recipeId);
      this.updateUser(currentUser);
      return false;

    }
  }

    /**
     * Update the user’s favorite list to favorite the recipe. Check if both item exists first.
     *
     * @param username A String of username
     * @param recipeId A String of target name
     * @throws KeyNotFoundException thrown when the key is null
     * @throws UsernameNotFoundException thrown when the username not stored in the database
     * @throws DuplicateKeyException thrown when you cannot find the corresponding key
     * @throws NullKeyException thrown when there's already a key in the follow list
     */
    public void favoriteRecipe(@Nonnull String username, @Nonnull String recipeId)
      throws KeyNotFoundException, UsernameNotFoundException, DuplicateKeyException,
      NullKeyException {
    User user = this.getUserByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("Cannot find current User");
    }
    Recipe recipe = recipeDao.getRecipe(recipeId);
    if (user.getFavorite() == null) {
      user.setFavorite(new ArrayList<>());
    }
    List<ObjectId> favoriteList = user.getFavorite();

    if (favoriteList.contains(recipeId)) {
      throw new DuplicateKeyException("Already followed that recipe");
    }
    favoriteList.add(new ObjectId(recipeId));
    this.updateUser(user);
  }

    /**
     * Update the user’s favorite list to unfavorite the recipe. Check if both item exists first.
     *
     * @param username A String of username
     * @param recipeId A String of target name
     * @throws KeyNotFoundException thrown when the key is null
     * @throws UsernameNotFoundException thrown when the username not stored in the database
     * @throws DuplicateKeyException thrown when you cannot find the corresponding key
     * @throws NullKeyException thrown when there's already a key in the follow list
     */
    public void unfavoriteRecipe(@Nonnull String username, @Nonnull String recipeId)
      throws KeyNotFoundException, UsernameNotFoundException, DuplicateKeyException,
      NullKeyException {
    User user = this.getUserByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("Cannot find current User");
    }
    Recipe recipe = recipeDao.getRecipe(recipeId);
    List<ObjectId> favoriteList = user.getFavorite();
    ObjectId id = new ObjectId(recipeId);
    if (!favoriteList.contains(id)) {
      throw new KeyNotFoundException("Recipe is not favorited by the user");
    }
    favoriteList.remove(id);
    this.updateUser(user);
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
