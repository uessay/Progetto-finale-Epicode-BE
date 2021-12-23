package it.epicode.be05.model;


import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="provincia")
@Data
@AllArgsConstructor
@Builder

public class Province {

	public Province() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;


	String sigla;

	String nameProvince;



	
	

}
