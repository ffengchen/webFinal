package edu.northeastern.cs5610.recipe.view;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import edu.northeastern.cs5610.recipe.JsonTransformer;
import edu.northeastern.cs5610.recipe.controller.CommentController;
import edu.northeastern.cs5610.recipe.controller.RecipeController;
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
public final class UserView_MembersInjector implements MembersInjector<UserView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<UserController> userControllerProvider;

  private final Provider<RecipeController> recipeControllerProvider;

  private final Provider<CommentController> commentControllerProvider;

  public UserView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider,
      Provider<RecipeController> recipeControllerProvider,
      Provider<CommentController> commentControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.userControllerProvider = userControllerProvider;
    this.recipeControllerProvider = recipeControllerProvider;
    this.commentControllerProvider = commentControllerProvider;
  }

  public static MembersInjector<UserView> create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider,
      Provider<RecipeController> recipeControllerProvider,
      Provider<CommentController> commentControllerProvider) {
    return new UserView_MembersInjector(jsonTransformerProvider, userControllerProvider, recipeControllerProvider, commentControllerProvider);}

  @Override
  public void injectMembers(UserView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectUserController(instance, userControllerProvider.get());
    injectRecipeController(instance, recipeControllerProvider.get());
    injectCommentController(instance, commentControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.UserView.jsonTransformer")
  public static void injectJsonTransformer(UserView instance, JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.UserView.userController")
  public static void injectUserController(UserView instance, UserController userController) {
    instance.userController = userController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.UserView.recipeController")
  public static void injectRecipeController(UserView instance, RecipeController recipeController) {
    instance.recipeController = recipeController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.UserView.commentController")
  public static void injectCommentController(UserView instance,
      CommentController commentController) {
    instance.commentController = commentController;
  }
}
