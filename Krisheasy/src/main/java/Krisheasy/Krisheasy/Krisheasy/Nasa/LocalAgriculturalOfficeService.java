package Krisheasy.Krisheasy.Krisheasy.Nasa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class LocalAgriculturalOfficeService {
	
	@Autowired
	private LocalAgriculturalOfficeRepository repo;
	 public List<LocalAgriculturalOffice> listAll() {
	        return (List<LocalAgriculturalOffice>) repo.findAll();
	    }
	     
	    public void save(LocalAgriculturalOffice localAgriculturalOffice) {
	        repo.save(localAgriculturalOffice);
	    }
	     
	    public LocalAgriculturalOffice get(long id) {
	        return repo.findById(id);
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }

}
