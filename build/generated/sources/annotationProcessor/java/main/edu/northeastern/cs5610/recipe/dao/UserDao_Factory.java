package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
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
public final class UserDao_Factory implements Factory<UserDao> {
  private final Provider<MongoCollection<User>> userCollectionProvider;

  public UserDao_Factory(Provider<MongoCollection<User>> userCollectionProvider) {
    this.userCollectionProvider = userCollectionProvider;
  }

  @Override
  public UserDao get() {
    UserDao instance = newInstance();
    UserDao_MembersInjector.injectUserCollection(instance, userCollectionProvider.get());
    return instance;
  }

  public static UserDao_Factory create(Provider<MongoCollection<User>> userCollectionProvider) {
    return new UserDao_Factory(userCollectionProvider);
  }

  public static UserDao newInstance() {
    return new UserDao();
  }
}
