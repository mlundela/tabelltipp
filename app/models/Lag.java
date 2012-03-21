package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Lag extends Model {

  public String navn;
  public Integer poeng = 0;
}
