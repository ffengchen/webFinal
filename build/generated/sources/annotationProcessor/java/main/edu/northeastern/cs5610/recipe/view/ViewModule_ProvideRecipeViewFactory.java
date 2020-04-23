package edu.northeastern.cs5610.recipe.view;

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
public final class ViewModule_ProvideRecipeViewFactory implements Factory<View> {
  private final ViewModule module;

  private final Provider<RecipeView> recipeViewProvider;

  public ViewModule_ProvideRecipeViewFactory(ViewModule module,
      Provider<RecipeView> recipeViewProvider) {
    this.module = module;
    this.recipeViewProvider = recipeViewProvider;
  }

  @Override
  public View get() {
    return provideRecipeView(module, recipeViewProvider.get());
  }

  public static ViewModule_ProvideRecipeViewFactory create(ViewModule module,
      Provider<RecipeView> recipeViewProvider) {
    return new ViewModule_ProvideRecipeViewFactory(module, recipeViewProvider);
  }

  public static View provideRecipeView(ViewModule instance, RecipeView recipeView) {
    return Preconditions.checkNotNull(instance.provideRecipeView(recipeView), "Cannot return null from a non-@Nullable @Provides method");
  }
}
