package com.example.bootcamp.service;
import com.example.bootcamp.controller.request.CountryRQ;
import com.example.bootcamp.model.Country;
import com.example.bootcamp.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class CountryService{

    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public void deleteById(Long aLong) {
        countryRepository.deleteById(aLong);
    }

    public Country findById(Long aLong) {
        return countryRepository.findById(aLong).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found"));
    }

    public Country save(CountryRQ countryRQ) {
        Country newCountry = Country.builder().name(countryRQ.getName()).name2(countryRQ.getName2()).build();
        return countryRepository.save(newCountry);
    }

    public Country updateCountry(Long id, CountryRQ countryRQ) {
        if(!countryRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found");
        Country countryToBeUpdated = countryRepository.getById(id);
        countryToBeUpdated.setName(countryRQ.getName());
        countryToBeUpdated.setName2(countryRQ.getName2());
        return countryRepository.save(countryToBeUpdated);
    }
}
