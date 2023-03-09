package service;

import model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> findAll(Pageable pageable);
    City findById(Long id);
    void deleteById(Long id);
    void save(City city);
}
