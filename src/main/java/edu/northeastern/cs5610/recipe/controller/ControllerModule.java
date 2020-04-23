package edu.northeastern.cs5610.recipe.controller;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

/**
 * The type Controller module.
 */
@Module
public class ControllerModule {

  /**
   * Provide recipe controller controller.
   *
   * @param recipeController the recipe controller
   * @return the controller
   */
  @Provides
  @IntoSet
  public Controller provideRecipeController(RecipeController recipeController) {
    return recipeController;
  }

  /**
   * Provide user controller controller.
   *
   * @param userController the user controller
   * @return the controller
   */
  @Provides
  @IntoSet
  public Controller provideUserController(UserController userController) {
    return userController;
  }

  /**
   * Provide comment controller controller.
   *
   * @param commentController the comment controller
   * @return the controller
   */
  @Provides
  @IntoSet
  public Controller provideCommentController(CommentController commentController) {
    return commentController;
  }


}
