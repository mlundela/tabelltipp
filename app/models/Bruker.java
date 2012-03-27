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

  public List<TabellTips> getTips() {
    return TabellTips.find("bruker = ? order by plassering", this).fetch();
  }

  public int getScore() {
    List<Lag> tabell = Lag.getTabell();
    List<TabellTips> tips = getTips();
    int trekk = 0;
    for (TabellTips tip : tips) {
      Lag fasit = tabell.get(tip.plassering - 1);
      trekk += Math.abs(fasit.poeng - tip.lag.poeng);
    }
    return 100 - trekk / 2;
  }

  public List<LagPoeng> getTabellPoeng() {
    List<LagPoeng> out = new ArrayList<LagPoeng>();
    List<Lag> tabell = Lag.getTabell();
    List<TabellTips> tips = getTips();
    for (TabellTips tip : tips) {
      out.add(new LagPoeng(tabell.get(tip.plassering - 1), tip));
    }
    return out;
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
