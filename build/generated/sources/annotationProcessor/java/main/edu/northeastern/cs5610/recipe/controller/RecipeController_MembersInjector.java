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
public final class RecipeController_MembersInjector implements MembersInjector<RecipeController> {
  private final Provider<UserDao> userDaoProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public RecipeController_MembersInjector(Provider<UserDao> userDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    this.userDaoProvider = userDaoProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  public static MembersInjector<RecipeController> create(Provider<UserDao> userDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    return new RecipeController_MembersInjector(userDaoProvider, recipeDaoProvider);}

  @Override
  public void injectMembers(RecipeController instance) {
    injectUserDao(instance, userDaoProvider.get());
    injectRecipeDao(instance, recipeDaoProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.controller.RecipeController.userDao")
  public static void injectUserDao(RecipeController instance, UserDao userDao) {
    instance.userDao = userDao;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.controller.RecipeController.recipeDao")
  public static void injectRecipeDao(RecipeController instance, RecipeDao recipeDao) {
    instance.recipeDao = recipeDao;
  }
}
