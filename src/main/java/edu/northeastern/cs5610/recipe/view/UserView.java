package edu.northeastern.cs5610.recipe.view;


import edu.northeastern.cs5610.recipe.JsonTransformer;
import edu.northeastern.cs5610.recipe.controller.CommentController;
import edu.northeastern.cs5610.recipe.controller.RecipeController;
import edu.northeastern.cs5610.recipe.controller.UserController;

import edu.northeastern.cs5610.recipe.exception.UsernameNotFoundException;
import edu.northeastern.cs5610.recipe.model.Comment;
import edu.northeastern.cs5610.recipe.model.Recipe;

import edu.northeastern.cs5610.recipe.model.User;
import edu.northeastern.cs5610.recipe.util.LoginUtil;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;


import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.northeastern.cs5610.recipe.util.LoginUtil.getAuthenticatedUser;
import static edu.northeastern.cs5610.recipe.util.LoginUtil.removeAuthenticatedUser;
import static edu.northeastern.cs5610.recipe.util.RenderUtil.renderTemplate;
import static spark.Spark.*;

/**
 * The type User view.
 */
@Singleton
@Slf4j
public class UserView implements View {

  /**
   * Instantiates a new User view.
   */
  @Inject
  UserView() {
  }

  /**
   * The Json transformer.
   */
  @Inject
  JsonTransformer jsonTransformer;

  /**
   * The User controller.
   */
  @Inject
  UserController userController;

  /**
   * The Recipe controller.
   */
  @Inject
  RecipeController recipeController;

  /**
   * The Comment controller.
   */
  @Inject
  CommentController commentController;


  @Override
  public void register() {
    log.info("UserView > register");
    // only for test use, check all existed users
    get(
        "/user",
        (request, response) -> {
          log.debug("/user");
          response.type("application/json");
          Collection<User> ret = userController.getUsers();
          return ret;
        },
        jsonTransformer);

    // go to the user info page
    get(
        "/user/:id",
        (request, response) -> {
          final String userId = request.params(":id");
          log.debug("/user/:id<{}>", userId);
          User user = userController.getUser(userId);
          if (user == null) {
            halt(404);
          }
          List<Recipe> recipes = recipeController.getRecipesByUsername(user.getUsername());
          List<Comment> comments = commentController.getCommentsByUsername(user.getUsername());

          Map<String, Object> model = new HashMap<>();
          Map<ObjectId, String> commentTitle = new HashMap<>();
//          List<User> followedUsers = new ArrayList<>();
//          for (ObjectId i : user.getFollowed()) {
//            followedUsers.add(userController.getUser(i));
//          }
//          List<Recipe> favouriteRecipes = new ArrayList<>();
//          for (ObjectId i : user.getFavorite()) {
//            favouriteRecipes.add(recipeController.getRecipe(i));
//          }
          for (Comment comment : comments) {
            commentTitle
                .put(comment.getId(), recipeController.getRecipe(comment.getRecipeId()).getTitle());
          }

          model.put("username", user.getUsername());
          model.put("id", userId);
          model.put("createTime", user.getCreateTime());
          model.put("userGroup", user.getUserGroup());
//          model.put("favorite", favouriteRecipes);
//          model.put("followed", followedUsers);
          model.put("recipes", recipes);
          model.put("comments", comments);
          model.put("thumbnail", user.getThumbnail());
          model.put("commentTitle", commentTitle);
          User authenticatedUser = getAuthenticatedUser(request);
          model.put("user", authenticatedUser);

          return renderTemplate("velocity/userProfile.vm", model);
        });


    // login
    get(
        "/login",
        (request, response) -> {
          log.debug("/login");
          return renderTemplate("velocity/login.vm", new HashMap<>());
        });
    post(
        "/login",
        (request, response) -> {
          log.debug("/login");

          String email = request.queryParams("email");
          String password = request.queryParams("password");
          boolean loginResult = false;
          try {
            loginResult = userController.userLogin(email, password);
          } catch (UsernameNotFoundException e) {
            return renderTemplate("velocity/login.vm", new HashMap<>());
          }
          if (loginResult) {
            LoginUtil.addAuthenticatedUser(request, userController.getUserByEmail(email));
            response.redirect("/");
            halt();
          }
          return renderTemplate("velocity/login.vm", new HashMap<>());
        });


    get("/logout", (req, res) -> {
      removeAuthenticatedUser(req);
      res.redirect("/");
      return null;
    });

    //register
    get(
        "/register",
        (request, response) -> {
          log.debug("get /register");
          return renderTemplate("velocity/register.vm", new HashMap<>());
        });
    post(
        "/register",
        (request, response) -> {
          log.debug("post /register");
          String email = request.queryParams("email");
          String password = request.queryParams("password");
          String username = request.queryParams("username");
          boolean registerResult = userController.userRegister(username, email, password);
          if (registerResult) {
            response.redirect("/login");
            halt();
          }
          return renderTemplate("velocity/register.vm", new HashMap<>());
        });


  }


}
