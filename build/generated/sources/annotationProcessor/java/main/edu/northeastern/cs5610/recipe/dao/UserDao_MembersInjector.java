package edu.northeastern.cs5610.recipe.dao;

import com.mongodb.client.MongoCollection;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class UserDao_MembersInjector implements MembersInjector<UserDao> {
  private final Provider<MongoCollection<User>> userCollectionProvider;

  public UserDao_MembersInjector(Provider<MongoCollection<User>> userCollectionProvider) {
    this.userCollectionProvider = userCollectionProvider;
  }

  public static MembersInjector<UserDao> create(
      Provider<MongoCollection<User>> userCollectionProvider) {
    return new UserDao_MembersInjector(userCollectionProvider);}

  @Override
  public void injectMembers(UserDao instance) {
    injectUserCollection(instance, userCollectionProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.dao.UserDao.userCollection")
  public static void injectUserCollection(UserDao instance, MongoCollection<User> userCollection) {
    instance.userCollection = userCollection;
  }
}
