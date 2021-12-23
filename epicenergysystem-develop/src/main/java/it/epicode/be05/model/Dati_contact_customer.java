package it.epicode.be05.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Entity
@Table(name="dati")
@Data
@AllArgsConstructor
@Builder
public class Dati_contact_customer {
	
	public Dati_contact_customer() {}
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	
	private String EmailContact;
	private String NameContact;
	private String LastnameContact;
	private String NumberTelephoneContact;
	private LocalDate dataUltimoContact;

}
