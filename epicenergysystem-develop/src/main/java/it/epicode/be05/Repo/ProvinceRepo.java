package it.epicode.be05.Repo;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be05.model.Dati_contact_customer;
import it.epicode.be05.model.Province;




public interface ProvinceRepo extends  PagingAndSortingRepository<Province, Long>{
	
	Province  findByNameProvince(String d);

}
