package controllers;

import models.Bet;
import models.User;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Bets extends Controller {

  public static void create() {
    models.Bet bet = new models.Bet();
    bet.init();
    render(bet);
  }

  public static void save(@Valid models.Bet bet) {
    User user = User.find("email = ?", bet.user.email).first();
    if (user != null) {
      bet.user = user;
    }
    bet.validateAndSave();
    show(bet.id);
  }

  public static void show(Long id) {
    Bet bet = Bet.findById(id);
    render(bet);
  }
}