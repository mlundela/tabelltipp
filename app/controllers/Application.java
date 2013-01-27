package controllers;

import models.Bet;
import models.User;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Application extends Controller {

  public static void index() {
    renderText("Hello world");
  }

  public static void newBet(){
    Bet bet = new Bet();
    bet.init();
    render(bet);
  }


  public static void createBet(@Valid Bet bet) {
    User user = User.find("email = ?", bet.user.email).first();
    if (user != null) {
      bet.user = user;
    }
    bet.validateAndSave();
    newBet();
  }

}