package phytechexerciseServer.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Stock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4284648536562866841L;

	@Id
	@Column(name = "id")
	long id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="id")
	Item item;

	int amount;
	

}
