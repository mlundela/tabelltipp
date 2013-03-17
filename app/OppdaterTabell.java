import models.Team;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import play.Logger;
import play.jobs.Job;
import play.jobs.On;

@On("0 */5 12-20 * * ?")
public class OppdaterTabell extends Job {

  public void doJob() throws Exception {

    Logger.info("OPPDATERER TABELL");
    Document doc = Jsoup.connect("http://www.altomfotball.no/element.do?cmd=tournamentTable&tournamentId=1").get();
    Elements elements = doc.select(".sd_table_team a");

    for (Element element : elements) {
      String points = element.parent().parent().select(".sd_table_points").text();
      int id = Integer.parseInt(element.attr("href").split("&")[1].substring(7));
      String name = null;

      switch (id) {
        case 315: name = "Tromsø"; break;
        case 314: name = "Vålerenga"; break;
        case 309: name = "Molde"; break;
        case 326: name = "Sogndal"; break;
        case 313: name = "Rosenborg"; break;
        case 361: name = "Fredrikstad"; break;
        case 306: name = "Haugesund"; break;
        case 328: name = "Strømsgodset"; break;
        case 303: name = "Viking"; break;
        case 327: name = "Hønefoss"; break;
        case 403: name = "Aalesund"; break;
        case 302: name = "Brann"; break;
        case 311: name = "Odd Grenland"; break;
        case 496: name = "Sandnes Ulf"; break;
        case 308: name = "Lillestrøm"; break;
        case 312: name = "Stabæk"; break;
        case 305: name = "Start"; break;
        case 541: name = "Sarpsborg 08"; break;
      }

      Team team = Team.find("name = ?", name).first();
      team.points = Integer.valueOf(points);
      team.save();

      Logger.info(name + " har " + points + " poeng");
    }
  }
}
