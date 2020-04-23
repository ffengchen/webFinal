package edu.northeastern.cs5610.recipe.database;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideTagCollectionFactory implements Factory<MongoCollection<Tag>> {
  private final DatabaseModule module;

  private final Provider<Database> dbProvider;

  public DatabaseModule_ProvideTagCollectionFactory(DatabaseModule module,
      Provider<Database> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public MongoCollection<Tag> get() {
    return provideTagCollection(module, dbProvider.get());
  }

  public static DatabaseModule_ProvideTagCollectionFactory create(DatabaseModule module,
      Provider<Database> dbProvider) {
    return new DatabaseModule_ProvideTagCollectionFactory(module, dbProvider);
  }

  public static MongoCollection<Tag> provideTagCollection(DatabaseModule instance, Database db) {
    return Preconditions.checkNotNull(instance.provideTagCollection(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
