package edu.northeastern.cs5610.recipe.util;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Map;

/**
 * The type Render util.
 */
public class RenderUtil {

  /**
   * Render template string.
   *
   * @param template the template
   * @param model the model
   * @return the string
   */
  public static String renderTemplate(String template, Map<String, Object> model) {
    return new VelocityTemplateEngine().render(new ModelAndView(model, template));
  }
}
