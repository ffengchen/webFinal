package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class CommentDao_MembersInjector implements MembersInjector<CommentDao> {
  private final Provider<MongoCollection<Comment>> commentCollectionProvider;

  public CommentDao_MembersInjector(Provider<MongoCollection<Comment>> commentCollectionProvider) {
    this.commentCollectionProvider = commentCollectionProvider;
  }

  public static MembersInjector<CommentDao> create(
      Provider<MongoCollection<Comment>> commentCollectionProvider) {
    return new CommentDao_MembersInjector(commentCollectionProvider);}

  @Override
  public void injectMembers(CommentDao instance) {
    injectCommentCollection(instance, commentCollectionProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.dao.CommentDao.commentCollection")
  public static void injectCommentCollection(CommentDao instance,
      MongoCollection<Comment> commentCollection) {
    instance.commentCollection = commentCollection;
  }
}
