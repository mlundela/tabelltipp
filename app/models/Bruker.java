package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Entity
public class Bruker extends Model implements Comparable<Bruker> {

  public String navn;
  public String epost;

  public Bruker(String navn) {
    this.navn = navn;
  }

  public List<Lag> getTabellTips() {
    List<Lag> out = new ArrayList<Lag>();
    for (TabellTips tip : getTips()) {
      out.add(tip.lag);
    }
    return out;
  }

  public List<TabellTips> getTips() {
    return TabellTips.find("bruker = ? order by plassering", this).fetch();
  }

  public static List<Lag> getTabell() {
    return Lag.find("order by poeng desc").fetch();
  }

  public int getScore() {
    List<Lag> tabell = getTabell();
    List<TabellTips> tips = getTips();
    int score = 100;
    for (TabellTips tip : tips) {
      Lag fasit = tabell.get(tip.plassering - 1);
      score -= Math.abs(fasit.poeng - tip.lag.poeng);
    }
    return score;
  }

  public static List<Bruker> getResultatliste() {
    List<Bruker> brukere = Bruker.all().fetch();
    Collections.sort(brukere);
    return brukere;
  }

  public int compareTo(Bruker bruker) {
    return bruker.getScore() - this.getScore();
  }
}
