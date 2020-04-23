package edu.northeastern.cs5610.recipe.controller;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ControllerModule_ProvideCommentControllerFactory implements Factory<Controller> {
  private final ControllerModule module;

  private final Provider<CommentController> commentControllerProvider;

  public ControllerModule_ProvideCommentControllerFactory(ControllerModule module,
      Provider<CommentController> commentControllerProvider) {
    this.module = module;
    this.commentControllerProvider = commentControllerProvider;
  }

  @Override
  public Controller get() {
    return provideCommentController(module, commentControllerProvider.get());
  }

  public static ControllerModule_ProvideCommentControllerFactory create(ControllerModule module,
      Provider<CommentController> commentControllerProvider) {
    return new ControllerModule_ProvideCommentControllerFactory(module, commentControllerProvider);
  }

  public static Controller provideCommentController(ControllerModule instance,
      CommentController commentController) {
    return Preconditions.checkNotNull(instance.provideCommentController(commentController), "Cannot return null from a non-@Nullable @Provides method");
  }
}
