package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Team extends Model {

  public String name;

//  public static List<Lag> getTabell() {
//    return Lag.find("order by plassering asc").fetch();
//  }
}
