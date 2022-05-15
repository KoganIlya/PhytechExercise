package phytechexerciseServer.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ItemDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3090765704673223201L;
	
	
	long id;
	
	String description;
	
	float price;

}
