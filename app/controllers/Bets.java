package controllers;

import models.Bet;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Bets extends Controller {

  public static void create() {
    Bet bet = Bet.find("user = ? order by id desc", Security.getConnectedUser()).first();
    if (bet == null) {
      bet = new Bet();
      bet.randomize();
    }
    render(bet);
  }

  public static void save(Bet bet) {
    bet.user = Security.getConnectedUser();
    bet.validateAndSave();
    Users.profile();
  }
}