package edu.northeastern.cs5610.recipe.view;

import dagger.internal.Factory;
import edu.northeastern.cs5610.recipe.JsonTransformer;
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
public final class TagView_Factory implements Factory<TagView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<TagController> tagControllerProvider;

  private final Provider<UserController> userControllerProvider;

  private final Provider<RecipeController> recipeControllerProvider;

  public TagView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<TagController> tagControllerProvider,
      Provider<UserController> userControllerProvider,
      Provider<RecipeController> recipeControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.tagControllerProvider = tagControllerProvider;
    this.userControllerProvider = userControllerProvider;
    this.recipeControllerProvider = recipeControllerProvider;
  }

  @Override
  public TagView get() {
    TagView instance = newInstance();
    TagView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    TagView_MembersInjector.injectTagController(instance, tagControllerProvider.get());
    TagView_MembersInjector.injectUserController(instance, userControllerProvider.get());
    TagView_MembersInjector.injectRecipeController(instance, recipeControllerProvider.get());
    return instance;
  }

  public static TagView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<TagController> tagControllerProvider,
      Provider<UserController> userControllerProvider,
      Provider<RecipeController> recipeControllerProvider) {
    return new TagView_Factory(jsonTransformerProvider, tagControllerProvider, userControllerProvider, recipeControllerProvider);
  }

  public static TagView newInstance() {
    return new TagView();
  }
}
