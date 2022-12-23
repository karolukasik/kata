package rocks.kata;

public class FizzBuzz {
    public static void main(String[] args) {
        
    }

    public String returnFizzBuzzOrNumber(int index) {
        StringBuilder toReturn = new StringBuilder();
        if(index % 3 == 0){
            toReturn.append("Fizz");
        }
        return toReturn.toString();
    }

    

}
