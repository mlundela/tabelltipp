package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Bruker extends Model {

  public String navn;
  public String epost;

  public Bruker(String navn) {
    this.navn = navn;
  }

  public List<Lag> getTips() {
    List<Lag> out = new ArrayList<Lag>();
    List<TabellTips> tips = TabellTips.find("bruker = ? order by plassering", this).fetch();
    for (TabellTips tip : tips) {
      out.add(tip.lag);
    }
    return out;
  }
}
