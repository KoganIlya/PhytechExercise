package phytechexerciseServer.service;

import java.util.List;

import phytechexerciseServer.dto.ItemDto;

public interface ServerService {
	
	List <ItemDto> getItemsList (); 
	
	int amountOfItem(long itemId);
	
	ItemDto sellItem(long itemId);

}
