package edu.northeastern.cs5610.recipe.controller;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import edu.northeastern.cs5610.recipe.dao.RecipeDao;
import edu.northeastern.cs5610.recipe.dao.TagDao;
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
public final class TagController_MembersInjector implements MembersInjector<TagController> {
  private final Provider<TagDao> tagDaoProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public TagController_MembersInjector(Provider<TagDao> tagDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    this.tagDaoProvider = tagDaoProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  public static MembersInjector<TagController> create(Provider<TagDao> tagDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    return new TagController_MembersInjector(tagDaoProvider, recipeDaoProvider);}

  @Override
  public void injectMembers(TagController instance) {
    injectTagDao(instance, tagDaoProvider.get());
    injectRecipeDao(instance, recipeDaoProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.controller.TagController.tagDao")
  public static void injectTagDao(TagController instance, TagDao tagDao) {
    instance.tagDao = tagDao;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.controller.TagController.recipeDao")
  public static void injectRecipeDao(TagController instance, RecipeDao recipeDao) {
    instance.recipeDao = recipeDao;
  }
}
