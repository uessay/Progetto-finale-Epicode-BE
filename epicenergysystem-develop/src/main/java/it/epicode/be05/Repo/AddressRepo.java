package it.epicode.be05.Repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be05.model.Address;

public interface AddressRepo  extends  PagingAndSortingRepository<Address, Long>{

}
