package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class TabellTips extends Model {

  @ManyToOne
  public Bruker bruker;

  @ManyToOne
  public Lag lag;

  public int plassering;

  public TabellTips(Bruker bruker, Lag lag, int plassering) {
    this.bruker = bruker;
    this.lag = lag;
    this.plassering = plassering;
  }
}
