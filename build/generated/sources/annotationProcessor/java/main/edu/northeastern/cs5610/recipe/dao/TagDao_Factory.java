package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
import edu.northeastern.cs5610.recipe.model.Tag;
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
public final class TagDao_Factory implements Factory<TagDao> {
  private final Provider<MongoCollection<Tag>> tagCollectionProvider;

  public TagDao_Factory(Provider<MongoCollection<Tag>> tagCollectionProvider) {
    this.tagCollectionProvider = tagCollectionProvider;
  }

  @Override
  public TagDao get() {
    TagDao instance = newInstance();
    TagDao_MembersInjector.injectTagCollection(instance, tagCollectionProvider.get());
    return instance;
  }

  public static TagDao_Factory create(Provider<MongoCollection<Tag>> tagCollectionProvider) {
    return new TagDao_Factory(tagCollectionProvider);
  }

  public static TagDao newInstance() {
    return new TagDao();
  }
}
