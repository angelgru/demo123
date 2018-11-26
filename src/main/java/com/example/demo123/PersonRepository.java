package com.example.demo123;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//Ova e se sto treba da napravish za JPA da mozhe da pravi Create Read Update Delete vo bazata
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
