package UTN.model;

public class Viking extends Human {



    private Integer expertDrinker = 3;



    public Viking(String name, Integer age, Integer weight, IPee pee, IDrink drink) {
        super(name, age, weight, pee, drink);
    }

    public Integer getExpertDrinker() {
        return expertDrinker;
    }

    public Integer getMetabolism()
    {
        return Math.round(this.getWeight() / (this.getAge() / expertDrinker));
    }
}
