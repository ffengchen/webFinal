package edu.northeastern.cs5610.recipe.view;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class CommentView_MembersInjector implements MembersInjector<CommentView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<CommentController> commentControllerProvider;

  private final Provider<UserController> userControllerProvider;

  public CommentView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<CommentController> commentControllerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.commentControllerProvider = commentControllerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  public static MembersInjector<CommentView> create(
      Provider<JsonTransformer> jsonTransformerProvider,
      Provider<CommentController> commentControllerProvider,
      Provider<UserController> userControllerProvider) {
    return new CommentView_MembersInjector(jsonTransformerProvider, commentControllerProvider, userControllerProvider);}

  @Override
  public void injectMembers(CommentView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectCommentController(instance, commentControllerProvider.get());
    injectUserController(instance, userControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.CommentView.jsonTransformer")
  public static void injectJsonTransformer(CommentView instance, JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.CommentView.commentController")
  public static void injectCommentController(CommentView instance,
      CommentController commentController) {
    instance.commentController = commentController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.view.CommentView.userController")
  public static void injectUserController(CommentView instance, UserController userController) {
    instance.userController = userController;
  }
}
