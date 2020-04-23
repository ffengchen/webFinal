package edu.northeastern.cs5610.recipe.view;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

/**
 * The type View module.
 */
@Module
public class ViewModule {

  /**
   * Provide recipe view view.
   *
   * @param recipeView the recipe view
   * @return the view
   */
  @Provides
  @IntoSet
  public View provideRecipeView(RecipeView recipeView) {
    return recipeView;
  }

  /**
   * Provide user view view.
   *
   * @param userView the user view
   * @return the view
   */
  @Provides
  @IntoSet
  public View provideUserView(UserView userView) {
    return userView;
  }

  /**
   * Provide tag view view.
   *
   * @param tagView the tag view
   * @return the view
   */
  @Provides
  @IntoSet
  public View provideTagView(TagView tagView) {
    return tagView;
  }

  /**
   * Provide comment view view.
   *
   * @param commentView the comment view
   * @return the view
   */
  @Provides
  @IntoSet
  public View provideCommentView(CommentView commentView) {
    return commentView;
  }
}
