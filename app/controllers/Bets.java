package controllers;

import models.Bet;
import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Bets extends Controller {

  @Before
  static void before() {
    if (Secure.Security.isConnected()) {
      renderArgs.put("connectedUser", getConnectedUser());
    }
  }

  private static User getConnectedUser() {
    return User.find("email = ?", Secure.Security.connected()).first();
  }

  public static void create() {
    Bet bet = Bet.find("user = ? order by id desc", getConnectedUser()).first();
    if (bet == null) {
      bet = new Bet();
      bet.init();
    }
    render(bet);
  }

  public static void save(Bet bet) {
    bet.user = getConnectedUser();
    bet.validateAndSave();
    create();
  }

  public static void show(Long id) {
    Bet bet = Bet.findById(id);
    render(bet);
  }
}