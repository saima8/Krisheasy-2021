package Krisheasy.Krisheasy.Krisheasy.Nasa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
	 List<Image> findByLastName(String lastName);

	 Image findById(long id);

}
