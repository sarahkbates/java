package exercise2;

class Monkeys {
        boolean monkeyBusiness(Monkey[] monkeys) {
            int isSmiling = 0;
            int isFrowning = 0;
    
            for(Monkey newMonkey : monkeys )
                if (newMonkey.smile){
                    isSmiling++;
                }
                else isFrowning++;
    
                return isSmiling >= isFrowning; //if majority are not smiling, returning false. if it's a tie, return true
    //BONUS EXERCISE
    //We have a set of monkeys.  Each Monkey has a boolean smile property, which indicates if that particular monkey is smiling.  Determine whether or not the majority of monkeys are smiling.  If the majority are smiling, return true.  if the majority are not smiling, return false.  If it is a tie, return true.  
    }

    class Monkey {
        String name;
        boolean smile;
    }

    public Monkey getMonkey(String name, boolean smile){
        Monkey newMonkey = new Monkey();
        newMonkey.name = name;
        newMonkey.smile = smile;

        return newMonkey;
    }

    public static void main(String[] args) {
        //Bonus exercise instructions:  create an array of at least 3 monkeys, utilizing the nested Monkey class, and determine whether the majority of them are smiling or not.  
        //required monkey data:
        // Rafiqi is smiling
        // Curious George is smiling
        // King Kong is not smiling
        //You are NOT allowed to move the Monkey class.  Keep it where it is.  

        Monkeys monkeys = new Monkeys();
        Monkey rafiqi = monkeys.getMonkey("Rafiqi", true);
        Monkey kingKong = monkeys.getMonkey("King Kong", false);
        Monkey george = monkeys.getMonkey("Curious George", false);
        Monkey koko = monkeys.getMonkey("Koko", true);
        Monkey donkeyKong = monkeys.getMonkey("Donkey Kong", false);
        Monkey diddyKong = monkeys.getMonkey("Diddy Kong", false);

        Monkey[] monkeyList = {rafiqi, george, diddyKong, koko};
        System.out.println("The majority of monkeys are smiling...?");
        System.out.println(monkeys.monkeyBusiness(monkeyList));
        
    }

    
}