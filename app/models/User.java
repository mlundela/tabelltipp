package models;

import play.Logger;
import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "usr")
public class User extends Model implements Comparable<User> {

  @Required(message = "Navn ikke oppgitt.")
  @MinSize(value = 2, message = "Navn for kort.")
  public String name;

  @Required(message = "Epost ikke oppgitt.")
  @Email(message = "Ugyldig epost.")
  @Unique(message = "Det er allerede registrert en bruker på denne epost-adressen.")
  public String email;

  @Required(message = "Passord ikke oppgitt.")
  @MinSize(value = 4, message = "Passord må bestå av minst 4 tegn.")
  public String password;

  @ManyToMany(mappedBy = "members")
  public Set<Group> groups = new HashSet<Group>();

  public Bet getBet() {
    return Bet.find("user = ? order by id desc", this).first();
  }

  public int getScore() {
    Logger.info(name + " - getScore()");
    List<Team> table = Team.getTable();
    List<Team> bet = getBet().getAsList();
    int m = 0;
    for (int i = 0; i < 16; i++) {
      Team t1 = table.get(i);
      Team t2 = bet.get(i);
      m += Math.abs(t2.points - t1.points);
    }
    return 100 - m / 2;
  }

  public int compareTo(User user) {
    return user.getScore() - this.getScore();
  }
}
