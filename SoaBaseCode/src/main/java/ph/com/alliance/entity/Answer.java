package ph.com.alliance.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answer database table.
 * 
 */
@Entity
@Table(name="answers")
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AnswerPK id;

	@Column(name="answer_label")
	private String answerLabel;

	public Answer() {
	}

	public AnswerPK getId() {
		return this.id;
	}

	public void setId(AnswerPK id) {
		this.id = id;
	}

	public String getAnswerLabel() {
		return this.answerLabel;
	}

	public void setAnswerLabel(String answerLabel) {
		this.answerLabel = answerLabel;
	}

}