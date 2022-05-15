package phytechexerciseServer.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@ToString
public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2461901494388251338L;
	
	
	@Id
	@Column(name = "stock_id")
	long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    Stock stock;
	
	String description;
	
	float price;

}
