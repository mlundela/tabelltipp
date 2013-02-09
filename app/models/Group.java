package models;

import net.sf.oval.constraint.NotEmpty;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "grp")
public class Group extends Model {

  @NotEmpty
  public String name;

  @ManyToMany
  public Set<User> members = new HashSet<User>();

  public Group(String name) {
    this.name = name;
  }
}
