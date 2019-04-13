package UTN.model;

public class Human {

    private String name;
    private Integer age;
    private Integer weight;
    private IPee Pee;
    private IDrink Drink;

    public Human(String name, Integer age, Integer weight, IPee pee, IDrink drink) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        Pee = pee;
        Drink = drink;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public IPee getPee() {
        return Pee;
    }

    public void setPee(IPee pee) {
        Pee = pee;
    }

    public IDrink getDrink() {
        return Drink;
    }

    public void setDrink(IDrink drink) {
        Drink = drink;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
