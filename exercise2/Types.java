package exercise2;

class Types {
//    This class has syntax errors, that will prevent your other classes from running.  So... work on this file first to resolve the issues.
   int number;
   int[] myArray = {3,4,5,6,76,12,2};
   String movieA = "Harry and the Hendersons";
   String movieB = "Star Wars";
   char male = 'm';
   char female = 'f';

//    //the above instance variables have mistakes with their data types.  Fix the data types so the main method correctly displays the value of all of the variables
public Types(int number, int[] myArray, String movieA, String movieB, char male, char female) {
    this.number = number;
    this.myArray = myArray;
    this.movieA = movieA;
    this.movieB = movieB;
    this.male = male;
    this.female = female;
}
   public static void main(String[] args) {
Types t = new Types(55, new int[]{3,4,5,6,76,12,2}, "Harley Quinn: Birds of Prey", "Star Wars: A New Hope", 'm', 'f');
        System.out.println("There are variables that have been declared in this Accessible class.  Fix the code so that all the variables can be accessed by the main method.  print out the values of every variable once the code has been refactored.");
      System.out.println("You watched " + t.movieA + " " + t.number + " times." );
    System.out.println("Out of the total people who saw " + t.movieB + " on opening weekend, 56% were " + t.male + ", and 44% were " + t.female + "." );
   }
}