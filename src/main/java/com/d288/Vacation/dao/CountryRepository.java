package com.d288.Vacation.dao;

import com.d288.Vacation.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CountryRepository extends JpaRepository<Country, Long> {
}
