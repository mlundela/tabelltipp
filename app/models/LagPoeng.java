package models;

public class LagPoeng {

  public Lag fasit;
  public TabellTips tips;

  public LagPoeng(Lag fasit, TabellTips tips) {
    this.fasit = fasit;
    this.tips = tips;
  }

  public int getScore() {
    return Math.abs(fasit.poeng - tips.lag.poeng);
  }

}
