package edu.northeastern.cs5610.recipe.controller;

import static com.mongodb.client.model.Filters.eq;

import edu.northeastern.cs5610.recipe.dao.RecipeDao;
import edu.northeastern.cs5610.recipe.dao.UserDao;
import edu.northeastern.cs5610.recipe.exception.InvalidRecipeException;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.User;

import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

/**
 * The type Recipe controller.
 */
@Singleton
@Slf4j
public class RecipeController implements Controller {

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
     * Instantiates a new Recipe controller.
     */
    @Inject
  RecipeController() {
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

  /**
   * Register the related functions and attributes of the class
   */
  @Override
  public void register() {
    log.info("RecipeController > register");
  }


    /**
     * Gets recipe.
     *
     * @param id the id
     * @return the recipe
     */
    public Recipe getRecipe(@Nonnull ObjectId id) {
    log.debug("RecipeController > getRecipe({})", id);
    return recipeDao.getRecipe(id);
  }

    /**
     * Gets recipe.
     *
     * @param id the id
     * @return the recipe
     */
    public Recipe getRecipe(@Nonnull String id) {
    return this.getRecipe(new ObjectId(id));
  }

    /**
     * Get all posts from the database. Mainly used as a test function.
     *
     * @return A Collection object of Recipes
     */
    @Nonnull
  public List<Recipe> getRecipes() {
    log.info("RecipeController > getRecipes()");
    return recipeDao.getRecipes();
  }

    /**
     * add a new Recipe onject to database
     *
     * @param recipe A recipe object. Should not contain any id field.
     * @return A string of id of that new Recipe.
     * @throws NullKeyException If we don't have an id from the db, throws an exception
     * @throws InvalidRecipeException Thrown when the recipe is invalid
     */
    @Nonnull
  public ObjectId addRecipe(@Nonnull Recipe recipe)
      throws NullKeyException, InvalidRecipeException {
    log.debug("RecipeController > addRecipe(...)");
    return recipeDao.addRecipe(recipe);
  }

    /**
     * Update the Recipe with all non-null fields except id.
     *
     * @param recipe The Recipe Object
     * @throws NullKeyException thrown when key is null
     * @throws InvalidRecipeException thrown when recipe is invalid
     * @throws KeyNotFoundException thrown when that recipe is not in db
     */
    public void updateRecipe(@Nonnull Recipe recipe)
      throws NullKeyException, InvalidRecipeException, KeyNotFoundException {
    log.debug("RecipeController > updateRecipe(...)");
    recipeDao.updateRecipe(recipe);
  }


    /**
     * Delete recipe long.
     *
     * @param id the id
     * @return the long
     * @throws KeyNotFoundException the key not found exception
     */
    public long deleteRecipe(@Nonnull ObjectId id) throws KeyNotFoundException {
    log.debug("RecipeController > deleteRecipe(...)");
    return recipeDao.deleteRecipe(id);
  }

    /**
     * Delete recipe long.
     *
     * @param id the id
     * @return the long
     * @throws KeyNotFoundException the key not found exception
     */
    public long deleteRecipe(@Nonnull String id) throws KeyNotFoundException {
    return this.deleteRecipe(new ObjectId(id));
  }

    /**
     * Get all recipes with the same author.
     *
     * @param username String of username.
     * @return List of recipes.
     */
    public List<Recipe> getRecipesByUsername(@Nonnull String username) {
    log.debug("RecipeController > getRecipesByUsername(...)");
    ObjectId userId = userDao.getUserByUsername(username).getId();
    return recipeDao.getRecipesByUserId(userId);
  }

    /**
     * Get all recipes with the tag name.
     *
     * @param tagName String of tagName.
     * @return List of recipes.
     */
    public List<Recipe> getRecipesByTag(String tagName) {
    log.debug("RecipeController > getRecipesByTag(...)");
    return recipeDao.getRecipesByTag(tagName);
  }

    /**
     * Get favorite count by recipe id.
     *
     * @param recipeId An ObjectId of target recipe.
     * @return recipe 's favorite count.
     */
    public int countRecipeFavorite(ObjectId recipeId) {
    log.debug("RecipeController > getFavoriteCountByRecipeId(...)");
    List<User> users = userDao.getUsers();
    int count = 0;
    for (User user : users) {
      if (user.getFavorite().contains(recipeId)) {
        count++;
      }
    }
    return count;
  }


    /**
     * Count recipe favorite int.
     *
     * @param recipeId the recipe id
     * @return the int
     */
    public int countRecipeFavorite(String recipeId) {
    return this.countRecipeFavorite(new ObjectId(recipeId));
  }

}
