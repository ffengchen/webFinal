package edu.northeastern.cs5610.recipe.database;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideCommentCollectionFactory implements Factory<MongoCollection<Comment>> {
  private final DatabaseModule module;

  private final Provider<Database> dbProvider;

  public DatabaseModule_ProvideCommentCollectionFactory(DatabaseModule module,
      Provider<Database> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public MongoCollection<Comment> get() {
    return provideCommentCollection(module, dbProvider.get());
  }

  public static DatabaseModule_ProvideCommentCollectionFactory create(DatabaseModule module,
      Provider<Database> dbProvider) {
    return new DatabaseModule_ProvideCommentCollectionFactory(module, dbProvider);
  }

  public static MongoCollection<Comment> provideCommentCollection(DatabaseModule instance,
      Database db) {
    return Preconditions.checkNotNull(instance.provideCommentCollection(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
