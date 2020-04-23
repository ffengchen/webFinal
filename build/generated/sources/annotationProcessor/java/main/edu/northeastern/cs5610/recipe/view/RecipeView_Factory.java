package edu.northeastern.cs5610.recipe.view;

import dagger.internal.Factory;
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
public final class RecipeView_Factory implements Factory<RecipeView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<RecipeController> recipeControllerProvider;

  private final Provider<TagController> tagControllerProvider;

  private final Provider<CommentController> commentControllerProvider;

  private final Provider<UserController> userControllerProvider;

  public RecipeView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
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

  @Override
  public RecipeView get() {
    RecipeView instance = newInstance();
    RecipeView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    RecipeView_MembersInjector.injectRecipeController(instance, recipeControllerProvider.get());
    RecipeView_MembersInjector.injectTagController(instance, tagControllerProvider.get());
    RecipeView_MembersInjector.injectCommentController(instance, commentControllerProvider.get());
    RecipeView_MembersInjector.injectUserController(instance, userControllerProvider.get());
    return instance;
  }

  public static RecipeView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<RecipeController> recipeControllerProvider,
      Provider<TagController> tagControllerProvider,
      Provider<CommentController> commentControllerProvider,
      Provider<UserController> userControllerProvider) {
    return new RecipeView_Factory(jsonTransformerProvider, recipeControllerProvider, tagControllerProvider, commentControllerProvider, userControllerProvider);
  }

  public static RecipeView newInstance() {
    return new RecipeView();
  }
}
