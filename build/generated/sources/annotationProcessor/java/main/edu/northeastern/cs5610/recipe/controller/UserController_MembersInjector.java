package edu.northeastern.cs5610.recipe.controller;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class UserController_MembersInjector implements MembersInjector<UserController> {
  private final Provider<UserDao> userDaoProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public UserController_MembersInjector(Provider<UserDao> userDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    this.userDaoProvider = userDaoProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  public static MembersInjector<UserController> create(Provider<UserDao> userDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    return new UserController_MembersInjector(userDaoProvider, recipeDaoProvider);}

  @Override
  public void injectMembers(UserController instance) {
    injectUserDao(instance, userDaoProvider.get());
    injectRecipeDao(instance, recipeDaoProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.controller.UserController.userDao")
  public static void injectUserDao(UserController instance, UserDao userDao) {
    instance.userDao = userDao;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.controller.UserController.recipeDao")
  public static void injectRecipeDao(UserController instance, RecipeDao recipeDao) {
    instance.recipeDao = recipeDao;
  }
}
