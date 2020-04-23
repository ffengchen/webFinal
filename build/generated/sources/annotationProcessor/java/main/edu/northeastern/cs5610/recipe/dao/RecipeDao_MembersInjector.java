package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class RecipeDao_MembersInjector implements MembersInjector<RecipeDao> {
  private final Provider<MongoCollection<Recipe>> recipeCollectionProvider;

  public RecipeDao_MembersInjector(Provider<MongoCollection<Recipe>> recipeCollectionProvider) {
    this.recipeCollectionProvider = recipeCollectionProvider;
  }

  public static MembersInjector<RecipeDao> create(
      Provider<MongoCollection<Recipe>> recipeCollectionProvider) {
    return new RecipeDao_MembersInjector(recipeCollectionProvider);}

  @Override
  public void injectMembers(RecipeDao instance) {
    injectRecipeCollection(instance, recipeCollectionProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.dao.RecipeDao.recipeCollection")
  public static void injectRecipeCollection(RecipeDao instance,
      MongoCollection<Recipe> recipeCollection) {
    instance.recipeCollection = recipeCollection;
  }
}
