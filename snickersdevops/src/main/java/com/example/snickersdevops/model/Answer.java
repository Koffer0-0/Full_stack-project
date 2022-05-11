package com.example.snickersdevops.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "answer")
public class Answer extends BaseModel implements UserOwned {

	@Size(min = 1, max = 50, message = "The answer should be less than 50 characters")
	@NotNull(message = "No answer text provided.")
	private String text;

	@ManyToOne
	@JsonIgnore
	private Question question;

	@Column(name = "a_order")
	private Integer order;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Calendar createdDate;

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	@JsonIgnore
	public User getUser() {
		return question.getUser();
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Answer [text=" + text + ", question=" + question + ", order=" + order + ", createdDate=" + createdDate
				+ "]";
	}

}
