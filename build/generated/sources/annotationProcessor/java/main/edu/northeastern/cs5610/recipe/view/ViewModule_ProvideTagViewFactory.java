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
public final class ViewModule_ProvideTagViewFactory implements Factory<View> {
  private final ViewModule module;

  private final Provider<TagView> tagViewProvider;

  public ViewModule_ProvideTagViewFactory(ViewModule module, Provider<TagView> tagViewProvider) {
    this.module = module;
    this.tagViewProvider = tagViewProvider;
  }

  @Override
  public View get() {
    return provideTagView(module, tagViewProvider.get());
  }

  public static ViewModule_ProvideTagViewFactory create(ViewModule module,
      Provider<TagView> tagViewProvider) {
    return new ViewModule_ProvideTagViewFactory(module, tagViewProvider);
  }

  public static View provideTagView(ViewModule instance, TagView tagView) {
    return Preconditions.checkNotNull(instance.provideTagView(tagView), "Cannot return null from a non-@Nullable @Provides method");
  }
}
