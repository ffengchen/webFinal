package edu.northeastern.cs5610.recipe.dao;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;


@Module
public class DaoModule {

  /**
   * Provide user dao dao.
   *
   * @return the dao
   */
  @Provides
  @IntoSet
  public Dao provideUserDao() {
    return new UserDao();
  }

  ;
}
