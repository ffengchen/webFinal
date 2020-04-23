package edu.northeastern.cs5610.recipe.util;

import edu.northeastern.cs5610.recipe.model.User;
import spark.Request;

/**
 * The type Login util.
 */
public class LoginUtil {

  /**
   * Add authenticated user.
   *
   * @param request the request
   * @param u the u
   */
  public static void addAuthenticatedUser(Request request, User u) {
    request.session().attribute("user", u);
  }

  /**
   * Remove authenticated user.
   *
   * @param request the request
   */
  public static void removeAuthenticatedUser(Request request) {
    request.session().removeAttribute("user");
  }

  /**
   * Gets authenticated user.
   *
   * @param request the request
   * @return the authenticated user
   */
  public static User getAuthenticatedUser(Request request) {
    return request.session().attribute("user");
  }
}
