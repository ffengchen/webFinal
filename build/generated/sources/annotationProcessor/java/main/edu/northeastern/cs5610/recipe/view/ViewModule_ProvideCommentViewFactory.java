package edu.northeastern.cs5610.recipe.view;

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
public final class ViewModule_ProvideCommentViewFactory implements Factory<View> {
  private final ViewModule module;

  private final Provider<CommentView> commentViewProvider;

  public ViewModule_ProvideCommentViewFactory(ViewModule module,
      Provider<CommentView> commentViewProvider) {
    this.module = module;
    this.commentViewProvider = commentViewProvider;
  }

  @Override
  public View get() {
    return provideCommentView(module, commentViewProvider.get());
  }

  public static ViewModule_ProvideCommentViewFactory create(ViewModule module,
      Provider<CommentView> commentViewProvider) {
    return new ViewModule_ProvideCommentViewFactory(module, commentViewProvider);
  }

  public static View provideCommentView(ViewModule instance, CommentView commentView) {
    return Preconditions.checkNotNull(instance.provideCommentView(commentView), "Cannot return null from a non-@Nullable @Provides method");
  }
}
