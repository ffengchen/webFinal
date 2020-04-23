package edu.northeastern.cs5610.recipe;

import com.mongodb.client.MongoCollection;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import edu.northeastern.cs5610.recipe.controller.CommentController;
import edu.northeastern.cs5610.recipe.controller.CommentController_Factory;
import edu.northeastern.cs5610.recipe.controller.Controller;
import edu.northeastern.cs5610.recipe.controller.ControllerModule;
import edu.northeastern.cs5610.recipe.controller.ControllerModule_ProvideCommentControllerFactory;
import edu.northeastern.cs5610.recipe.controller.ControllerModule_ProvideRecipeControllerFactory;
import edu.northeastern.cs5610.recipe.controller.ControllerModule_ProvideUserControllerFactory;
import edu.northeastern.cs5610.recipe.controller.RecipeController;
import edu.northeastern.cs5610.recipe.controller.RecipeController_Factory;
import edu.northeastern.cs5610.recipe.controller.TagController;
import edu.northeastern.cs5610.recipe.controller.TagController_Factory;
import edu.northeastern.cs5610.recipe.controller.UserController;
import edu.northeastern.cs5610.recipe.controller.UserController_Factory;
import edu.northeastern.cs5610.recipe.dao.CommentDao;
import edu.northeastern.cs5610.recipe.dao.CommentDao_Factory;
import edu.northeastern.cs5610.recipe.dao.Dao;
import edu.northeastern.cs5610.recipe.dao.DaoModule;
import edu.northeastern.cs5610.recipe.dao.DaoModule_ProvideUserDaoFactory;
import edu.northeastern.cs5610.recipe.dao.RecipeDao;
import edu.northeastern.cs5610.recipe.dao.RecipeDao_Factory;
import edu.northeastern.cs5610.recipe.dao.TagDao;
import edu.northeastern.cs5610.recipe.dao.TagDao_Factory;
import edu.northeastern.cs5610.recipe.dao.UserDao;
import edu.northeastern.cs5610.recipe.dao.UserDao_Factory;
import edu.northeastern.cs5610.recipe.database.Database;
import edu.northeastern.cs5610.recipe.database.DatabaseModule;
import edu.northeastern.cs5610.recipe.database.DatabaseModule_ProvideCommentCollectionFactory;
import edu.northeastern.cs5610.recipe.database.DatabaseModule_ProvideRecipeCollectionFactory;
import edu.northeastern.cs5610.recipe.database.DatabaseModule_ProvideTagCollectionFactory;
import edu.northeastern.cs5610.recipe.database.DatabaseModule_ProvideUserCollectionFactory;
import edu.northeastern.cs5610.recipe.database.Database_Factory;
import edu.northeastern.cs5610.recipe.model.Comment;
import edu.northeastern.cs5610.recipe.model.Recipe;
import edu.northeastern.cs5610.recipe.model.Tag;
import edu.northeastern.cs5610.recipe.model.User;
import edu.northeastern.cs5610.recipe.view.CommentView;
import edu.northeastern.cs5610.recipe.view.CommentView_Factory;
import edu.northeastern.cs5610.recipe.view.RecipeView;
import edu.northeastern.cs5610.recipe.view.RecipeView_Factory;
import edu.northeastern.cs5610.recipe.view.TagView;
import edu.northeastern.cs5610.recipe.view.TagView_Factory;
import edu.northeastern.cs5610.recipe.view.UserView;
import edu.northeastern.cs5610.recipe.view.UserView_Factory;
import edu.northeastern.cs5610.recipe.view.View;
import edu.northeastern.cs5610.recipe.view.ViewModule;
import edu.northeastern.cs5610.recipe.view.ViewModule_ProvideCommentViewFactory;
import edu.northeastern.cs5610.recipe.view.ViewModule_ProvideRecipeViewFactory;
import edu.northeastern.cs5610.recipe.view.ViewModule_ProvideTagViewFactory;
import edu.northeastern.cs5610.recipe.view.ViewModule_ProvideUserViewFactory;
import java.util.Collections;
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
final class DaggerServerComponent implements ServerComponent {
  private final ControllerModule controllerModule;

  private final ViewModule viewModule;

  private final DaoModule daoModule;

  private final DatabaseModule databaseModule;

