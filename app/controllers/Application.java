package controllers;

import models.Bruker;
import models.Lag;
import models.TabellTips;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Application extends Controller {

  public static void index() {
    List<Bruker> brukere = Bruker.getResultatliste();
    List<Lag> tabell = Lag.getTabell();
    render(brukere, tabell);
  }

  public static void visBruker(Long id) {
    List<Bruker> brukere = Bruker.getResultatliste();
    List<Lag> tabell = Lag.getTabell();
    Bruker bruker = Bruker.findById(id);
    render(bruker, brukere, tabell);
  }

  public static void brukere() {
    List<Bruker> brukere = Bruker.getResultatliste();
    render(brukere);
  }

  public static void lagreTips(String navn, List<Long> tips) {

    Bruker bruker = new Bruker(navn);
    bruker.save();

    int plassering = 1;
    for (Long lagId : tips) {
      Logger.info("Bruker: %s, lagId: %s, posisjon: %s", bruker.navn, lagId, plassering);
      TabellTips t = new TabellTips(bruker, (Lag) Lag.findById(lagId), plassering++);
      t.save();
    }

    visBruker(bruker.id);
  }

}