package controllers;

import models.User;
import play.data.validation.Valid;
import play.mvc.Controller;


public class Application extends Controller {

  public static void register() {
    User user = Security.getConnectedUser();
    if (user != null) {
      Users.profile();
    } else {
      user = new User();
      render(user);
    }
  }

  public static void createProfile(@Valid User user) {
    if(validation.hasErrors()) {
      params.flash(); // add http parameters to the flash scope
      validation.keep(); // keep the errors for the next request
      register();
    }
    user.save();
    session.put("username", user.email);
    Users.profile();
  }

}