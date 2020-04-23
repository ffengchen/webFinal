package edu.northeastern.cs5610.recipe.view;

import static edu.northeastern.cs5610.recipe.util.RenderUtil.renderTemplate;


import edu.northeastern.cs5610.recipe.JsonTransformer;
import edu.northeastern.cs5610.recipe.controller.RecipeController;
import edu.northeastern.cs5610.recipe.controller.TagController;
import edu.northeastern.cs5610.recipe.controller.UserController;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.Tag;
import edu.northeastern.cs5610.recipe.model.User;
import edu.northeastern.cs5610.recipe.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import spark.Request;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.delete;

/**
 * The type Tag view.
 */
@Singleton
@Slf4j
public class TagView implements View {

  /**
   * Instantiates a new Tag view.
   */
  @Inject
  TagView() {
  }

  /**
   * The Json transformer.
   */
  @Inject
  JsonTransformer jsonTransformer;

  /**
   * The Tag controller.
   */
  @Inject
  TagController tagController;

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


  private String renderTags(Request req) {
    List<Tag> tags = tagController.getTags();
    Map<String, Object> model = new HashMap<>();
    Map<ObjectId, Integer> tagRecipes = new HashMap<>();
    List<Recipe> recipes = recipeController.getRecipes();

    for (Recipe recipe : recipes) {
      List<Tag> tagsOfRecipe = recipe.getTags();
      for (Tag tag : tagsOfRecipe) {
        ObjectId tagId = tag.getId();
        tagRecipes.put(tagId, tagRecipes.getOrDefault(tagId, 0) + 1);
      }
    }
    User user = LoginUtil.getAuthenticatedUser(req);
    model.put("tags", tags);
    model.put("user", user);
    model.put("tagRecipes", tagRecipes);
    return renderTemplate("velocity/tagsManagement.vm", model);
  }

  @Override
  public void register() {
    log.info("TagView > register");

    get("/tagsmanagement",
        (req, res) -> renderTags(req));

    post(
        "/tagsmanagement",
        (request, response) -> {
          log.debug("new tag");
          String name = request.queryParams("newTag");
          tagController.addTag(name);

          response.redirect("/tagsmanagement");
          return renderTags(request);
        });

    delete(
        "/tagsmanagement/:id",
        (request, response) -> {
          log.debug("delete request get");
          String id = request.params(":id");
          System.out.println("delete " + id);

          tagController.deleteTag(id);
          List<Tag> tags = tagController.getTags();
          Map<String, Object> model = new HashMap<>();
          User user = LoginUtil.getAuthenticatedUser(request);
          model.put("tags", tags);
          model.put("user", user);
          return renderTemplate("velocity/tags.vm", model);
        });

    get("/tag/:id",
        (req, res) -> {
          final String paramId = req.params(":id");
          log.debug("/tag/:id<{}>", paramId);
          Tag tag = tagController.getTag(paramId);
          if (tag == null) {
            halt(404);
          }
          List<Recipe> recipes = tagController.getRecipesByTagName(tag.getName());
          Map<String, Object> model = new HashMap<>();
          Map<ObjectId, User> recipeAuthor = new HashMap<>();
          for (Recipe recipe : recipes) {
            ObjectId recipeId = recipe.getId();
            ObjectId userId = recipe.getUserId();
            User author = userController.getUser(userId);
            if (author == null) {
              recipeAuthor.put(recipeId, new User());
            } else {
              recipeAuthor.put(recipeId, author);
            }
          }
          User user = LoginUtil.getAuthenticatedUser(req);
          model.put("recipes", recipes);
          model.put("user", user);
          model.put("tag", tag);
          model.put("recipeAuthor", recipeAuthor);
          return renderTemplate("velocity/tag.vm", model);
        });
  }
}
