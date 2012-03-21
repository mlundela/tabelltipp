package controllers;

import models.Bruker;
import models.Lag;
import play.mvc.Controller;

import java.util.List;

public class Application extends Controller {

  public static void index() {
    List<Lag> lag = Lag.findAll();
    Bruker bruker = new Bruker();
    render(lag, bruker);
  }

  public static void visBruker(Long id) {
    Bruker bruker = Bruker.findById(id);
    render(bruker);
  }

  public static void tipp(Bruker bruker) {
    bruker.save();
    visBruker(bruker.id);
  }

}