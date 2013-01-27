package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;


@Entity
public class Bet extends Model {

  @ManyToOne(cascade = CascadeType.PERSIST)
  public User user;

  @ManyToOne public Team p1;
  @ManyToOne public Team p2;
  @ManyToOne public Team p3;
  @ManyToOne public Team p4;
  @ManyToOne public Team p5;
  @ManyToOne public Team p6;
  @ManyToOne public Team p7;
  @ManyToOne public Team p8;
  @ManyToOne public Team p9;
  @ManyToOne public Team p10;
  @ManyToOne public Team p11;
  @ManyToOne public Team p12;
  @ManyToOne public Team p13;
  @ManyToOne public Team p14;
  @ManyToOne public Team p15;
  @ManyToOne public Team p16;


  public void init() {
    List<Team> teams = Team.findAll();
    p1 = teams.get(0);
    p2 = teams.get(1);
    p3 = teams.get(2);
    p4 = teams.get(3);
    p5 = teams.get(4);
    p6 = teams.get(5);
    p7 = teams.get(6);
    p8 = teams.get(7);
    p9 = teams.get(8);
    p10 = teams.get(9);
    p11 = teams.get(10);
    p12 = teams.get(11);
    p13 = teams.get(12);
    p14 = teams.get(13);
    p15 = teams.get(14);
    p16 = teams.get(15);
    user = new User();
  }
}
