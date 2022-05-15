package phytechexerciseServer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import phytechexerciseServer.model.Item;

public interface ItemsRepository extends JpaRepository<Item, Long> {
	
       

}
