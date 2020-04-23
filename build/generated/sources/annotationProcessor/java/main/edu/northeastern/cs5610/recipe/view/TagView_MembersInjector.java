package edu.northeastern.cs5610.recipe.view;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class TagView_MembersInjector implements MembersInjector<TagView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<TagController> tagControllerProvider;

  private final Provider<UserController> userControllerProvider;

  private final Provider<RecipeController> recipeControllerProvider;

  public TagView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<TagController> tagControllerProvider,
      Provider<UserController> userControllerProvider,
      Provider<RecipeController> recipeControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.tagControllerProvider = tagControllerProvider;
    this.userControllerProvider = userControllerProvider;
    this.recipeControllerProvider = recipeControllerProvider;
  }

  public static MembersInjector<TagView> create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<TagController> tagControllerProvider,
      Provider<UserController> userControllerProvider,
      Provider<RecipeController> recipeControllerProvider) {
    return new TagView_MembersInjector(jsonTransformerProvider, tagControllerProvider, userControllerProvider, recipeControllerProvider);}

  @Override
  public void injectMembers(TagView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectTagController(instance, tagControllerProvider.get());
    injectUserController(instance, userControllerProvider.get());
    injectRecipeController(instance, recipeControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.TagView.jsonTransformer")
  public static void injectJsonTransformer(TagView instance, JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.TagView.tagController")
  public static void injectTagController(TagView instance, TagController tagController) {
    instance.tagController = tagController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.TagView.userController")
  public static void injectUserController(TagView instance, UserController userController) {
    instance.userController = userController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.TagView.recipeController")
  public static void injectRecipeController(TagView instance, RecipeController recipeController) {
    instance.recipeController = recipeController;
  }
}
