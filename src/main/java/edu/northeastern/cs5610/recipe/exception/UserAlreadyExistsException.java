package edu.northeastern.cs5610.recipe.exception;

/**
 * The type User already exists exception.
 */
public class UserAlreadyExistsException extends Exception {

  /**
   * Instantiates a new User already exists exception.
   *
   * @param message the message
   */
  public UserAlreadyExistsException(String message) {
    super(message);
  }
}
