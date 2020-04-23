package edu.northeastern.cs5610.recipe.controller;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ControllerModule_ProvideUserControllerFactory implements Factory<Controller> {
  private final ControllerModule module;

  private final Provider<UserController> userControllerProvider;

  public ControllerModule_ProvideUserControllerFactory(ControllerModule module,
      Provider<UserController> userControllerProvider) {
    this.module = module;
    this.userControllerProvider = userControllerProvider;
  }

  @Override
  public Controller get() {
    return provideUserController(module, userControllerProvider.get());
  }

  public static ControllerModule_ProvideUserControllerFactory create(ControllerModule module,
      Provider<UserController> userControllerProvider) {
    return new ControllerModule_ProvideUserControllerFactory(module, userControllerProvider);
  }

  public static Controller provideUserController(ControllerModule instance,
      UserController userController) {
    return Preconditions.checkNotNull(instance.provideUserController(userController), "Cannot return null from a non-@Nullable @Provides method");
  }
}
