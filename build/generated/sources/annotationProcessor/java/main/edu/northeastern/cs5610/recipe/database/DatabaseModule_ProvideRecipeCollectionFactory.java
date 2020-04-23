package edu.northeastern.cs5610.recipe.database;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import edu.northeastern.cs5610.recipe.model.Recipe;
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
public final class DatabaseModule_ProvideRecipeCollectionFactory implements Factory<MongoCollection<Recipe>> {
  private final DatabaseModule module;

  private final Provider<Database> dbProvider;

  public DatabaseModule_ProvideRecipeCollectionFactory(DatabaseModule module,
      Provider<Database> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public MongoCollection<Recipe> get() {
    return provideRecipeCollection(module, dbProvider.get());
  }

  public static DatabaseModule_ProvideRecipeCollectionFactory create(DatabaseModule module,
      Provider<Database> dbProvider) {
    return new DatabaseModule_ProvideRecipeCollectionFactory(module, dbProvider);
  }

  public static MongoCollection<Recipe> provideRecipeCollection(DatabaseModule instance,
      Database db) {
    return Preconditions.checkNotNull(instance.provideRecipeCollection(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
