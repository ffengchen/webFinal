package edu.northeastern.cs5610.recipe;

import com.mongodb.client.MongoCollection;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class Server_MembersInjector implements MembersInjector<Server> {
  private final Provider<Set<Controller>> controllersProvider;

  private final Provider<Set<View>> viewsProvider;

  private final Provider<Set<Dao>> daosProvider;

  private final Provider<MongoCollection<Recipe>> recipeCollectionProvider;

  private final Provider<MongoCollection<User>> userCollectionProvider;

  private final Provider<MongoCollection<Comment>> commentCollectionProvider;

  private final Provider<MongoCollection<Tag>> tagCollectionProvider;

  public Server_MembersInjector(Provider<Set<Controller>> controllersProvider,
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

  public static MembersInjector<Server> create(Provider<Set<Controller>> controllersProvider,
      Provider<Set<View>> viewsProvider, Provider<Set<Dao>> daosProvider,
      Provider<MongoCollection<Recipe>> recipeCollectionProvider,
      Provider<MongoCollection<User>> userCollectionProvider,
      Provider<MongoCollection<Comment>> commentCollectionProvider,
      Provider<MongoCollection<Tag>> tagCollectionProvider) {
    return new Server_MembersInjector(controllersProvider, viewsProvider, daosProvider, recipeCollectionProvider, userCollectionProvider, commentCollectionProvider, tagCollectionProvider);}

  @Override
  public void injectMembers(Server instance) {
    injectControllers(instance, controllersProvider.get());
    injectViews(instance, viewsProvider.get());
    injectDaos(instance, daosProvider.get());
    injectRecipeCollection(instance, recipeCollectionProvider.get());
    injectUserCollection(instance, userCollectionProvider.get());
    injectCommentCollection(instance, commentCollectionProvider.get());
    injectTagCollection(instance, tagCollectionProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.Server.controllers")
  public static void injectControllers(Server instance, Set<Controller> controllers) {
    instance.controllers = controllers;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.Server.views")
  public static void injectViews(Server instance, Set<View> views) {
    instance.views = views;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.Server.daos")
  public static void injectDaos(Server instance, Set<Dao> daos) {
    instance.daos = daos;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.Server.recipeCollection")
  public static void injectRecipeCollection(Server instance,
      MongoCollection<Recipe> recipeCollection) {
    instance.recipeCollection = recipeCollection;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.Server.userCollection")
  public static void injectUserCollection(Server instance, MongoCollection<User> userCollection) {
    instance.userCollection = userCollection;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.Server.commentCollection")
  public static void injectCommentCollection(Server instance,
      MongoCollection<Comment> commentCollection) {
    instance.commentCollection = commentCollection;
  }

  @InjectedFieldSignature("edu.northeastern.cs5610.recipe.Server.tagCollection")
  public static void injectTagCollection(Server instance, MongoCollection<Tag> tagCollection) {
    instance.tagCollection = tagCollection;
  }
}
