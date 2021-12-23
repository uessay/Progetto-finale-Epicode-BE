package it.epicode.be05;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.lang.Arrays;
import it.epicode.be05.Impl.UserImpl;
import it.epicode.be05.Repo.BillRepo;
import it.epicode.be05.Repo.CustomerRepo;
import it.epicode.be05.Repo.Dati_contact_customerRepo;
import it.epicode.be05.Repo.MunicipalityRepo;
import it.epicode.be05.Repo.ProvinceRepo;
import it.epicode.be05.Repo.RoleRepo;
import it.epicode.be05.Service.Dati_contact_customerService;
import it.epicode.be05.model.Address;
import it.epicode.be05.model.Bill;
import it.epicode.be05.model.Customer;
import it.epicode.be05.model.Dati_contact_customer;
import it.epicode.be05.model.Municipality;
import it.epicode.be05.model.Province;
import it.epicode.be05.model.Role;
import it.epicode.be05.model.Societa_Type;
import it.epicode.be05.model.User;
import it.epicode.be05.support.Anagrafica;

@Component
public class run implements CommandLineRunner {

	@Autowired
	Anagrafica z;

	@Autowired
	private RoleRepo repo;

	@Autowired
	private UserImpl s;

	@Autowired
	Dati_contact_customerRepo i;

	@Autowired
	CustomerRepo cu;
	@Autowired
	ProvinceRepo prov;
	@Autowired
	MunicipalityRepo m;

	@Autowired
	BillRepo b;

	@Override
	public void run(String... args) throws Exception {
		z.readFile();
		
		//List<RoleType> role = new ArrayList<RoleType>();
		//role.add(RoleType.ADMIN);
		var admin = Role.builder().roleName("admin").build();
		
	User user =  User.builder()
			.cognome("uess")
			.email("email@email")
			.nome("boh")
			.username("uuuuu")
			.password("mgcdd")
			.build();
		user.getRoles().add(admin);
	
		// this.showAdminBoard = this.roles.includes('admin');
	 
	  repo.save(admin);
	  s.create(user);
	  
	

	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	 
	  LocalDate date = LocalDate.of(2000, Month.AUGUST, 3);
	  LocalDate date1 = LocalDate.of(2012, Month.FEBRUARY, 5);
	  LocalDate date2 = LocalDate.of(2021, Month.JULY, 6);
	  LocalDate date3 = LocalDate.of(2000, Month.MARCH, 8);
	  LocalDate date4 = LocalDate.of(1996, Month.OCTOBER, 7);
	  LocalDate date5 = LocalDate.of(1995, Month.SEPTEMBER, 6);
	  
	  
	  
	  
	  
	  var Dati_contatto2 = Dati_contact_customer.builder().LastnameContact("ede")
			  .dataUltimoContact(date1)
			  .EmailContact("paolo@##")
			  .NameContact("A").NumberTelephoneContact("23433223").build();
	  
	  
	  i.save(Dati_contatto2);
	  
	  var Dati_contatto = Dati_contact_customer.builder().LastnameContact("ede")
			  .dataUltimoContact(date2)
			  .EmailContact("paolo@##")
			  .NameContact("paolo").NumberTelephoneContact("23433223").build();
	  
	  var bill = Bill
			  .builder().year(date4.getYear())
			  .data(date4)
			  .amount(new BigDecimal(1136))
			  .number(12345)
			  .state(false)
			  .build();
	  
	  
	
	  var address = Address.builder()
			  .cap(94010)
			  .civic("5B")
		
			  .build();
	
	  
	  
	  var cust = Customer.builder()
			  .email("@rrfgrg")
			  .businessName("aolo")
			  .vatNumber("wsdfr423232")
			  .insertionDate(date3)
			  .annualTurnover(500000)
			  .pec("rfrf")
			  .telephone("234234324")
			  .bills(bill)
			  .contact(Dati_contatto)
			  .lagalAdress(address)
			  .type(Societa_Type.SAS)
			  .build();
	
	  cu.save(cust);
	  
      //var province = Province.builder().name_province("okok").sigla("ok").build();
      // comune = Municipality.builder().denomination_in_italy("ok").pro(province).build();
      
	  
      
	  var Dati_contatto4 = Dati_contact_customer.builder().LastnameContact("ede")
			  .dataUltimoContact(date2)
			  .EmailContact("paolo@##")
			  .NameContact("paolo").NumberTelephoneContact("23433223").build();
	  
	  
	  var bill2 = Bill
			  .builder().year(date5.getYear())
			  .data(date5)
			  .amount(new BigDecimal(12136))
			  .number(12345)
			  .state(false)
			  .build();
	 
	  
	  var address2 = Address.builder()
			  .cap(94010)
			  .civic("5B")
			  //.comune(comune)
			  .build();
	  
	  
	  
	
	  
	  
	  var cust1 = Customer.builder()
			  .email("@rrfgrg")
			  .businessName("paeef")
			  .vatNumber("wsdfr423232")
			  .insertionDate(date)
			  .annualTurnover(600000)
			  .pec("rfrf")
			  .telephone("234234324")
			  .bills(bill2)
			  .contact(Dati_contatto4)
			  .lagalAdress(address2)
			  .type(Societa_Type.SRL)
			  .build();
	
	
	  cu.save(cust1);
	  
	 
	  var bill3 = Bill
			  .builder()
			  .year(date3.getYear())
			  .data(date3)
			  .amount(new BigDecimal(12136))
			  .number(12345)
			  .state(false)
			  .customer(cust1)
			  .build();
	 
	
     b.save(bill3);
	

    
     
     List<Bill> myList =   b.findByState(false, Pageable.unpaged()).getContent();
  
  
   
     myList.forEach(System.out::println);

   
   
   
		/*
		 * @Query("SELECT u FROM Customer u ORDER BY u.fatturatoAnnuale ") public
		 * Page<Customer> orderByFatturatoAnnuale();
		 */
		
	}

}
