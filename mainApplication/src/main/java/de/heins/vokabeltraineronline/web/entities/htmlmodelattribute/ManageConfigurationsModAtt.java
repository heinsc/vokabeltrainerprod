package de.heins.vokabeltraineronline.web.entities.htmlmodelattribute;

import java.util.List;

import de.heins.vokabeltraineronline.web.entities.attributereference.IndexBoxAttrRef;
import de.heins.vokabeltraineronline.web.entities.attributereference.LearnProfileAttrRef;
import de.heins.vokabeltraineronline.web.entities.attributereference.LearningStrategyAttrRef;
import de.heins.vokabeltraineronline.web.entities.attributereference.SuccessStepAttrRef;

public class ManageConfigurationsModAtt {
	private List<IndexBoxAttrRef> allIndexBoxes;
	private List<LearningStrategyAttrRef> allLearningStrategies;
	private List<SuccessStepAttrRef> allSuccessSteps;
	private LearnProfileAttrRef learnProfile;

	public List<IndexBoxAttrRef> getAllIndexBoxes() {
		return allIndexBoxes;
	}

	public void setAllIndexBoxes(List<IndexBoxAttrRef> allIndexBoxes) {
		this.allIndexBoxes = allIndexBoxes;
	}

	public List<LearningStrategyAttrRef> getAllLearningStrategies() {
		return allLearningStrategies;
	}

	public void setAllLearningStrategies(List<LearningStrategyAttrRef> allLearningStrategies) {
		this.allLearningStrategies = allLearningStrategies;
	}

	public List<SuccessStepAttrRef> getAllSuccessSteps() {
		return allSuccessSteps;
	}

	public void setAllSuccessSteps(List<SuccessStepAttrRef> allSuccessSteps) {
		this.allSuccessSteps = allSuccessSteps;
	}

	public LearnProfileAttrRef getLearnProfile() {
		return learnProfile;
	}

	public void setLearnProfile(LearnProfileAttrRef learnProfile) {
		this.learnProfile = learnProfile;
	}

}
