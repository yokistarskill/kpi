class Main {
  static class CupLid {
    private boolean closed;

    public CupLid() {
      this.closed = true;
    }

    public void open() {
      System.out.println("CupLid#open");
      closed = false;
    }

    public void close() {
      System.out.println("CupLid#close");
      closed = true;
    }

    @Override
    public boolean equals(Object obj) {
      System.out.println("CupLid#equals");
      if (this == obj) return true;
      if (!(obj instanceof CupLid)) return false;
      return ((CupLid) obj).closed == closed;
    }

    @Override
    public int hashCode() {
      System.out.println("CupLid#hashCode");
      return Boolean.hashCode(closed);
    }

    @Override
    public String toString() {
      System.out.println("CupLid#toString");
      return String.format("CupLid(closed=%b)", closed);
    }
  }

  static class CupBody {
    private double fluidLevel;

    public CupBody() {
      this.fluidLevel = 0.0;
    }

    public void pourInto(double amount) {
      System.out.println("CupBody#pourInto");
      fluidLevel += amount;
    }

    public void pourOut() {
      System.out.println("CupBody#pourOut");
      fluidLevel = 0.0;
    }

    @Override
    public boolean equals(Object obj) {
      System.out.println("CupBody#equals");
      if (this == obj) return true;
      if (!(obj instanceof CupBody)) return false;
      return ((CupBody) obj).fluidLevel == fluidLevel;
    }

    @Override
    public int hashCode() {
      System.out.println("CupBody#hashCode");
      return Double.hashCode(fluidLevel);
    }

    @Override
    public String toString() {
      System.out.println("CupBody#toString");
      return String.format("CupBody(fluidLevel=%.3f)", fluidLevel);
    }
  }

  static class Cup {
    private CupLid lid;
    private CupBody body;

    public Cup(CupLid lid, CupBody body) {
      this.lid = lid;
      this.body = body;
    }

    public void open() {
      System.out.println("Cup#open");
      lid.open();
    }

    public void close() {
      System.out.println("Cup#close");
      lid.close();
    }

    public void pourInto(double amount) {
      System.out.println("Cup#pourInto");
      body.pourInto(amount);
    }

    public void pourOut() {
      System.out.println("Cup#pourOut");
      body.pourOut();
    }

    @Override
    public boolean equals(Object obj) {
      System.out.println("Cup#equals");
      if (this == obj) return true;
      if (!(obj instanceof Cup)) return false;
      Cup c = (Cup) obj;
      return c.lid.equals(lid) && c.body.equals(body);
    }

    @Override
    public int hashCode() {
      System.out.println("Cup#hashCode");
      return lid.hashCode() * 31 + body.hashCode();
    }

    @Override
    public String toString() {
      System.out.println("Cup#toString");
      return String.format("Cup(lid=%s,body=%s)", lid, body);
    }
  }

  public static void main(String[] args) {
    System.out.println("hello world\n");

    Cup cup1 = new Cup(new CupLid(), new CupBody());
    cup1.open();
    cup1.pourInto(200.0);
    cup1.close();
    System.out.println("cup1 = " + cup1);

    Cup cup2 = new Cup(new CupLid(), new CupBody());
    System.out.println("cup2 = " + cup2 + "\n");

    System.out.println("cup1.equals(cup2) = " + cup1.equals(cup2));     // false
    System.out.println("(cup1.hashCode() == cup2.hashCode()) = " +      // false
      (cup1.hashCode() == cup2.hashCode()) + "\n");

    cup1.open();
    cup1.pourOut();
    cup1.close();
    System.out.println("cup1 = " + cup1 + "\n");

    System.out.println("cup1.equals(cup2) = " + cup1.equals(cup2));     // true
    System.out.println("(cup1.hashCode() == cup2.hashCode()) = " +      // true
      (cup1.hashCode() == cup2.hashCode()));
  }
}
