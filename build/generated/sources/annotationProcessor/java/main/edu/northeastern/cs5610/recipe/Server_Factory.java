package edu.northeastern.cs5610.recipe;

import com.mongodb.client.MongoCollection;
import dagger.internal.Factory;
import edu.northeastern.cs5610.recipe.controller.Controller;
import edu.northeastern.cs5610.recipe.dao.Dao;
import edu.northeastern.cs5610.recipe.model.Comment;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.Tag;
import edu.northeastern.cs5610.recipe.model.User;
import edu.northeastern.cs5610.recipe.view.View;
import java.util.Set;
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
public final class Server_Factory implements Factory<Server> {
  private final Provider<Set<Controller>> controllersProvider;

  private final Provider<Set<View>> viewsProvider;

  private final Provider<Set<Dao>> daosProvider;

  private final Provider<MongoCollection<Recipe>> recipeCollectionProvider;

  private final Provider<MongoCollection<User>> userCollectionProvider;

  private final Provider<MongoCollection<Comment>> commentCollectionProvider;

  private final Provider<MongoCollection<Tag>> tagCollectionProvider;

  public Server_Factory(Provider<Set<Controller>> controllersProvider,
      Provider<Set<View>> viewsProvider, Provider<Set<Dao>> daosProvider,
      Provider<MongoCollection<Recipe>> recipeCollectionProvider,
      Provider<MongoCollection<User>> userCollectionProvider,
      Provider<MongoCollection<Comment>> commentCollectionProvider,
      Provider<MongoCollection<Tag>> tagCollectionProvider) {
    this.controllersProvider = controllersProvider;
    this.viewsProvider = viewsProvider;
    this.daosProvider = daosProvider;
    this.recipeCollectionProvider = recipeCollectionProvider;
    this.userCollectionProvider = userCollectionProvider;
    this.commentCollectionProvider = commentCollectionProvider;
    this.tagCollectionProvider = tagCollectionProvider;
  }

  @Override
  public Server get() {
    Server instance = newInstance();
    Server_MembersInjector.injectControllers(instance, controllersProvider.get());
    Server_MembersInjector.injectViews(instance, viewsProvider.get());
    Server_MembersInjector.injectDaos(instance, daosProvider.get());
    Server_MembersInjector.injectRecipeCollection(instance, recipeCollectionProvider.get());
    Server_MembersInjector.injectUserCollection(instance, userCollectionProvider.get());
    Server_MembersInjector.injectCommentCollection(instance, commentCollectionProvider.get());
    Server_MembersInjector.injectTagCollection(instance, tagCollectionProvider.get());
    return instance;
  }

  public static Server_Factory create(Provider<Set<Controller>> controllersProvider,
      Provider<Set<View>> viewsProvider, Provider<Set<Dao>> daosProvider,
      Provider<MongoCollection<Recipe>> recipeCollectionProvider,
      Provider<MongoCollection<User>> userCollectionProvider,
      Provider<MongoCollection<Comment>> commentCollectionProvider,
      Provider<MongoCollection<Tag>> tagCollectionProvider) {
    return new Server_Factory(controllersProvider, viewsProvider, daosProvider, recipeCollectionProvider, userCollectionProvider, commentCollectionProvider, tagCollectionProvider);
  }

  public static Server newInstance() {
    return new Server();
  }
}
