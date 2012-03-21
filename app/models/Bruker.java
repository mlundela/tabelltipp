package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;


@Entity
public class Bruker extends Model{

  public String navn;

  @ManyToMany
  public List<Lag> tips;

}
