package Krisheasy.Krisheasy.Krisheasy.Nasa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FarmerService {
	
	@Autowired
	private FarmerRepository repo;
	 public List<Farmer> listAll() {
	        return (List<Farmer>) repo.findAll();
	    }
	     
	    public void save(Farmer farmer) {
	        repo.save(farmer);
	    }
	     
	    public Farmer get(long id) {
	        return repo.findById(id);
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }

}
