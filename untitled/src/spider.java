import java.util.Random;


public class spider {


    private String species;
    private String rarity;
    private int monthsalive;
    private int size;
    private boolean isDeadly;
    private int webs = 0;


    private Random random = new Random();


    public spider() {


        monthsalive = 0;
        size = 1;


        int rarityRoll = random.nextInt(100) + 1;


        if (rarityRoll <= 60) {
            rarity = "Common";
        }
        else if (rarityRoll <= 85) {
            rarity = "Uncommon";
        }
        else if (rarityRoll <= 98) {
            rarity = "Rare";
        }
        else {
            rarity = "Legendary";
        }


        if (rarity.equals("Common")) {


            String[] spiders = {
                    "Wolf Spider",
                    "Jumping Spider",
                    "Orb Weaver",
                    "Cellar Spider"
            };


            species = spiders[random.nextInt(spiders.length)];
        }


        else if (rarity.equals("Uncommon")) {


            String[] spiders = {
                    "Huntsman Spider",
                    "Fishing Spider",
                    "Trapdoor Spider"
            };


            species = spiders[random.nextInt(spiders.length)];
        }


        else if (rarity.equals("Rare")) {


            String[] spiders = {
                    "Tarantula",
                    "Brown Recluse"
            };


            species = spiders[random.nextInt(spiders.length)];
        }


        else {


            String[] spiders = {
                    "Black Widow"
            };


            species = spiders[random.nextInt(spiders.length)];
        }


        if (species.equals("Black Widow") ||
                species.equals("Brown Recluse")) {


            isDeadly = true;
        }
        else {
            isDeadly = false;
        }
    }


    public void ageUp() {


        monthsalive = monthsalive + 1;


        if (monthsalive % 12 == 0) {
            size = size + 1;
        }
    }


    public boolean killPlayer() {


        if (isDeadly && random.nextInt(100) == 0) {


            System.out.println("One of your " + species
                    + " bit you in your sleep. Game over.");


            return true;
        }


        return false;
    }


    public int spinWeb() {


        if (random.nextInt(2) == 0) {


            webs = webs + 1;


            return 1;
        }
        else {
            return 0;
        }
    }


    public String getSpecies() {
        return species;
    }


    public String getRarity() {
        return rarity;
    }


    public boolean getIsDeadly() {
        return isDeadly;
    }


    public int getMonthsAlive() {
        return monthsalive;
    }


    public int getSize() {
        return size;
    }


    public int getWebs() {
        return webs;
    }


    public void showInfo() {


        System.out.println("----- SPIDER -----");
        System.out.println("Species: " + species);
        System.out.println("Rarity: " + rarity);
        System.out.println("Deadly: " + isDeadly);
        System.out.println("Age: " + monthsalive + " months");
        System.out.println("Size: " + size);
        System.out.println("Webs produced: " + webs);
        System.out.println("------------------");
    }
}

