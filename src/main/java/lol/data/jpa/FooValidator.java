package lol.data.jpa;

import lol.data.jpa.service.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FooValidator implements ConstraintValidator<FooValidateMe, String> {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void initialize(FooValidateMe annotation) {
    }

    @Override
    public boolean isValid(String cityName, ConstraintValidatorContext ctx) {
        City city = cityRepository.findByName(cityName);
        ctx.buildConstraintViolationWithTemplate("City");
        return city == null || !cityName.equals(city.getName());
    }
}
