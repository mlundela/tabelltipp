package models;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.Column;
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

//  public List<Group> getGroups() {
//    return Group.find("members contains ?", this).fetch();
//  }

//  public Bruker(String name) {
//    this.name = name;
//  }
//
//  public List<TabellTips> getTips() {
//    return TabellTips.find("bruker = ? order by plassering", this).fetch();
//  }

  public int getScore() {
//    List<Lag> tabell = Lag.getTabell();
//    List<TabellTips> tips = getTips();
//    int trekk = 0;
//    for (TabellTips tip : tips) {
//      Lag fasit = tabell.get(tip.plassering - 1);
//      trekk += Math.abs(fasit.poeng - tip.lag.poeng);
//    }
//    return 100 - trekk / 2;
    return 100;
  }

//  public List<LagPoeng> getTabellPoeng() {
//    List<LagPoeng> out = new ArrayList<LagPoeng>();
//    List<Lag> tabell = Lag.getTabell();
//    List<TabellTips> tips = getTips();
//    for (TabellTips tip : tips) {
//      out.add(new LagPoeng(tabell.get(tip.plassering - 1), tip));
//    }
//    return out;
//  }
//
//  public static List<Bruker> getResultatliste() {
//    List<Bruker> brukere = Bruker.all().fetch();
//    Collections.sort(brukere);
//    return brukere;
//  }

  public int compareTo(User user) {
    return user.getScore() - this.getScore();
  }

  public static User findByEmail(String email) {
    return User.find("email = ?", email).first();
  }
}
