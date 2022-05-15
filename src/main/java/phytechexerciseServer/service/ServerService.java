package phytechexerciseServer.service;

import java.util.List;

import phytechexerciseServer.model.dto.ItemDto;

public interface ServerService {
	
	List<ItemDto> getItemsList (); 
	
	int amountOfItem(long id);
	
	ItemDto sellItem(long id);

}
