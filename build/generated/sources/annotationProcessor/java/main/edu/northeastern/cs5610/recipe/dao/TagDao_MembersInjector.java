package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class TagDao_MembersInjector implements MembersInjector<TagDao> {
  private final Provider<MongoCollection<Tag>> tagCollectionProvider;

  public TagDao_MembersInjector(Provider<MongoCollection<Tag>> tagCollectionProvider) {
    this.tagCollectionProvider = tagCollectionProvider;
  }

  public static MembersInjector<TagDao> create(
      Provider<MongoCollection<Tag>> tagCollectionProvider) {
    return new TagDao_MembersInjector(tagCollectionProvider);}

  @Override
  public void injectMembers(TagDao instance) {
    injectTagCollection(instance, tagCollectionProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.dao.TagDao.tagCollection")
  public static void injectTagCollection(TagDao instance, MongoCollection<Tag> tagCollection) {
    instance.tagCollection = tagCollection;
  }
}
