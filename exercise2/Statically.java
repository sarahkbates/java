package exercise2;

public class Statically {
    private static String glue = "Epoxy";
    private static String jello = "Jello";
  
    private static void moveAndShake() {
      System.out.println("Never stagnate in life.  Be agile, change, and improve...");
    }
  
    private static void stubborn() {
      Statically.moveAndShake();
      System.out.println("Please don't make me change... I just don't like it...");
    }
  
    private static void explain() {
      Statically.stubborn();
      System.out.println(Statically.glue);
      System.out.println("They both operate in the class instead of the instance, which is why the method needed to change the methods to call Statically for them to work. Static classes return an instance in both JS and Java.");
    }
  
    public static void main(String[] args) {
      Statically stats = new Statically();
  
      Statically.moveAndShake();
      Statically.stubborn();
      Statically.explain();
  
      System.out.println(Statically.glue);
      System.out.println(stats.jello);
    }
  
  };
  