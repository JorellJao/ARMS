package ph.com.alliance.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the questions database table.
 * 
 */
@Embeddable
public class QuestionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="correct_answer_id")
	private int correctAnswerId;

	@Column(name="exam_id")
	private int examId;

	private String id;

	public QuestionPK() {
	}
	public int getCorrectAnswerId() {
		return this.correctAnswerId;
	}
	public void setCorrectAnswerId(int correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}
	public int getExamId() {
		return this.examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuestionPK)) {
			return false;
		}
		QuestionPK castOther = (QuestionPK)other;
		return 
			(this.correctAnswerId == castOther.correctAnswerId)
			&& (this.examId == castOther.examId)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.correctAnswerId;
		hash = hash * prime + this.examId;
		hash = hash * prime + this.id.hashCode();
		
		return hash;
	}
}