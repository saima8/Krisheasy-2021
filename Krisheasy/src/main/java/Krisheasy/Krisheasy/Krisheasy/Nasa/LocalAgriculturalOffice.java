package Krisheasy.Krisheasy.Krisheasy.Nasa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LocalAgriculturalOffice {
	@Id
	@GeneratedValue
	private int laoId;

	public int getLaoId() {
		return laoId;
	}

	public void setLaoId(int laoId) {
		this.laoId = laoId;
	}

	public LocalAgriculturalOffice() {
		super();
	}

	public LocalAgriculturalOffice(int laoId) {
		super();
		this.laoId = laoId;
	}

	@Override
	public String toString() {
		return "LocalAgriculturalOffice [laoId=" + laoId + "]";
	}
	

}
