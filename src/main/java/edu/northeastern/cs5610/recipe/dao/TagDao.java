package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.model.Tag;
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
public class TagDao implements Dao {

  /**
   * The Tag collection.
   */
  @Inject
  MongoCollection<Tag> tagCollection;

  /**
   * Instantiates a new Tag dao.
   */
  @Inject
  public TagDao() {
  }

  /**
   * Sets tag collection.
   *
   * @param tagCollection the tag collection
   */
  public void setTagCollection(MongoCollection<Tag> tagCollection) {
    this.tagCollection = tagCollection;
  }


  @Override
  public void register() {
    log.info("TagDao > register");
  }

  /**
   * Gets tag.
   *
   * @param id the id
   * @return the tag
   */
  public Tag getTag(@Nonnull ObjectId id) {
    log.debug("TagDao > getTag({})", id);
    return tagCollection.find(eq("_id", id)).first();
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
   * Gets tags.
   *
   * @return the tags
   */
  public List<Tag> getTags() {
    log.info("TagDao > getTags()");
    return tagCollection.find().into(new ArrayList<>());
  }

  /**
   * Gets tag by name.
   *
   * @param name the name
   * @return the tag by name
   */
  public Tag getTagByName(@Nonnull String name) {
    log.debug("TagDao > getTagByName({})", name);
    return tagCollection.find(eq("name", name)).first();
  }

  /**
   * Add tag object id.
   *
   * @param tag the tag
   * @return the object id
   * @throws NullKeyException the null key exception
   */
  @Nonnull
  public ObjectId addTag(@Nonnull Tag tag) throws NullKeyException {
    log.debug("TagDao > addRecipe(...)");
    tagCollection.insertOne(tag);
    ObjectId id = tag.getId();
    if (id == null) {
      throw new NullKeyException("insert failed!");
    }
    return id;
  }

  /**
   * Update tag.
   *
   * @param tag the tag
   * @throws NullKeyException the null key exception
   * @throws KeyNotFoundException the key not found exception
   */
  public void updateTag(@Nonnull Tag tag) throws NullKeyException, KeyNotFoundException {
    log.debug("TagDao > updateTag(...)");
    ObjectId id = tag.getId();
    if (id == null) {
      throw new NullKeyException("NullKeyException");
    }
    if (getTag(id) == null) {
      throw new KeyNotFoundException("KeyNotFoundException");
    }
    DatabaseUtil.updateHelper(tag, id, tagCollection);
  }

  /**
   * Delete tag long.
   *
   * @param id the id
   * @return the long
   * @throws KeyNotFoundException the key not found exception
   */
  public long deleteTag(@Nonnull ObjectId id) throws KeyNotFoundException {
    log.debug("TagDao > deleteTag(...)");
    DeleteResult deleteResult = tagCollection.deleteOne(eq("_id", id));
    long res = deleteResult.getDeletedCount();
    if (res == 0) {
      throw new KeyNotFoundException("Cannot find the key to delete");
    }
    return res;
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


}
