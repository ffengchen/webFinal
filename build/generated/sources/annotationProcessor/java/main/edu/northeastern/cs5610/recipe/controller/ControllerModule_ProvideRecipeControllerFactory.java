package edu.northeastern.cs5610.recipe.controller;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ControllerModule_ProvideRecipeControllerFactory implements Factory<Controller> {
  private final ControllerModule module;

  private final Provider<RecipeController> recipeControllerProvider;

  public ControllerModule_ProvideRecipeControllerFactory(ControllerModule module,
      Provider<RecipeController> recipeControllerProvider) {
    this.module = module;
    this.recipeControllerProvider = recipeControllerProvider;
  }

  @Override
  public Controller get() {
    return provideRecipeController(module, recipeControllerProvider.get());
  }

  public static ControllerModule_ProvideRecipeControllerFactory create(ControllerModule module,
      Provider<RecipeController> recipeControllerProvider) {
    return new ControllerModule_ProvideRecipeControllerFactory(module, recipeControllerProvider);
  }

  public static Controller provideRecipeController(ControllerModule instance,
      RecipeController recipeController) {
    return Preconditions.checkNotNull(instance.provideRecipeController(recipeController), "Cannot return null from a non-@Nullable @Provides method");
  }
}
