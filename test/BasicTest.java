import models.Bruker;
import models.Lag;
import models.Tips;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

import java.util.List;

public class BasicTest extends UnitTest {

//  @Test
  public void aVeryImportantThingToTest() {


    Fixtures.deleteDatabase();

//    Lag brann = new Lag();
//    Lag rosenborg = new Lag();
//    Lag viking = new Lag();
//
//    brann.poeng = 50;
//    rosenborg.poeng = 30;
//    viking.poeng = 25;
//
//    brann.save();
//    rosenborg.save();
//    viking.save();
//
//    Bruker henning = new Bruker("Henning Den Lure");
//    Bruker mads = new Bruker("Mads Litt Dum");
//    Bruker nhat = new Bruker("Stokk dum");
//    henning.save();
//    mads.save();
//
//    assertEquals(2, Bruker.all().fetch().size());
//
//    new Tips(henning, brann, 1).save();
//    new Tips(henning, rosenborg, 2).save();
//    new Tips(henning, viking, 3).save();
//
//    new Tips(mads, rosenborg, 1).save();
//    new Tips(mads, brann, 2).save();
//    new Tips(mads, viking, 3).save();
//
//    List<Tips> alleTips = Tips.findAll();
//    assertEquals(6, alleTips.size());
//
//    assertEquals(100, henning.getScore());
//    assertEquals(60, mads.getScore());
  }

//  @Test
  public void heningTips() {

    Fixtures.deleteDatabase();
    Fixtures.loadModels("testdata.yml");

    Bruker henning = Bruker.find("navn = ?", "Henning").first();
    Bruker nhat = Bruker.find("navn = ?", "Nhat").first();
    assertEquals(32, Tips.all().fetch().size());
    assertEquals(-12, henning.getScore());
    assertEquals(-96, nhat.getScore());
  }

//  @Test
  public void resultatliste() {

    Fixtures.deleteDatabase();
//    Fixtures.loadModels("testdata.yml");

//    List<Bruker> resultatliste = Bruker.getResultatliste();
//    assertEquals(100, resultatliste.get(0).getScore());
//    assertEquals(-12, resultatliste.get(1).getScore());
//    assertEquals(-96, resultatliste.get(2).getScore());
//    assertEquals(3, resultatliste.size());
  }

}
