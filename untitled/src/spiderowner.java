public class spiderowner {
    private String name;
    private spider favorite;

    public spiderowner(String name, spider favoriteSpider) {
        this.name = name;
        this.favorite = favoriteSpider;
    }
    public void changeFavorite(){
        System.out.println("Which spider is your favorite");
    }
    public void showFavorite() {
        System.out.println(name + "'s favorite is the " + favorite);
    }

    public String getName() {
        return name;
    }
}
