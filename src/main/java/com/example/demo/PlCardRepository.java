package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlCardRepository extends JpaRepository<PlCard, Long>{
	List<PlCard> findByName(String name);
	List<PlCard> findByNameLike(String name);
	Optional<PlCard> findById(Long id);

}
