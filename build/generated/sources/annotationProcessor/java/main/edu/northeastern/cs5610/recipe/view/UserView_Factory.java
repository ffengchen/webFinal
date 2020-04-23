package edu.northeastern.cs5610.recipe.view;

import dagger.internal.Factory;
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
public final class UserView_Factory implements Factory<UserView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<UserController> userControllerProvider;

  private final Provider<RecipeController> recipeControllerProvider;

  private final Provider<CommentController> commentControllerProvider;

  public UserView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider,
      Provider<RecipeController> recipeControllerProvider,
      Provider<CommentController> commentControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.userControllerProvider = userControllerProvider;
    this.recipeControllerProvider = recipeControllerProvider;
    this.commentControllerProvider = commentControllerProvider;
  }

  @Override
  public UserView get() {
    UserView instance = newInstance();
    UserView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    UserView_MembersInjector.injectUserController(instance, userControllerProvider.get());
    UserView_MembersInjector.injectRecipeController(instance, recipeControllerProvider.get());
    UserView_MembersInjector.injectCommentController(instance, commentControllerProvider.get());
    return instance;
  }

  public static UserView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider,
      Provider<RecipeController> recipeControllerProvider,
      Provider<CommentController> commentControllerProvider) {
    return new UserView_Factory(jsonTransformerProvider, userControllerProvider, recipeControllerProvider, commentControllerProvider);
  }

  public static UserView newInstance() {
    return new UserView();
  }
}
