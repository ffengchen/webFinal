package edu.northeastern.cs5610.recipe.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.cs5610.recipe.JsonTransformer;
import edu.northeastern.cs5610.recipe.controller.CommentController;
import edu.northeastern.cs5610.recipe.controller.RecipeController;
import edu.northeastern.cs5610.recipe.controller.TagController;
import edu.northeastern.cs5610.recipe.controller.UserController;
import edu.northeastern.cs5610.recipe.exception.DuplicateKeyException;
import edu.northeastern.cs5610.recipe.exception.KeyNotFoundException;
import edu.northeastern.cs5610.recipe.exception.NullKeyException;
import edu.northeastern.cs5610.recipe.exception.UsernameNotFoundException;
import edu.northeastern.cs5610.recipe.model.Comment;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.Tag;
import edu.northeastern.cs5610.recipe.model.User;
import edu.northeastern.cs5610.recipe.util.LoginUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import spark.Request;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.northeastern.cs5610.recipe.util.RenderUtil.renderTemplate;
import static spark.Spark.*;

/**
 * The type Recipe view.
 */
@Singleton
@Slf4j
public class
RecipeView implements View {

  /**
   * The Json transformer.
   */
  @Inject
  JsonTransformer jsonTransformer;
  /**
   * The Recipe controller.
   */
  @Inject
  RecipeController recipeController;

  /**
   * The Tag controller.
   */
  @Inject
  TagController tagController;

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

  /**
   * Instantiates a new Recipe view.
   */
  @Inject
  RecipeView() {
  }

  private String renderRecipes(Request req) {
    Map<String, Object> model = new HashMap<>();
    List<Recipe> recipes = recipeController.getRecipes();
    User user = LoginUtil.getAuthenticatedUser(req);
    model.put("recipes", recipes);
    model.put("user", user);
    return renderTemplate("velocity/index.vm", model);
  }

  @Override
  public void register() {
    log.info("RecipeView > register");
    get("/", (req, res) -> renderRecipes(req));

    get("/recipes", (req, res) -> renderTemplate("velocity/recipes.vm", new HashMap<>()));

    get(
        "/recipe",
        (request, response) -> {
          log.debug("/recipe");
          response.type("application/json");
          return recipeController.getRecipes();
        },
        jsonTransformer);

    get(
        "/recipe/:id",
        (request, response) -> {
          final String paramId = request.params(":id");
          log.debug("/recipe/:id<{}>", paramId);
          Recipe recipe = recipeController.getRecipe(paramId);
          if (recipe == null) {
            halt(404);
          }
          List<Comment> comments = commentController.getCommentsByRecipeId(recipe.getId());

          Map<String, Object> model = new HashMap<>();

          User author = userController.getUser(recipe.getUserId().toHexString());
          User authUser = LoginUtil.getAuthenticatedUser(request);

          model.put("recipeId", paramId);
          model.put("title", recipe.getTitle());
          model.put("description", recipe.getDescription());
          model.put("content", recipe.getContent());
          model.put("createTime", recipe.getCreateTime());
          model.put("tags", recipe.getTags());
          model.put("lastEditTime", recipe.getLastEditTime());
          model.put("comments", comments);
          model.put("thumbnail", recipe.getThumbnail());
          model.put("userThumbnail", author.getThumbnail());
          model.put("username", author.getUsername());
          model.put("userId", author.getId());
          model.put("user", authUser);

          return renderTemplate("velocity/recipe.vm", model);
        });

    post(
        "/recipe",
        (request, response) -> {
          ObjectMapper mapper = new ObjectMapper();
          Recipe recipe = mapper.readValue(request.body(), Recipe.class);
          if (recipe.isInvalid()) {
            response.status(400);
            return "";
          }
          recipe.setId(null);
          ObjectId id = recipeController.addRecipe(recipe);
          response.redirect("/recipe/" + id.toHexString(), 301);
          return recipe;
        });

    put(
        "/recipe",
        (request, response) -> {
          ObjectMapper mapper = new ObjectMapper();
          Recipe recipe = mapper.readValue(request.body(), Recipe.class);
          if (recipe.isInvalid()) {
            response.status(400);
            return "";
          }
          ObjectId id = recipe.getId();
          recipeController.updateRecipe(recipe);
          response.redirect("/recipe/" + id.toHexString(), 301);
          return recipe;
        });

    delete(
        "/recipe/:id",
        (request, response) -> {
          String id = request.params("id");
          long res = recipeController.deleteRecipe(id);
          if (res == 0) {
            halt(404);
          }
          response.redirect("/recipe", 301);
          return id;


        });

    get(
        "/createrecipe/:id",
        (request, response) -> {
          log.debug("/createRecipe");

          Map<String, Object> model = new HashMap<>();
          List<Tag> tags = tagController.getTags();
          model.put("tags", tags);
          return renderTemplate("velocity/createRecipe.vm", model);
        });
    post(
        "/createrecipe/:id",
        (request, response) -> {
          log.debug("post/recipe");
          final String userId = request.params(":id");
          //User user = request.session().attribute("user");
          //System.out.println(user.getPassword());
          String title = request.queryParams("title");
          String description = request.queryParams("description");
          String content = request.queryParams("content");
          String thumbnail = request.queryParams("thumbnail");
          List<String> tagIds = Arrays.asList(request.queryParamsValues("tags[]"));
          List<Tag> tags = new ArrayList<>();
          for (String id : tagIds) {
            tags.add(tagController.getTag(id));
          }
          Recipe recipe = new Recipe();
          recipe.setTitle(title);
          recipe.setUserId(new ObjectId(userId));
          recipe.setDescription(description);
          recipe.setContent(content);
          recipe.setThumbnail(thumbnail);
          recipe.setTags(tags);
          recipe.setCreateTime(new Date());
          recipe.setLastEditTime(new Date());
          recipeController.addRecipe(recipe);
          response.redirect("/");
          return renderTemplate("velocity/createRecipe.vm", new HashMap<>());
        });

    get(
        "/updaterecipe/:id",
        (request, response) -> {
          final String paramId = request.params(":id");
          log.debug("/recipe/:id<{}>", paramId);
          Recipe recipe = recipeController.getRecipe(paramId);
          if (recipe == null) {
            halt(404);
          }

          Map<String, Object> model = new HashMap<>();
          model.put("title", recipe.getTitle());
          model.put("description", recipe.getDescription());
          model.put("content", recipe.getContent());
          model.put("createTime", recipe.getCreateTime());
          model.put("chosenTags", recipe.getTags());
          model.put("allTags", tagController.getTags());
          model.put("lastEditTime", recipe.getLastEditTime());
          model.put("thumbnail", recipe.getThumbnail());
          model.put("id", paramId);
          return renderTemplate("velocity/updateRecipe.vm", model);
        });

    post(
        "/updaterecipe/:id",
        (request, response) -> {
          log.debug("post/recipe");
          final String paramId = request.params(":id");
          Recipe recipe = recipeController.getRecipe(paramId);
          String title = request.queryParams("title");
          String description = request.queryParams("description");
          String content = request.queryParams("content");
          String thumbnail = request.queryParams("thumbnail");
          List<String> tagIds = Arrays.asList(request.queryParamsValues("tags[]"));
          List<Tag> tags = new ArrayList<>();
          for (String id : tagIds) {
            tags.add(tagController.getTag(id));
          }
          recipe.setTitle(title);
          recipe.setDescription(description);
          recipe.setContent(content);
          recipe.setThumbnail(thumbnail);
          recipe.setTags(tags);
          recipe.setLastEditTime(new Date());
          recipeController.updateRecipe(recipe);
          response.redirect("/");
          return renderTemplate("velocity/updateRecipe.vm", new HashMap<>());
        });




  }


}
