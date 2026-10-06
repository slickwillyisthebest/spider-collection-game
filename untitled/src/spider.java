import java.util.Random;

public class spider {

    private String species;
    private String rarity;
    private int monthsalive;
    private boolean isSpinWeb;
    private int size;
    private int hungerDrain;
    private boolean isDeadly;
    private int webs = 0;
    Random random = new Random();
    public spider() {

        monthsalive = 0;
        size = 1;
        hungerDrain = 1;
        isSpinWeb = false;


        int rarityRoll = random.nextInt(100) + 1;

        if (rarityRoll <= 60) {
            rarity = "Common";

        } else if (rarityRoll <= 85) {
            rarity = "Uncommon";

        } else if (rarityRoll <= 98) {
            rarity = "Rare";

        } else {
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

        } else if (rarity.equals("Uncommon")) {

            String[] spiders = {
                    "Huntsman Spider",
                    "Fishing Spider",
                    "Trapdoor Spider"
            };

            species = spiders[random.nextInt(spiders.length)];

        } else if (rarity.equals("Rare")) {

            String[] spiders = {
                    "Tarantula",
                    "Brown Recluse"
            };

            species = spiders[random.nextInt(spiders.length)];

        } else {

            String[] spiders = {
                    "Black Widow"
            };

            species = spiders[random.nextInt(spiders.length)];
        }
        if (species.equals("Black Widow") ||
                species.equals("Brown Recluse")) {

            isDeadly = true;

        } else {

            isDeadly = false;
        }
    }
    public void ageUp() {
        monthsalive = monthsalive + 1;
    }
    public void killPlayer() {

        if (isDeadly && random.nextInt(100) == 0) {
            System.out.println("One of your " + species + "bit you in your sleep. Game over. ");
        }
    }

    public void spinWeb() {

        if (random.nextInt(2) == 0) {
            isSpinWeb = true;
        } else {
            isSpinWeb = false;
        }

        if (isSpinWeb) {

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
    public int getHungerDrain() {
        return hungerDrain;
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
