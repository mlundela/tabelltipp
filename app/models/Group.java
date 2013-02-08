package models;

import net.sf.oval.constraint.NotEmpty;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "grp")
public class Group extends Model {

  @NotEmpty
  public String name;

  @ManyToMany
  public List<User> members = new ArrayList<User>();

  public Group(String name) {
    this.name = name;
  }
}
