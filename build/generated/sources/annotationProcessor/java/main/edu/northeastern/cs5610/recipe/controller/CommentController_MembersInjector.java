package edu.northeastern.cs5610.recipe.controller;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class CommentController_MembersInjector implements MembersInjector<CommentController> {
  private final Provider<CommentDao> commentDaoProvider;

  private final Provider<RecipeDao> recipeDaoProvider;

  public CommentController_MembersInjector(Provider<CommentDao> commentDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    this.commentDaoProvider = commentDaoProvider;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  public static MembersInjector<CommentController> create(Provider<CommentDao> commentDaoProvider,
      Provider<RecipeDao> recipeDaoProvider) {
    return new CommentController_MembersInjector(commentDaoProvider, recipeDaoProvider);}

  @Override
  public void injectMembers(CommentController instance) {
    injectCommentDao(instance, commentDaoProvider.get());
    injectRecipeDao(instance, recipeDaoProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.controller.CommentController.commentDao")
  public static void injectCommentDao(CommentController instance, CommentDao commentDao) {
    instance.commentDao = commentDao;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.controller.CommentController.recipeDao")
  public static void injectRecipeDao(CommentController instance, RecipeDao recipeDao) {
    instance.recipeDao = recipeDao;
  }
}
