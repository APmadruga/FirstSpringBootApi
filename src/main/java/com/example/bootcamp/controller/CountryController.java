package com.example.bootcamp.controller;
import com.example.bootcamp.controller.request.CountryRQ;
import com.example.bootcamp.model.Country;
import com.example.bootcamp.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class CountryController {

    CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> getCountries(){
        return countryService.findAll();
    }

    @PostMapping(value="/country", consumes ="application/json", produces ="application/json" )
    public ResponseEntity createCountry(@RequestBody CountryRQ countryRQ){
        Long countryId = countryService.save(countryRQ).getId();
        return  ResponseEntity.created(URI.create("/country/" + countryId)).body("Operation run smoothly");
    }

    @GetMapping("/country/{id}")
    public Country getCountryById( Long id){
        return countryService.findById(id);
    }

    @PutMapping(value="country/{id}", consumes ="application/json", produces ="application/json")
    public ResponseEntity updateCountry(@PathVariable(value = "id") Long id, @RequestBody CountryRQ countryRQ){
        countryService.updateCountry(id,countryRQ);
        return  ResponseEntity.created(URI.create("/country/" + id)).body("Operation run smoothly");
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public ResponseEntity deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
        return  ResponseEntity.created(URI.create("/country")).body("Operation run smoothly");
    }
}
