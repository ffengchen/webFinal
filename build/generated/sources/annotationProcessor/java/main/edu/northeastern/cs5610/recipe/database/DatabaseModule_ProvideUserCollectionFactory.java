package edu.northeastern.cs5610.recipe.database;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import edu.northeastern.cs5610.recipe.model.User;
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
public final class DatabaseModule_ProvideUserCollectionFactory implements Factory<MongoCollection<User>> {
  private final DatabaseModule module;

  private final Provider<Database> dbProvider;

  public DatabaseModule_ProvideUserCollectionFactory(DatabaseModule module,
      Provider<Database> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public MongoCollection<User> get() {
    return provideUserCollection(module, dbProvider.get());
  }

  public static DatabaseModule_ProvideUserCollectionFactory create(DatabaseModule module,
      Provider<Database> dbProvider) {
    return new DatabaseModule_ProvideUserCollectionFactory(module, dbProvider);
  }

  public static MongoCollection<User> provideUserCollection(DatabaseModule instance, Database db) {
    return Preconditions.checkNotNull(instance.provideUserCollection(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
