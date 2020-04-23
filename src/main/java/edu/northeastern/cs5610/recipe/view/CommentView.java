package edu.northeastern.cs5610.recipe.view;

import static spark.Spark.get;
import static spark.Spark.post;

import edu.northeastern.cs5610.recipe.JsonTransformer;
import edu.northeastern.cs5610.recipe.controller.CommentController;
import edu.northeastern.cs5610.recipe.controller.UserController;
import edu.northeastern.cs5610.recipe.model.Comment;
import java.util.Collection;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

/**
 * The type Comment view.
 */
@Singleton
@Slf4j
public class CommentView implements View {

  /**
   * Instantiates a new Comment view.
   */
  @Inject
  CommentView() {
  }

  /**
   * The Json transformer.
   */
  @Inject
  JsonTransformer jsonTransformer;

  /**
   * The Comment controller.
   */
  @Inject
  CommentController commentController;
  /**
   * The User controller.
   */
  @Inject
  UserController userController;

  @Override
  public void register() {
    log.info("CommentView > register");

    get(
        "/comment",
        (request, response) -> {
          log.debug("/comment");
          response.type("application/json");
          Collection<Comment> ret = commentController.getComments();
          for (Comment c : ret) {
            System.out.println(c);
          }
          return ret;
        },
        jsonTransformer);

    post(
        "/recipe/:id",
        (request, response) -> {
          log.debug("new comment");
          String content = request.queryParams("comment");
          Comment comment = new Comment();
          comment.setContent(content);
          comment.setCreateTime(new Date());
          String id = request.params(":id");
          comment.setRecipeId(new ObjectId(id));
          String username = request.queryParams("user");
          comment.setUsername(username);
          commentController.addComment(comment);
          response.redirect("/recipe/" + id, 301);
          return comment;
        });
  }
}
