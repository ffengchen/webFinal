package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
import edu.northeastern.cs5610.recipe.model.Comment;
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
public final class CommentDao_Factory implements Factory<CommentDao> {
  private final Provider<MongoCollection<Comment>> commentCollectionProvider;

  public CommentDao_Factory(Provider<MongoCollection<Comment>> commentCollectionProvider) {
    this.commentCollectionProvider = commentCollectionProvider;
  }

  @Override
  public CommentDao get() {
    CommentDao instance = newInstance();
    CommentDao_MembersInjector.injectCommentCollection(instance, commentCollectionProvider.get());
    return instance;
  }

  public static CommentDao_Factory create(
      Provider<MongoCollection<Comment>> commentCollectionProvider) {
    return new CommentDao_Factory(commentCollectionProvider);
  }

  public static CommentDao newInstance() {
    return new CommentDao();
  }
}
