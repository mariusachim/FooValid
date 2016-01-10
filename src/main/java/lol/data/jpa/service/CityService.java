package lol.data.jpa.service;

import lol.data.jpa.CityValidated;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class CityService {

    public String createNewCity(@Valid CityValidated city) {
        return city.getName();
    }

}
