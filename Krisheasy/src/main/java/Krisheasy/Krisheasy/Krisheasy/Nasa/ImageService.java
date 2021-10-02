package Krisheasy.Krisheasy.Krisheasy.Nasa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImageService {
	
	@Autowired
	private ImageRepository repo;
	 public List<Image> listAll() {
	        return (List<Image>) repo.findAll();
	    }
	     
	    public void save(Image image) {
	        repo.save(image);
	    }
	     
	    public Image get(long id) {
	        return repo.findById(id);
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }

}
