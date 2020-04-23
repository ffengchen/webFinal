package edu.northeastern.cs5610.recipe.controller;

import static com.mongodb.client.model.Filters.eq;

import edu.northeastern.cs5610.recipe.dao.RecipeDao;
import edu.northeastern.cs5610.recipe.dao.TagDao;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

/**
 * The type Tag controller.
 */
@Singleton
@Slf4j
public class TagController implements Controller {

  /**
   * The Tag dao.
   */
  @Inject
  TagDao tagDao;

  /**
   * The Recipe dao.
   */
  @Inject
  RecipeDao recipeDao;

  /**
   * Instantiates a new Tag controller.
   */
  @Inject
  public TagController() {
  }

  @Override
  public void register() {
    log.info("TagController > register");
  }

  /**
   * Sets tag dao.
   *
   * @param tagDao the tag dao
   */
  public void setTagDao(TagDao tagDao) {
    this.tagDao = tagDao;
  }


  /**
   * Gets tag.
   *
   * @param id the id
   * @return the tag
   */
  public Tag getTag(@Nonnull ObjectId id) {
    log.debug("TagController > getTag({})", id);
    return tagDao.getTag(id);
  }

  /**
   * Gets tag.
   *
   * @param id the id
   * @return the tag
   */
  public Tag getTag(@Nonnull String id) {
    return this.getTag(new ObjectId(id));
  }

  /**
   * Gets tag by name.
   *
   * @param name the name
   * @return the tag by name
   */
  public Tag getTagByName(@Nonnull String name) {
    log.debug("TagController > getTagByName({})", name);

    return tagDao.getTagByName(name);
  }

  /**
   * Get all tags in the database
   *
   * @return A List of Tag object.
   */
  public List<Tag> getTags() {
    log.info("TagController > getTags()");
    return tagDao.getTags();
  }

  /**
   * add a new Tag object to database, which should avoid duplicate
   *
   * @param tag A Tag object. Should not contain any id field.
   * @return ObjectId of the tag.
   * @throws NullKeyException If we don't have an id from the db, throws an exception
   */
  public ObjectId addTag(@Nonnull Tag tag) throws NullKeyException {
    log.debug("RecipeController > addRecipe(...)");
    Tag duplicateNameTag = this.getTagByName(tag.getName());
    if (duplicateNameTag != null) {
      return duplicateNameTag.getId();
    }
    Tag duplicateIdTag = this.getTag(tag.getId());
    if (duplicateIdTag != null) {
      return duplicateIdTag.getId();
    }
    return tagDao.addTag(tag);
  }

  /**
   * Add tag object id.
   *
   * @param name the name
   * @return the object id
   * @throws NullKeyException the null key exception
   */
  public ObjectId addTag(@Nonnull String name) throws NullKeyException {
    Tag tag = new Tag();
    tag.setName(name);
    tag.setCreateTime(new Date());
    return this.addTag(tag);
  }


  /**
   * Update the tag with all non-null fields except id.
   *
   * @param tag The Tag Object
   * @throws NullKeyException thrown when key is null
   * @throws KeyNotFoundException thrown when that item is not in db
   */
  public void updateTag(@Nonnull Tag tag) throws NullKeyException, KeyNotFoundException {
    log.debug("TagController > updateTag(...)");
    tagDao.updateTag(tag);
  }


  /**
   * Delete tag long.
   *
   * @param id the id
   * @return the long
   * @throws KeyNotFoundException the key not found exception
   */
  public long deleteTag(@Nonnull ObjectId id) throws KeyNotFoundException {
    log.debug("TagController > deleteTag(...)");
    return tagDao.deleteTag(id);
  }

  /**
   * Delete tag long.
   *
   * @param id the id
   * @return the long
   * @throws KeyNotFoundException the key not found exception
   */
  public long deleteTag(@Nonnull String id) throws KeyNotFoundException {
    return this.deleteTag(new ObjectId(id));
  }

  /**
   * Gets recipes by tag name.
   *
   * @param name the name
   * @return the recipes by tag name
   */
  public List<Recipe> getRecipesByTagName(@Nonnull String name) {
    List<Recipe> recipes = recipeDao.getRecipes();
    List<Recipe> ret = new ArrayList<>();
    for (Recipe recipe : recipes) {
      List<Tag> tags = recipe.getTags();
      for (Tag tag : tags) {
        if (tag.getName().equals(name)) {
          ret.add(recipe);
        }
      }
    }
    return ret;
  }

}
