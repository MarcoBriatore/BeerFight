package UTN.model;

public class Spartan extends Human{

    private Integer extremeTolerance = 2;

    public Spartan(String name, Integer age, Integer weight, IPee pee, IDrink drink) {
        super(name, age, weight, pee, drink);
    }

    public Integer getExtremeTolerance() {
        return extremeTolerance;
    }

    public Integer getMetabolism()
    {
        return Math.round((this.getWeight() * extremeTolerance) / this.getAge());
    }
}
