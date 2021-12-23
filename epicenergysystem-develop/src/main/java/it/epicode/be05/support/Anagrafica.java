package it.epicode.be05.support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.epicode.be05.Impl.MunicipalityImpl;
import it.epicode.be05.Impl.ProvinceImpl;
import it.epicode.be05.Repo.AddressRepo;
import it.epicode.be05.Repo.ProvinceRepo;
import it.epicode.be05.Service.ProvinceService;
import it.epicode.be05.model.Address;
import it.epicode.be05.model.Municipality;
import it.epicode.be05.model.Province;

@Component
public class Anagrafica {

	@Autowired
	ProvinceRepo ps;

	@Autowired
	MunicipalityImpl c;

	@Autowired
	AddressRepo r;

	public void readFile() throws IOException {
		String line = "";
		String line1 = "";

		BufferedReader br1 = new BufferedReader(new FileReader("src/main/resources/static/comuni.csv"));
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/province.csv"));
		while ((line = br.readLine()) != null) {

			// Pulisco file provincie.csv
			String[] cols = line.split(";");

			// Popolo Entity
			var provi = Province.builder().nameProvince(cols[1]).sigla(cols[0]).build();

			// Popolo database
			ps.save(provi);
		}
		
		
		//line1 = br1.readLine();

		while ((line1 = br1.readLine()) != null) {
			String[] cols1 = line1.split(";");
			if (cols1.length == 4) {
				var comune = Municipality.builder().denomination_in_italy(cols1[2])
						.pro(ps.findByNameProvince(cols1[3])).build();

				c.create(comune);
			}

		}
	}
}
