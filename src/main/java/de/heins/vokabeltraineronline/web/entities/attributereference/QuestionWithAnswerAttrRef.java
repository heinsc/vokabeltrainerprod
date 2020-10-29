package de.heins.vokabeltraineronline.web.entities.attributereference;

public class QuestionWithAnswerAttrRef {
	private String question;
	private String answer;
	/*
	 * the index box description is only used in createQuestionsWithAnswersPage and manageQuestionsWithAnswersPage
	 */
	private String indexBoxDescription;
	private String learningStrategyDescription;
	/*
	 * the learningProgress is only used in manageQuestionsWithAnswersPage
	 */
	private String learningProgress;
	/*
	 * the filter is only used in manageQuestionsWithAnswersPage
	 * for deleting or moving several items at once.
	 */
	private boolean filterOn;
	/*
	 * the answer by user is only used in LearnDoLearn
	 */
	private String answerByUser;
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
	public boolean isFilterOn() {
		return filterOn;
	}
	public void setFilterOn(boolean filterOn) {
		this.filterOn = filterOn;
	}
	public String getLearningProgress() {
		return learningProgress;
	}
	public void setLearningProgress(String actualSuccessStepDescription) {
		this.learningProgress = actualSuccessStepDescription;
	}
	public String getAnswerByUser() {
		return answerByUser;
	}
	public void setAnswerByUser(String answerByUser) {
		this.answerByUser = answerByUser;
	}
}
