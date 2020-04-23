package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.model.Comment;
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
public class CommentDao implements Dao {

  /**
   * The Comment collection.
   */
  @Inject
  MongoCollection<Comment> commentCollection;


  /**
   * Instantiates a new Comment dao.
   */
  @Inject
  public CommentDao() {
  }

  @Override
  public void register() {
    log.info("CommentDao > register");
  }

  /**
   * Set the comment controller for test
   *
   * @param commentCollection the comment collection
   */
  public void setCommentCollection(MongoCollection<Comment> commentCollection) {
    this.commentCollection = commentCollection;
  }

  /**
   * Gets comment.
   *
   * @param id the id
   * @return the comment
   */
// CRUD
  public Comment getComment(String id) {
    return this.getComment(new ObjectId(id));
  }

  /**
   * Gets comment.
   *
   * @param id the id
   * @return the comment
   */
  public Comment getComment(ObjectId id) {
    log.debug("CommentDao > getComment({})", id);
    return commentCollection.find(eq("_id", id)).first();
  }

  /**
   * Gets comments.
   *
   * @return the comments
   */
  public List<Comment> getComments() {
    log.info("CommentDao > getComments()");
    return commentCollection.find().into(new ArrayList<>());
  }

  /**
   * Add comment object id.
   *
   * @param comment the comment
   * @return the object id
   * @throws NullKeyException the null key exception
   */
  @Nonnull
  public ObjectId addComment(@Nonnull Comment comment) throws NullKeyException {

    log.debug("CommentDao > addRecipe(...)");

    commentCollection.insertOne(comment);
    ObjectId id = comment.getId();
    if (id == null) {
      throw new NullKeyException("insert failed!");
    }
    return id;
  }

  /**
   * Update comment.
   *
   * @param comment the comment
   * @throws NullKeyException the null key exception
   * @throws KeyNotFoundException the key not found exception
   */
  public void updateComment(@Nonnull Comment comment)
      throws NullKeyException, KeyNotFoundException {
    log.debug("CommentDao > updateComment(...)");
    ObjectId id = comment.getId();
    if (id == null) {
      throw new NullKeyException("NullKeyException");
    }

    if (getComment(id) == null) {
      throw new KeyNotFoundException("KeyNotFoundException");
    }
    DatabaseUtil.updateHelper(comment, id, commentCollection);
  }

  /**
   * Delete comment long.
   *
   * @param id the id
   * @return the long
   * @throws KeyNotFoundException the key not found exception
   */
  public long deleteComment(@Nonnull String id) throws KeyNotFoundException {
    return this.deleteComment(new ObjectId(id));
  }

  /**
   * Delete comment long.
   *
   * @param id the id
   * @return the long
   * @throws KeyNotFoundException the key not found exception
   */
  public long deleteComment(@Nonnull ObjectId id) throws KeyNotFoundException {
    log.debug("CommentDao > deleteComment(...)");
    DeleteResult deleteResult = commentCollection.deleteOne(eq("_id", id));
    long res = deleteResult.getDeletedCount();
    if (res == 0) {
      throw new KeyNotFoundException("Cannot find the key to delete");
    }
    return res;
  }

  /**
   * Gets comments by username.
   *
   * @param username the username
   * @return the comments by username
   */
  public List<Comment> getCommentsByUsername(String username) {
    log.debug("CommentDao > getCommentsByUsername(...)");
    List<Comment> comments =
        commentCollection.find(eq("username", username)).into(new ArrayList<>());

    return comments;
  }

  /**
   * Gets comments by recipe id.
   *
   * @param id the id
   * @return the comments by recipe id
   */
  public List<Comment> getCommentsByRecipeId(ObjectId id) {
    log.debug("CommentDao > getCommentsByUsername(...)");

    List<Comment> comments = commentCollection.find(eq("recipeId", id)).into(new ArrayList<>());

    return comments;
  }

  /**
   * Gets comments by recipe id.
   *
   * @param id the id
   * @return the comments by recipe id
   */
  public List<Comment> getCommentsByRecipeId(String id) {
    return this.getCommentsByRecipeId(new ObjectId(id));
  }

}
