package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Team extends Model {

  public String name;
  public Integer points = 0;

  public static List<Team> getTable() {
    return Team.find("order by points desc").fetch();
  }
}
