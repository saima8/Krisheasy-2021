package Krisheasy.Krisheasy.Krisheasy.Nasa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalAgriculturalOfficeRepository extends CrudRepository<LocalAgriculturalOffice, Long> {
	
	
	List<LocalAgriculturalOffice> findByLastName(String lastName);

	LocalAgriculturalOffice findById(long id);

}
