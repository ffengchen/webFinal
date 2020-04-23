package edu.northeastern.cs5610.recipe.dao;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaoModule_ProvideUserDaoFactory implements Factory<Dao> {
  private final DaoModule module;

  public DaoModule_ProvideUserDaoFactory(DaoModule module) {
    this.module = module;
  }

  @Override
  public Dao get() {
    return provideUserDao(module);
  }

  public static DaoModule_ProvideUserDaoFactory create(DaoModule module) {
    return new DaoModule_ProvideUserDaoFactory(module);
  }

  public static Dao provideUserDao(DaoModule instance) {
    return Preconditions.checkNotNull(instance.provideUserDao(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
