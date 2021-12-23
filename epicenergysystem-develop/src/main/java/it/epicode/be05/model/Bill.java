package it.epicode.be05.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name="bill")
@Data
@AllArgsConstructor
@Builder
public class Bill {
	
	
	public Bill () {}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	
	private int year; 
	private LocalDate data ;
	private BigDecimal amount; 
	private int number ; 
	private boolean state;
	

	@ManyToOne( cascade = CascadeType.MERGE)
	private Customer customer ;
	

}
