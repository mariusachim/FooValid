package lol.data.jpa;

public class CityPojo {

    @FooValidateMe
    private String name;

    public CityPojo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
