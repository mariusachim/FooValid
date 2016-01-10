package lol.data.jpa;

import lol.data.jpa.service.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FooValidator implements ConstraintValidator<FooValidateMe, String> {

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
        return !cityName.equals(cityRepository.findByName(cityName));
    }
}
