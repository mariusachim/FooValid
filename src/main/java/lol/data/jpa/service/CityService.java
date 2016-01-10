package lol.data.jpa.service;

import lol.data.jpa.CityPojo;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class CityService {

    public void createNewCity(@Valid CityPojo city) {
        city.getName();
    }

}
