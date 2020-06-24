package exercise2;

class Arrays {
        //Take the arrays.js file, and refactor the code into Java in this file.
        int[] nums = {10, 23, 3, 4, 5, 2, 1};
        String[] greetings = {"hello", "howdy", "hallo", "hola", "bonjour", "ciao", "أهلا"};
        boolean[] binaries = {false, true, true, true, false, false, false, true, true, true, true, true, false, true, false, false, true, false};

        public void printNums () {
            for (int i : nums) {
                System.out.println(i);
            }
        }
        public void printGreetings () {
            for (int i = 0; i < greetings.length; i++) {
                System.out.println(greetings[i]);
            }
        }
        public void printBinaries () {
            for(boolean i: binaries){
                System.out.println(i);
            }
            }
        
        public static void main(String[] args){
            Arrays array = new Arrays();
            array.printNums();
            array.printGreetings();
            array.printBinaries();
        }
    }







