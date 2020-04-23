package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import edu.northeastern.cs5610.recipe.exception.InvalidRecipeException;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.model.Recipe;
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
public class RecipeDao implements Dao {


  @Inject
  MongoCollection<Recipe> recipeCollection;


  @Inject
  public RecipeDao() {
  }

  @Override
  public void register() {
    log.info("RecipeDao > register");

  }


  public void setRecipeCollection(MongoCollection<Recipe> recipeCollection) {
    this.recipeCollection = recipeCollection;
  }

  /**
   * Gets recipe.
   *
   * @param id the id
   * @return the recipe
   */
  public Recipe getRecipe(String id) {
    return this.getRecipe(new ObjectId(id));
  }

  /**
   * Gets recipe.
   *
   * @param id the id
   * @return the recipe
   */
  public Recipe getRecipe(ObjectId id) {
    log.debug("RecipeDao > getRecipe({})", id);
    return recipeCollection.find(eq("_id", id)).first();
  }

  /**
   * Gets recipes.
   *
   * @return the recipes
   */
  public List<Recipe> getRecipes() {
    log.info("RecipeDao > getRecipes()");
    return recipeCollection.find().into(new ArrayList<>());
  }

  /**
   * Add recipe object id.
   *
   * @param recipe the recipe
   * @return the object id
   * @throws NullKeyException the null key exception
   * @throws InvalidRecipeException the invalid recipe exception
   */
  @Nonnull
  public ObjectId addRecipe(@Nonnull Recipe recipe)
      throws NullKeyException, InvalidRecipeException {
    log.debug("RecipeDao > addRecipe(...)");
    if (recipe.isInvalid()) {
      throw new InvalidRecipeException("InvalidRecipeException");
    }
    recipeCollection.insertOne(recipe);
    ObjectId id = recipe.getId();
    if (id == null) {
      throw new NullKeyException("insert failed!");
    }
    return id;
  }

  /**
   * Update recipe.
   *
   * @param recipe the recipe
   * @throws NullKeyException the null key exception
   * @throws InvalidRecipeException the invalid recipe exception
   * @throws KeyNotFoundException the key not found exception
   */
  public void updateRecipe(@Nonnull Recipe recipe)
      throws NullKeyException, InvalidRecipeException, KeyNotFoundException {
    log.debug("RecipeDao > updateRecipe(...)");
    ObjectId id = recipe.getId();
    if (id == null) {
      throw new NullKeyException("NullKeyException");
    }

    if (recipe.isInvalid()) {
      throw new InvalidRecipeException("InvalidRecipeException");
    }

    if (getRecipe(id) == null) {
      throw new KeyNotFoundException("KeyNotFoundException");
    }
    DatabaseUtil.updateHelper(recipe, id, recipeCollection);
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
   * Delete recipe long.
   *
   * @param id the id
   * @return the long
   * @throws KeyNotFoundException the key not found exception
   */
  public long deleteRecipe(@Nonnull ObjectId id) throws KeyNotFoundException {
    log.debug("RecipeDao > deleteRecipe(...)");
    DeleteResult deleteResult = recipeCollection.deleteOne(eq("_id", id));
    long res = deleteResult.getDeletedCount();
    if (res == 0) {
      throw new KeyNotFoundException("Cannot find the key to delete");
    }
    return res;
  }


  /**
   * Gets recipes by user id.
   *
   * @param userId the user id
   * @return the recipes by user id
   */
  public List<Recipe> getRecipesByUserId(ObjectId userId) {
    log.debug("RecipeDao > getRecipesByUserId(...)");
    List<Recipe> recipes =
        recipeCollection.find(eq("userId", userId)).into(new ArrayList<>());
    return recipes;
  }

  /**
   * Gets recipes by user id.
   *
   * @param userId the user id
   * @return the recipes by user id
   */
  public List<Recipe> getRecipesByUserId(String userId) {
    return this.getRecipesByUserId(new ObjectId(userId));
  }

  /**
   * Gets recipes by tag.
   *
   * @param tagName the tag name
   * @return the recipes by tag
   */
  public List<Recipe> getRecipesByTag(String tagName) {
    log.debug("RecipeDao > getRecipesByTag(...)");
    List<Recipe> recipes =
        recipeCollection.find(eq("tags.name", tagName)).into(new ArrayList<>());
    return recipes;
  }

}
