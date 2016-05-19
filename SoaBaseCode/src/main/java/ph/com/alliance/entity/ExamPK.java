package ph.com.alliance.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the exam database table.
 * 
 */
@Embeddable
public class ExamPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	public ExamPK() {
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ExamPK)) {
			return false;
		}
		ExamPK castOther = (ExamPK)other;
		return 
			(this.id == castOther.id)
			&& this.name.equals(castOther.name);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.name.hashCode();
		
		return hash;
	}
}