package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Lag extends Model {

  public String navn;
  public int poeng;
  public int plassering;

  public static List<Lag> getTabell() {
    return Lag.find("order by plassering asc").fetch();
  }
}
