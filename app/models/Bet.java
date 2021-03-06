package models;

import play.db.jpa.Model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Entity
public class Bet extends Model {

  @ManyToOne
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


  public void randomize() {
    List<Team> teams = Team.findAll();
    Collections.shuffle(teams);
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
  }

  public List<Team> getAsList() {
    List<Team> out = new ArrayList<Team>();
    out.add(p1);
    out.add(p2);
    out.add(p3);
    out.add(p4);
    out.add(p5);
    out.add(p6);
    out.add(p7);
    out.add(p8);
    out.add(p9);
    out.add(p10);
    out.add(p11);
    out.add(p12);
    out.add(p13);
    out.add(p14);
    out.add(p15);
    out.add(p16);
    return out;
  }
}
