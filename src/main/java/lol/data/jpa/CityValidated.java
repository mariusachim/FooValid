package lol.data.jpa;

public class CityValidated {

    @FooValidateMe(message = "works!")
    private String name;

    public CityValidated() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
