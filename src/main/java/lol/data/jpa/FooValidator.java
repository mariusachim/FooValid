package lol.data.jpa;

import lol.data.jpa.service.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FooValidator implements ConstraintValidator<FooValidateMe, String> {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CityRepository cityRepository;

    public FooValidator() {
        System.out.println("lol");
    }

    @Override
    public void initialize(FooValidateMe annotation) {
    }

    @Override
    public boolean isValid(String cityName, ConstraintValidatorContext ctx) {
        City city = cityRepository.findByName(cityName);
        return city == null || !cityName.equals(city.getName());
    }
}
