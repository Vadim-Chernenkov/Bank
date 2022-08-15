package com.example.Bank.repository;

import com.example.Bank.model.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository extends JpaRepository<PersonalData, String> {

}
