package Krisheasy.Krisheasy.Krisheasy.Nasa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FarmerRepository extends CrudRepository<Farmer, Long> {
	 List<Farmer> findByName(String name);

	 Farmer findById(long id);
}
