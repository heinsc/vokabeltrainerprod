package de.heins.vokabeltraineronline.web.entities.attributereference;

public class QuestionWithAnswerAttrRef {
	private String question;
	private String answer;
	private String indexBoxDescription;
	private String learningStrategyDescription;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getIndexBoxDescription() {
		return indexBoxDescription;
	}
	public void setIndexBoxDescription(String indexBoxDescription) {
		this.indexBoxDescription = indexBoxDescription;
	}
	public String getLearningStrategyDescription() {
		return learningStrategyDescription;
	}
	public void setLearningStrategyDescription(String learningStrategyDescription) {
		this.learningStrategyDescription = learningStrategyDescription;
	}
}
