package ph.com.alliance.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exam database table.
 * 
 */
@Entity
@Table(name="exam")
@NamedQuery(name="Exam.findAll", query="SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ExamPK id;

	public Exam() {
	}

	public ExamPK getId() {
		return this.id;
	}

	public void setId(ExamPK id) {
		this.id = id;
	}

}