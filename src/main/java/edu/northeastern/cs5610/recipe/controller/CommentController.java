package edu.northeastern.cs5610.recipe.controller;


import edu.northeastern.cs5610.recipe.dao.CommentDao;
import edu.northeastern.cs5610.recipe.dao.RecipeDao;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.model.Comment;
import edu.northeastern.cs5610.recipe.model.Recipe;

import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

/**
 * The type Comment controller.
 */
@Singleton
@Slf4j
public class CommentController implements Controller {

    /**
     * The Comment dao.
     */
    @Inject
    CommentDao commentDao;

    /**
     * The Recipe dao.
     */
    @Inject
    RecipeDao recipeDao;

    /**
     * Instantiates a new Comment controller.
     */
    @Inject
  public CommentController() {
  }

  @Override
  public void register() {
    log.info("CommentController > register");
  }

    /**
     * Sets comment dao.
     *
     * @param commentDao the comment dao
     */
    public void setCommentDao(CommentDao commentDao) {
    this.commentDao = commentDao;
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
     * Gets comment.
     *
     * @param id the id
     * @return the comment
     */
    public Comment getComment(@Nonnull ObjectId id) {

    log.debug("CommentController > getComment({})", id);
    return this.commentDao.getComment(id);
  }

    /**
     * Gets comment.
     *
     * @param id the id
     * @return the comment
     */
    public Comment getComment(@Nonnull String id) {
    return this.getComment(new ObjectId(id));
  }

    /**
     * Get all comments in the database
     *
     * @return A List of Comment object.
     */
    public List<Comment> getComments() {
    log.info("CommentController > getComments()");
    return commentDao.getComments();
  }

    /**
     * add a new Comment object to database
     *
     * @param comment A Comment object. Should not contain any id field.
     * @return A string of id of that new comment.
     * @throws NullKeyException If we don't have an id from the db, throws an exception
     */
    @Nonnull
  public ObjectId addComment(@Nonnull Comment comment) throws NullKeyException {

    log.debug("CommentController > addRecipe(...)");

    return commentDao.addComment(comment);
  }

    /**
     * Update the comment with all non-null fields except id.
     *
     * @param comment The Comment Object
     * @throws NullKeyException thrown when key is null
     * @throws KeyNotFoundException thrown when that item is not in db
     */
    public void updateComment(@Nonnull Comment comment)
      throws NullKeyException, KeyNotFoundException {
    log.debug("CommentController > updateComment(...)");
    commentDao.updateComment(comment);
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
    log.debug("CommentController > deleteComment(...)");
    return commentDao.deleteComment(id);
  }

    /**
     * Gets comments by username.
     *
     * @param username the username
     * @return the comments by username
     */
    public List<Comment> getCommentsByUsername(@Nonnull String username) {
    log.debug("CommentController > getCommentsByUsername(...)");
    return commentDao.getCommentsByUsername(username);
  }

    /**
     * Gets comments by recipe id.
     *
     * @param id the recipe id
     * @return the comments by recipe id
     */
    public List<Comment> getCommentsByRecipeId(@Nonnull ObjectId id) {
    log.debug("CommentController > getCommentsByUsername(...)");
    return commentDao.getCommentsByRecipeId(id);
  }

    /**
     * Gets comments by recipe id.
     *
     * @param id the id
     * @return the comments by recipe id
     */
    public List<Comment> getCommentsByRecipeId(@Nonnull String id) {
    return this.getCommentsByRecipeId(new ObjectId(id));
  }

    /**
     * Gets recipe title by comment id.
     *
     * @param id the id
     * @return the recipe title by comment id
     */
    public String getRecipeTitleByCommentId(@Nonnull ObjectId id) {
    log.debug("CommentCOntroller > getRecipeTitleByCommentId: " + id.toHexString());
    Comment comment = commentDao.getComment(id);
    ObjectId recipeId = comment.getRecipeId();
    Recipe recipe = recipeDao.getRecipe(recipeId);
    return recipe.getTitle();
  }

    /**
     * Gets recipe title by comment id.
     *
     * @param id the id
     * @return the recipe title by comment id
     */
    public String getRecipeTitleByCommentId(@Nonnull String id) {
    return this.getRecipeTitleByCommentId(new ObjectId(id));
  }
}
