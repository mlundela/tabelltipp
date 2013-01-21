package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;


@Entity
public class Runde extends Model {

  public int nummer;
  public Date dato;

}
