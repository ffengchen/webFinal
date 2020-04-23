package edu.northeastern.cs5610.recipe.controller;

import dagger.internal.Factory;
import edu.northeastern.cs5610.recipe.dao.CommentDao;
import edu.northeastern.cs5610.recipe.dao.RecipeDao;
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
public final class CommentController_Factory implements Factory<CommentController> {
  private final Provider<CommentDao> commentDaoProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public CommentController_Factory(Provider<CommentDao> commentDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    this.commentDaoProvider = commentDaoProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  @Override
  public CommentController get() {
    CommentController instance = newInstance();
    CommentController_MembersInjector.injectCommentDao(instance, commentDaoProvider.get());
    CommentController_MembersInjector.injectRecipeDao(instance, recipeDaoProvider.get());
    return instance;
  }

  public static CommentController_Factory create(Provider<CommentDao> commentDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    return new CommentController_Factory(commentDaoProvider, recipeDaoProvider);
  }

  public static CommentController newInstance() {
    return new CommentController();
  }
}
