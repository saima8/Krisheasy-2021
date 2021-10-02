package Krisheasy.Krisheasy.Krisheasy.Nasa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {
	
	@Id
	@GeneratedValue
	private int imageId;
	private String imageName;
	private String imageLocation;
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	public Image(int imageId, String imageName, String imageLocation) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageLocation = imageLocation;
	}
	public Image() {
		super();
	}
	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imageName=" + imageName + ", imageLocation=" + imageLocation + "]";
	}
	

}
