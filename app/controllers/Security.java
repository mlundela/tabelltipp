package controllers;

import models.User;
import play.Logger;

public class Security extends Secure.Security {

  static boolean authenticate(String username, String password) {
    if (password.length() < 4) {
      flash("login", "Passordet må bestå av minst 4 tegn");
      return false;
    }
    User user = User.find("byEmail", username).first();
    if (user == null) {
      Logger.info("Ny bruker: " + username);
      User usr = new User();
      usr.name = username.split("@")[0];
      usr.email = username;
      usr.password = password;
      usr.save();
      return true;
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