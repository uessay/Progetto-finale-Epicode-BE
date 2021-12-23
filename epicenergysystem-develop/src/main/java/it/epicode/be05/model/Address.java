package it.epicode.be05.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import it.epicode.be05.model.Municipality.MunicipalityBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name="address")
@Data
@AllArgsConstructor
@Builder
public class Address {
	public Address() {}
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	
	private String street;
	private String civic;
	private int cap;  // cap da csv??
	
	@ManyToOne (cascade =CascadeType.ALL)
	private Municipality comune; 
	
	

}
