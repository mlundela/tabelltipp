import models.Lag;
import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {

  public void doJob() throws Exception {
    if (Lag.count() == 0) {
      Logger.info("INIT DATABASE");
      Fixtures.deleteDatabase();
      Fixtures.loadModels("testdata.yml");
    }
  }
}
