package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Tips extends Model {

  @ManyToOne
  public Bruker bruker;

  @ManyToOne public Lag p1;
  @ManyToOne public Lag p2;
  @ManyToOne public Lag p3;
  @ManyToOne public Lag p4;
  @ManyToOne public Lag p5;
  @ManyToOne public Lag p6;
  @ManyToOne public Lag p7;
  @ManyToOne public Lag p8;
  @ManyToOne public Lag p9;
  @ManyToOne public Lag p10;
  @ManyToOne public Lag p11;
  @ManyToOne public Lag p12;
  @ManyToOne public Lag p13;
  @ManyToOne public Lag p14;
  @ManyToOne public Lag p15;
  @ManyToOne public Lag p16;
}
