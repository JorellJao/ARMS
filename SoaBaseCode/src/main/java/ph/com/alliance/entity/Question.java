package ph.com.alliance.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuestionPK id;

	@Column(name="question_label")
	private String questionLabel;

	public Question() {
	}

	public QuestionPK getId() {
		return this.id;
	}

	public void setId(QuestionPK id) {
		this.id = id;
	}

	public String getQuestionLabel() {
		return this.questionLabel;
	}

	public void setQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
	}

}