  private Provider<Database> databaseProvider;

  private Provider<MongoCollection<User>> provideUserCollectionProvider;

  private Provider<UserDao> userDaoProvider;

  private Provider<MongoCollection<Recipe>> provideRecipeCollectionProvider;

  private Provider<RecipeDao> recipeDaoProvider;

  private Provider<RecipeController> recipeControllerProvider;

  private Provider<UserController> userControllerProvider;

  private Provider<MongoCollection<Comment>> provideCommentCollectionProvider;

  private Provider<CommentDao> commentDaoProvider;

  private Provider<CommentController> commentControllerProvider;

  private Provider<MongoCollection<Tag>> provideTagCollectionProvider;

  private Provider<TagDao> tagDaoProvider;

  private Provider<TagController> tagControllerProvider;

  private Provider<RecipeView> recipeViewProvider;

  private Provider<UserView> userViewProvider;

  private Provider<TagView> tagViewProvider;

  private Provider<CommentView> commentViewProvider;

  private DaggerServerComponent(ControllerModule controllerModuleParam, ViewModule viewModuleParam,
      DaoModule daoModuleParam, DatabaseModule databaseModuleParam) {
    this.controllerModule = controllerModuleParam;
    this.viewModule = viewModuleParam;
    this.daoModule = daoModuleParam;
    this.databaseModule = databaseModuleParam;
    initialize(controllerModuleParam, viewModuleParam, daoModuleParam, databaseModuleParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServerComponent create() {
    return new Builder().build();
  }

  private Controller getProvideRecipeController() {
    return ControllerModule_ProvideRecipeControllerFactory.provideRecipeController(controllerModule, recipeControllerProvider.get());}

  private Controller getProvideUserController() {
    return ControllerModule_ProvideUserControllerFactory.provideUserController(controllerModule, userControllerProvider.get());}

  private Controller getProvideCommentController() {
    return ControllerModule_ProvideCommentControllerFactory.provideCommentController(controllerModule, commentControllerProvider.get());}

  private Set<Controller> getSetOfController() {
    return SetBuilder.<Controller>newSetBuilder(3).add(getProvideRecipeController()).add(getProvideUserController()).add(getProvideCommentController()).build();}

  private View getProvideRecipeView() {
    return ViewModule_ProvideRecipeViewFactory.provideRecipeView(viewModule, recipeViewProvider.get());}

  private View getProvideUserView() {
    return ViewModule_ProvideUserViewFactory.provideUserView(viewModule, userViewProvider.get());}

  private View getProvideTagView() {
    return ViewModule_ProvideTagViewFactory.provideTagView(viewModule, tagViewProvider.get());}

  private View getProvideCommentView() {
    return ViewModule_ProvideCommentViewFactory.provideCommentView(viewModule, commentViewProvider.get());}

  private Set<View> getSetOfView() {
    return SetBuilder.<View>newSetBuilder(4).add(getProvideRecipeView()).add(getProvideUserView()).add(getProvideTagView()).add(getProvideCommentView()).build();}

  private Set<Dao> getSetOfDao() {
    return Collections.<Dao>singleton(DaoModule_ProvideUserDaoFactory.provideUserDao(daoModule));}

  private MongoCollection<Recipe> getMongoCollectionOfRecipe() {
    return DatabaseModule_ProvideRecipeCollectionFactory.provideRecipeCollection(databaseModule, databaseProvider.get());}

  private MongoCollection<User> getMongoCollectionOfUser() {
    return DatabaseModule_ProvideUserCollectionFactory.provideUserCollection(databaseModule, databaseProvider.get());}

  private MongoCollection<Comment> getMongoCollectionOfComment() {
    return DatabaseModule_ProvideCommentCollectionFactory.provideCommentCollection(databaseModule, databaseProvider.get());}

  private MongoCollection<Tag> getMongoCollectionOfTag() {
    return DatabaseModule_ProvideTagCollectionFactory.provideTagCollection(databaseModule, databaseProvider.get());}

  @SuppressWarnings("unchecked")
  private void initialize(final ControllerModule controllerModuleParam,
      final ViewModule viewModuleParam, final DaoModule daoModuleParam,
      final DatabaseModule databaseModuleParam) {
    this.databaseProvider = DoubleCheck.provider(Database_Factory.create());
    this.provideUserCollectionProvider = DatabaseModule_ProvideUserCollectionFactory.create(databaseModuleParam, databaseProvider);
    this.userDaoProvider = DoubleCheck.provider(UserDao_Factory.create(provideUserCollectionProvider));
    this.provideRecipeCollectionProvider = DatabaseModule_ProvideRecipeCollectionFactory.create(databaseModuleParam, databaseProvider);
    this.recipeDaoProvider = DoubleCheck.provider(RecipeDao_Factory.create(provideRecipeCollectionProvider));
    this.recipeControllerProvider = DoubleCheck.provider(RecipeController_Factory.create(userDaoProvider, recipeDaoProvider));
    this.userControllerProvider = DoubleCheck.provider(UserController_Factory.create(userDaoProvider, recipeDaoProvider));
    this.provideCommentCollectionProvider = DatabaseModule_ProvideCommentCollectionFactory.create(databaseModuleParam, databaseProvider);
    this.commentDaoProvider = DoubleCheck.provider(CommentDao_Factory.create(provideCommentCollectionProvider));
    this.commentControllerProvider = DoubleCheck.provider(CommentController_Factory.create(commentDaoProvider, recipeDaoProvider));
    this.provideTagCollectionProvider = DatabaseModule_ProvideTagCollectionFactory.create(databaseModuleParam, databaseProvider);
    this.tagDaoProvider = DoubleCheck.provider(TagDao_Factory.create(provideTagCollectionProvider));
    this.tagControllerProvider = DoubleCheck.provider(TagController_Factory.create(tagDaoProvider, recipeDaoProvider));
    this.recipeViewProvider = DoubleCheck.provider(RecipeView_Factory.create(JsonTransformer_Factory.create(), recipeControllerProvider, tagControllerProvider, commentControllerProvider, userControllerProvider));
    this.userViewProvider = DoubleCheck.provider(UserView_Factory.create(JsonTransformer_Factory.create(), userControllerProvider, recipeControllerProvider, commentControllerProvider));
    this.tagViewProvider = DoubleCheck.provider(TagView_Factory.create(JsonTransformer_Factory.create(), tagControllerProvider, userControllerProvider, recipeControllerProvider));
    this.commentViewProvider = DoubleCheck.provider(CommentView_Factory.create(JsonTransformer_Factory.create(), commentControllerProvider, userControllerProvider));
  }

  @Override
  public Server server() {
    return injectServer(Server_Factory.newInstance());}

  private Server injectServer(Server instance) {
    Server_MembersInjector.injectControllers(instance, getSetOfController());
    Server_MembersInjector.injectViews(instance, getSetOfView());
    Server_MembersInjector.injectDaos(instance, getSetOfDao());
    Server_MembersInjector.injectRecipeCollection(instance, getMongoCollectionOfRecipe());
    Server_MembersInjector.injectUserCollection(instance, getMongoCollectionOfUser());
    Server_MembersInjector.injectCommentCollection(instance, getMongoCollectionOfComment());
    Server_MembersInjector.injectTagCollection(instance, getMongoCollectionOfTag());
    return instance;
  }

  static final class Builder {
    private ControllerModule controllerModule;

    private ViewModule viewModule;

    private DaoModule daoModule;

    private DatabaseModule databaseModule;

    private Builder() {
    }

    public Builder controllerModule(ControllerModule controllerModule) {
      this.controllerModule = Preconditions.checkNotNull(controllerModule);
      return this;
    }

    public Builder viewModule(ViewModule viewModule) {
      this.viewModule = Preconditions.checkNotNull(viewModule);
      return this;
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }

    public Builder databaseModule(DatabaseModule databaseModule) {
      this.databaseModule = Preconditions.checkNotNull(databaseModule);
      return this;
    }

    public ServerComponent build() {
      if (controllerModule == null) {
        this.controllerModule = new ControllerModule();
      }
      if (viewModule == null) {
        this.viewModule = new ViewModule();
      }
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      if (databaseModule == null) {
        this.databaseModule = new DatabaseModule();
      }
      return new DaggerServerComponent(controllerModule, viewModule, daoModule, databaseModule);
    }
  }
}
