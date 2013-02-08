package controllers;

import models.User;

public class Security extends Secure.Security {

  static boolean authenticate(String username, String password) {
    User user = User.find("byEmail", username).first();
    if (user == null) {
      flash("login", "Finner ikke bruker");
      return false;
    } else if (!user.password.equals(password)) {
      flash("login", "Du oppga feil passord");
      return false;
    }
    return true;
  }

  public static User getConnectedUser() {
    return User.find("byEmail", Security.connected()).first();
  }

}