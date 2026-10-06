import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        int webs= 0;
        int spiderCost=0;
        int websNeeded= spiderCost-webs;
        String Name= ("Name");
        boolean yesorNo= false;
        String Dialogue= ("if this prints your code is broken");
        Scanner input = new Scanner(System.in);
        System.out.println("what is your name?");
        Name = input.nextLine().toLowerCase().trim();
        System.out.println("Hello, "+Name);


            System.out.println("Would you like to roll for a spider? The price is: " + spiderCost);
            System.out.println("Type Y for yes, and N for no.");

            Dialogue = input.nextLine().toLowerCase().trim();

            if (Dialogue.equals("y")) {
                yesorNo = true;

            }
            else if (Dialogue.equals("n")) {
                yesorNo = false;

            }
            else {
                System.out.println("Not a valid pick");
            }

        if (webs >= spiderCost) {
            System.out.println("Rolling. You now have "+ webs+" webs remaining.");
            spider newSpider = new spider();
            newSpider.showInfo();
            webs = webs - spiderCost;
            spiderCost = spiderCost + 10;
        }
        if (websNeeded > webs) {
            System.out.println("Sorry, you cannot afford a spider right now. You need to get "+ websNeeded +" more webs.");

        }
        System.out.println("That spider is your starter. Would you like it to be favorited? Type y for yes, n for no.");
            Dialogue = input.nextLine().toLowerCase().trim();
            if (Dialogue==("y")){
                spiderowner changeFavorite;
            }
            System.out.println("Welcome to your spider collection.");
           while (true) {
               System.out.println("What would you like to do?");

           }


    }
}





