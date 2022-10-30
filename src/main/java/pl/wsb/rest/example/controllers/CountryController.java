package pl.wsb.rest.example.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.rest.example.models.Country;
import pl.wsb.rest.example.models.CountryDto;
import pl.wsb.rest.example.repositories.CountryRepository;
import pl.wsb.rest.example.services.CountryService;

import java.util.List;

@RestController
@RequestMapping("countries")
@AllArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    List<Country> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Country> get(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.get(id));


    }

    @PostMapping
    ResponseEntity<Country> create(@RequestBody CountryDto countryDto) {
        Country country = countryService.create(countryDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(country);

    }

    @PutMapping("{id}")
    ResponseEntity<Country> update(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.update(id, countryDto));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        countryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
