import java.util.ArrayList;


public class spiderowner {


    private String name;
    private spider favorite;
    private ArrayList<spider> spiders;


    public spiderowner(String name, spider favoriteSpider) {


        this.name = name;
        this.favorite = favoriteSpider;
        spiders = new ArrayList<spider>();
    }


    public void addSpider(spider newSpider) {


        spiders.add(newSpider);


        System.out.println(newSpider.getSpecies()
                + " was added to your collection.");
    }


    public void removeSpider(int index) {


        if (index >= 0 && index < spiders.size()) {


            spider removedSpider = spiders.get(index);


            if (removedSpider == favorite) {
                favorite = null;
            }


            spiders.remove(index);


            System.out.println(removedSpider.getSpecies()
                    + " was removed from your collection.");
        }
    }


    public void changeFavorite(int index) {


        if (index >= 0 && index < spiders.size()) {


            favorite = spiders.get(index);


            System.out.println(favorite.getSpecies()
                    + " is now your favorite spider.");
        }
    }


    public void setFavorite(spider newFavorite) {


        if (spiders.contains(newFavorite)) {


            favorite = newFavorite;


            System.out.println(newFavorite.getSpecies()
                    + " is now your favorite spider.");
        }
    }


    public void searchSpiders(String search) {


        boolean found = false;


        for (int i = 0; i < spiders.size(); i++) {


            if (spiders.get(i).getSpecies().toLowerCase().contains(search)) {


                System.out.println("Spider #" + (i + 1));


                spiders.get(i).showInfo();


                found = true;
            }
        }


        if (!found) {


            System.out.println("No spiders matching that search were found.");
        }
    }


    public void showCollection() {


        if (spiders.size() == 0) {


            System.out.println("Your spider collection is empty.");
        }
        else {


            System.out.println("----- " + name
                    + "'S SPIDER COLLECTION -----");


            for (int i = 0; i < spiders.size(); i++) {


                System.out.println("Spider #" + (i + 1));


                spiders.get(i).showInfo();
            }
        }
    }


    public void showFavorite() {


        if (favorite == null) {


            System.out.println("You do not have a favorite spider.");
        }
        else {


            System.out.println(name + "'s favorite is the "
                    + favorite.getSpecies());


            favorite.showInfo();
        }
    }


    public int getSpiderCount() {


        return spiders.size();
    }


    public spider getSpider(int index) {


        if (index >= 0 && index < spiders.size()) {
            return spiders.get(index);
        }


        return null;
    }


    public String getName() {


        return name;
    }
}

