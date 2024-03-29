package com.pack.fabo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pack.fabo.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	
	@Query("SELECT DISTINCT c.state FROM Client c")
    List<String> findDistinctStates();

    @Query("SELECT DISTINCT c.city FROM Client c")
    List<String> findDistinctCities();
    
    List<Client> findByStateAndCity(String state, String city);
    
    List<Client> findByState(String state);

    List<Client> findByCity(String city);
    
    @Query("SELECT c FROM Client c WHERE " +
            "(LOWER(c.state) = LOWER(:state) or :state = 'All') and " +
            "(LOWER(c.storeName) LIKE %:searchTerm% OR " +
            "LOWER(c.city) LIKE %:searchTerm% OR " +
            "c.storeCode LIKE %:searchTerm% OR " +
            "LOWER(c.ownerContact) LIKE %:searchTerm% OR " +
            "c.storeContact LIKE %:searchTerm%)")
    List<Client> findBySearchTerm(@Param("searchTerm") String searchTerm, @Param("state") String state);
    




	Optional<Client> findByEmail(String email);
}
