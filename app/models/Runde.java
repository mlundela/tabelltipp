package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;


@Entity
public class Runde extends Model {

  public int nummer;
  public Date dato;

  public static Runde sisteRunde() {
    return Runde.find("order by nummer desc").first();
  }
}
