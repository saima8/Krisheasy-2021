package Krisheasy.Krisheasy.Krisheasy.Nasa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Farmer {
	
	@Id
	@GeneratedValue
	private int farmerid;
	private String farmerName;
	private String farmeraddress;
	
	protected Farmer() {}

	public int getFarmerid() {
		return farmerid;
	}

	public void setFarmerid(int farmerid) {
		this.farmerid = farmerid;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmeraddress() {
		return farmeraddress;
	}

	public void setFarmeraddress(String farmeraddress) {
		this.farmeraddress = farmeraddress;
	}

	@Override
	public String toString() {
		return "Farmer [farmerid=" + farmerid + ", farmerName=" + farmerName + ", farmeraddress=" + farmeraddress + "]";
	}

	public Farmer(int farmerid, String farmerName, String farmeraddress) {
		super();
		this.farmerid = farmerid;
		this.farmerName = farmerName;
		this.farmeraddress = farmeraddress;
	}

	
	
}
