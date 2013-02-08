package controllers;

import models.User;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Users extends Controller {

  public static void profile() {
    User user = Security.getConnectedUser();
    render(user);
  }

}