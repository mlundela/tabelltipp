package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Users extends Controller {

  public static void profile() {
    User user = User.find("byEmail", Security.connected()).first();
    render(user);
  }

}