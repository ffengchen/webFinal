package edu.northeastern.cs5610.recipe.controller;

import dagger.internal.Factory;
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
public final class TagController_Factory implements Factory<TagController> {
  private final Provider<TagDao> tagDaoProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public TagController_Factory(Provider<TagDao> tagDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    this.tagDaoProvider = tagDaoProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  @Override
  public TagController get() {
    TagController instance = newInstance();
    TagController_MembersInjector.injectTagDao(instance, tagDaoProvider.get());
    TagController_MembersInjector.injectRecipeDao(instance, recipeDaoProvider.get());
    return instance;
  }

  public static TagController_Factory create(Provider<TagDao> tagDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    return new TagController_Factory(tagDaoProvider, recipeDaoProvider);
  }

  public static TagController newInstance() {
    return new TagController();
  }
}
