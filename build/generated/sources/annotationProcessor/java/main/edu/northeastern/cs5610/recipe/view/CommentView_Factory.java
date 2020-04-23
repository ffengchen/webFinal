package edu.northeastern.cs5610.recipe.view;

import dagger.internal.Factory;
import edu.northeastern.cs5610.recipe.JsonTransformer;
import edu.northeastern.cs5610.recipe.controller.CommentController;
import edu.northeastern.cs5610.recipe.controller.UserController;
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
public final class CommentView_Factory implements Factory<CommentView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<CommentController> commentControllerProvider;

  private final Provider<UserController> userControllerProvider;

  public CommentView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<CommentController> commentControllerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.commentControllerProvider = commentControllerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  @Override
  public CommentView get() {
    CommentView instance = newInstance();
    CommentView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    CommentView_MembersInjector.injectCommentController(instance, commentControllerProvider.get());
    CommentView_MembersInjector.injectUserController(instance, userControllerProvider.get());
    return instance;
  }

  public static CommentView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<CommentController> commentControllerProvider,
      Provider<UserController> userControllerProvider) {
    return new CommentView_Factory(jsonTransformerProvider, commentControllerProvider, userControllerProvider);
  }

  public static CommentView newInstance() {
    return new CommentView();
  }
}
