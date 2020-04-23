package edu.northeastern.cs5610.recipe.controller;

import dagger.internal.Factory;
import edu.northeastern.cs5610.recipe.dao.RecipeDao;
import edu.northeastern.cs5610.recipe.dao.UserDao;
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
public final class RecipeController_Factory implements Factory<RecipeController> {
  private final Provider<UserDao> userDaoProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public RecipeController_Factory(Provider<UserDao> userDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    this.userDaoProvider = userDaoProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  @Override
  public RecipeController get() {
    RecipeController instance = newInstance();
    RecipeController_MembersInjector.injectUserDao(instance, userDaoProvider.get());
    RecipeController_MembersInjector.injectRecipeDao(instance, recipeDaoProvider.get());
    return instance;
  }

  public static RecipeController_Factory create(Provider<UserDao> userDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    return new RecipeController_Factory(userDaoProvider, recipeDaoProvider);
  }

  public static RecipeController newInstance() {
    return new RecipeController();
  }
}
