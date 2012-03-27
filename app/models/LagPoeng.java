package models;

public class LagPoeng {

  public Lag fasit;
  public TabellTips tips;

  public LagPoeng(Lag fasit, TabellTips tips) {
    this.fasit = fasit;
    this.tips = tips;
  }

  public float getScore() {
    return (float) (Math.abs(fasit.poeng - tips.lag.poeng) *-0.5);
  }

}
