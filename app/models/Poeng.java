package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Poeng extends Model {

  @ManyToOne
  public Runde runde;

  @ManyToOne
  public Lag lag;

  public int poeng;

}
