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
    bet.save();
    newBet();
  }

  /*
  public static void index() {
    Long id = Bruker.getResultatliste().get(0).id;
    visBruker(id);
  }

  public static void visBruker(Long id) {
    List<Bruker> brukere = Bruker.getResultatliste();
    List<Lag> tabell = Lag.getTabell();
    Bruker bruker = Bruker.findById(id);
    render(bruker, brukere, tabell);
  }

  public static void tabell() {
    List<Lag> tabell = Lag.getTabell();
    render(tabell);
  }

  public static void lagreTabell(List<Lag> tabell) {
    for (Lag lag : tabell) {
      Lag l = Lag.findById(lag.id);
      l.poeng = lag.poeng;
      l.save();
    }
    tabell();
  }

  public static void brukere() {
    List<Bruker> brukere = Bruker.getResultatliste();
    render(brukere);
  }

  public static void lagreTips(String name, List<Long> tips) {

    Bruker bruker = new Bruker(name);
    bruker.save();

    int plassering = 1;
    for (Long lagId : tips) {
      Logger.info("Bruker: %s, lagId: %s, posisjon: %s", bruker.name, lagId, plassering);
      Tips t = new Tips(bruker, (Lag) Lag.findById(lagId), plassering++);
      t.save();
    }

    visBruker(bruker.id);
  }
  */

}