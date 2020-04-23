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
public final class UserController_Factory implements Factory<UserController> {
  private final Provider<UserDao> userDaoProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public UserController_Factory(Provider<UserDao> userDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    this.userDaoProvider = userDaoProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  @Override
  public UserController get() {
    UserController instance = newInstance();
    UserController_MembersInjector.injectUserDao(instance, userDaoProvider.get());
    UserController_MembersInjector.injectRecipeDao(instance, recipeDaoProvider.get());
    return instance;
  }

  public static UserController_Factory create(Provider<UserDao> userDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    return new UserController_Factory(userDaoProvider, recipeDaoProvider);
  }

  public static UserController newInstance() {
    return new UserController();
  }
}
