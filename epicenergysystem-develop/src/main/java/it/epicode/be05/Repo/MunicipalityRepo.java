package it.epicode.be05.Repo;




import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be05.model.Municipality;




public interface MunicipalityRepo extends  PagingAndSortingRepository<Municipality, Long>{
	
	

}
