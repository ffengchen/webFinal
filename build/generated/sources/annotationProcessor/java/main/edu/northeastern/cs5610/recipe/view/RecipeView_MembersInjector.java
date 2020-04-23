package edu.northeastern.cs5610.recipe.view;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import edu.northeastern.cs5610.recipe.JsonTransformer;
import edu.northeastern.cs5610.recipe.controller.CommentController;
import edu.northeastern.cs5610.recipe.controller.RecipeController;
import edu.northeastern.cs5610.recipe.controller.TagController;
import edu.northeastern.cs5610.recipe.controller.UserController;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RecipeView_MembersInjector implements MembersInjector<RecipeView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<RecipeController> recipeControllerProvider;

  private final Provider<TagController> tagControllerProvider;

  private final Provider<CommentController> commentControllerProvider;

  private final Provider<UserController> userControllerProvider;

  public RecipeView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<RecipeController> recipeControllerProvider,
      Provider<TagController> tagControllerProvider,
      Provider<CommentController> commentControllerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.recipeControllerProvider = recipeControllerProvider;
    this.tagControllerProvider = tagControllerProvider;
    this.commentControllerProvider = commentControllerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  public static MembersInjector<RecipeView> create(
      Provider<JsonTransformer> jsonTransformerProvider,
      Provider<RecipeController> recipeControllerProvider,
      Provider<TagController> tagControllerProvider,
      Provider<CommentController> commentControllerProvider,
      Provider<UserController> userControllerProvider) {
    return new RecipeView_MembersInjector(jsonTransformerProvider, recipeControllerProvider, tagControllerProvider, commentControllerProvider, userControllerProvider);}

  @Override
  public void injectMembers(RecipeView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectRecipeController(instance, recipeControllerProvider.get());
    injectTagController(instance, tagControllerProvider.get());
    injectCommentController(instance, commentControllerProvider.get());
    injectUserController(instance, userControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.RecipeView.jsonTransformer")
  public static void injectJsonTransformer(RecipeView instance, JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.RecipeView.recipeController")
  public static void injectRecipeController(RecipeView instance,
      RecipeController recipeController) {
    instance.recipeController = recipeController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.RecipeView.tagController")
  public static void injectTagController(RecipeView instance, TagController tagController) {
    instance.tagController = tagController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.RecipeView.commentController")
  public static void injectCommentController(RecipeView instance,
      CommentController commentController) {
    instance.commentController = commentController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.RecipeView.userController")
  public static void injectUserController(RecipeView instance, UserController userController) {
    instance.userController = userController;
  }
}
