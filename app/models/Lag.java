package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Lag extends Model {

  public String navn;

//  public static List<Lag> getTabell() {
//    return Lag.find("order by plassering asc").fetch();
//  }
}
