package phytechexerciseServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import phytechexerciseServer.model.dto.ItemDto;
import phytechexerciseServer.service.ServerService;

@RestController
public class ServerContoller {
	
	ServerService service;

	@Autowired
	public ServerContoller(ServerService service) {
		this.service = service;
	}
	
	@GetMapping("/items")
	public List<ItemDto> getAllItems() {
		return service.getItemsList();
	}
	
	@GetMapping("/amount") 
	public int getAmount(@RequestParam long id) {
		return service.amountOfItem(id);
	}
	
	@PostMapping("/sell")
	public ItemDto sellItem(@RequestParam long id) {
		return service.sellItem(id);
	}
	
	
	

}
