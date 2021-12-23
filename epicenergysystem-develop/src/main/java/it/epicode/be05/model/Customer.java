package it.epicode.be05.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import it.epicode.be05.model.Bill.BillBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="cliente")
@Data
@AllArgsConstructor
@Builder
public class Customer {

	
	
	public Customer() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	private String businessName;
	private String vatNumber;		
	private String email;
	private LocalDate insertionDate;
	private int annualTurnover;
	private String pec;
	private String telephone;
	private Societa_Type type;
	
	
	@OneToOne( cascade = CascadeType.ALL)
	private Dati_contact_customer contact;
	
	@ManyToOne( cascade = CascadeType.ALL)
	private Bill bills;
	
	@OneToOne( cascade = CascadeType.ALL)
	private Address privateAddress;
	
	@OneToOne( cascade = CascadeType.ALL)
	private Address lagalAdress;

	

	
}
