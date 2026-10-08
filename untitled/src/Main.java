import java.util.Scanner;


public class Main {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        int webs = 0;
        int spiderCost = 0;
        int websNeeded = 0;
        String Name = "Name";
        boolean yesorNo = false;
        String Dialogue = "if this prints your code is broken";


        System.out.println("what is your name?");
        Name = input.nextLine().toLowerCase().trim();


        System.out.println("Hello, " + Name);


        spiderowner owner = new spiderowner(Name, null);


        while (true) {


            System.out.println("Would you like to roll for a spider? The price is: " + spiderCost);
            System.out.println("Type Y for yes, and N for no.");


            Dialogue = input.nextLine().toLowerCase().trim();


            if (Dialogue.equals("y")) {
                yesorNo = true;
                break;
            }
            else if (Dialogue.equals("n")) {
                yesorNo = false;
                break;
            }
            else {
                System.out.println("Not a valid pick");
            }
        }


        if (yesorNo) {


            System.out.println("Rolling. You now have " + webs + " webs remaining.");


            spider newSpider = new spider();


            owner.addSpider(newSpider);
            newSpider.showInfo();


            System.out.println("That spider is your starter. Would you like it to be favorited? Type y for yes, n for no.");


            Dialogue = input.nextLine().toLowerCase().trim();


            while (!Dialogue.equals("y") && !Dialogue.equals("n")) {


                System.out.println("Not a valid pick");
                Dialogue = input.nextLine().toLowerCase().trim();
            }


            if (Dialogue.equals("y")) {
                owner.setFavorite(newSpider);
            }
        }


        spiderCost = 10;


        boolean playing = true;


        while (playing) {


            printMenu(webs, spiderCost);


            int choice = getMenuChoice(input);


            if (choice == 1) {
                webs = rollForSpider(owner, webs, spiderCost);
                spiderCost = getNewSpiderCost(spiderCost);
            }


            else if (choice == 2) {
                owner.showCollection();
            }


            else if (choice == 3) {
                owner.showFavorite();
            }


            else if (choice == 4) {
                changeFavorite(input, owner);
            }


            else if (choice == 5) {
                searchForSpider(input, owner);
            }


            else if (choice == 6) {
                removeSpider(input, owner);
            }


            else if (choice == 7) {
                webs = spinWebs(owner, webs);
            }


            else if (choice == 8) {
                playing = ageSpiders(owner);
            }


            else if (choice == 9) {
                playing = false;
                System.out.println("Thanks for playing!");
            }
        }


        input.close();
    }


    public static void printMenu(int webs, int spiderCost) {


        System.out.println();
        System.out.println("Webs: " + webs);
        System.out.println("Next spider cost: " + spiderCost);
        System.out.println();


        System.out.println("1. Roll for a spider");
        System.out.println("2. View spider collection");
        System.out.println("3. View favorite spider");
        System.out.println("4. Change favorite spider");
        System.out.println("5. Search for a spider");
        System.out.println("6. Remove a spider");
        System.out.println("7. Spin webs");
        System.out.println("8. Age spiders");
        System.out.println("9. Quit");
    }


    public static int getMenuChoice(Scanner input) {


        int choice = 0;


        while (choice < 1 || choice > 9) {


            System.out.println("What would you like to do?");


            if (input.hasNextInt()) {


                choice = input.nextInt();
                input.nextLine();


                if (choice < 1 || choice > 9) {
                    System.out.println("Not a valid pick");
                }
            }
            else {


                System.out.println("Not a valid pick");
                input.nextLine();
            }
        }


        return choice;
    }


    public static int rollForSpider(spiderowner owner, int webs, int spiderCost) {


        if (webs >= spiderCost) {


            System.out.println("Rolling. You now have " + webs + " webs remaining.");


            spider newSpider = new spider();


            owner.addSpider(newSpider);


            webs = webs - spiderCost;


            newSpider.showInfo();
        }
        else {


            int websNeeded = spiderCost - webs;


            System.out.println("Sorry, you cannot afford a spider right now. You need "
                    + websNeeded + " more webs.");
        }


        return webs;
    }


    public static int getNewSpiderCost(int spiderCost) {


        return spiderCost + 10;
    }


    public static void changeFavorite(Scanner input, spiderowner owner) {


        if (owner.getSpiderCount() == 0) {


            System.out.println("You do not have any spiders.");
        }
        else {


            owner.showCollection();


            System.out.println("Which spider would you like to make your favorite?");


            int favoriteChoice = getSpiderNumber(input, owner);


            owner.changeFavorite(favoriteChoice - 1);
        }
    }


    public static void searchForSpider(Scanner input, spiderowner owner) {


        if (owner.getSpiderCount() == 0) {


            System.out.println("You do not have any spiders.");
        }
        else {


            System.out.println("What species would you like to search for?");


            String search = input.nextLine().toLowerCase().trim();


            owner.searchSpiders(search);
        }
    }


    public static void removeSpider(Scanner input, spiderowner owner) {


        if (owner.getSpiderCount() == 0) {


            System.out.println("You do not have any spiders.");
        }
        else {


            owner.showCollection();


            System.out.println("Which spider would you like to remove?");


            int removeChoice = getSpiderNumber(input, owner);


            owner.removeSpider(removeChoice - 1);
        }
    }


    public static int getSpiderNumber(Scanner input, spiderowner owner) {


        int choice = 0;


        while (choice < 1 || choice > owner.getSpiderCount()) {


            if (input.hasNextInt()) {


                choice = input.nextInt();
                input.nextLine();


                if (choice < 1 || choice > owner.getSpiderCount()) {
                    System.out.println("Not a valid pick");
                }
            }
            else {


                System.out.println("Not a valid pick");
                input.nextLine();
            }
        }


        return choice;
    }


    public static int spinWebs(spiderowner owner, int webs) {


        if (owner.getSpiderCount() == 0) {


            System.out.println("You do not have any spiders.");
        }
        else {


            int websMade = 0;


            for (int i = 0; i < owner.getSpiderCount(); i++) {


                websMade = websMade + owner.getSpider(i).spinWeb();
            }


            webs = webs + websMade;


            System.out.println("Your spiders produced " + websMade + " webs.");
            System.out.println("You now have " + webs + " webs.");
        }


        return webs;
    }


    public static boolean ageSpiders(spiderowner owner) {


        if (owner.getSpiderCount() == 0) {


            System.out.println("You do not have any spiders.");
            return true;
        }


        boolean gameOver = false;


        for (int i = 0; i < owner.getSpiderCount(); i++) {


            owner.getSpider(i).ageUp();


            if (owner.getSpider(i).killPlayer()) {
                gameOver = true;
            }
        }


        if (gameOver) {
            return false;
        }


        return true;
    }
}

// testing branching :)