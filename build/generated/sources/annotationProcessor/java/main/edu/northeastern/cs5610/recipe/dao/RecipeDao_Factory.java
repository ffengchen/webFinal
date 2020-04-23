package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
import edu.northeastern.cs5610.recipe.model.Recipe;
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
public final class RecipeDao_Factory implements Factory<RecipeDao> {
  private final Provider<MongoCollection<Recipe>> recipeCollectionProvider;

  public RecipeDao_Factory(Provider<MongoCollection<Recipe>> recipeCollectionProvider) {
    this.recipeCollectionProvider = recipeCollectionProvider;
  }

  @Override
  public RecipeDao get() {
    RecipeDao instance = newInstance();
    RecipeDao_MembersInjector.injectRecipeCollection(instance, recipeCollectionProvider.get());
    return instance;
  }

  public static RecipeDao_Factory create(
      Provider<MongoCollection<Recipe>> recipeCollectionProvider) {
    return new RecipeDao_Factory(recipeCollectionProvider);
  }

  public static RecipeDao newInstance() {
    return new RecipeDao();
  }
}
