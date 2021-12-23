package it.epicode.be05.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name="comune")
@Data
@AllArgsConstructor
@Builder
public class Municipality {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public Municipality() {}
	
	private String denomination_in_italy;
	
	
	@ManyToOne(cascade = CascadeType.MERGE )
	private Province pro;


	

}
