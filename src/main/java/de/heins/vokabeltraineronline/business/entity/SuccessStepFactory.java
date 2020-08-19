package de.heins.vokabeltraineronline.business.entity;

import org.springframework.stereotype.Component;

@Component
public class SuccessStepFactory {
    private Long id;

    private String name;
    
	private int nextAppearanceInDays;
	
	private BehaviourIfWrong behaviourIfWrong;
	private AppUser appUser;
    public SuccessStepFactory() {
    }

	public SuccessStepFactory setId(Long id) {
		this.id = id;
		return this;
	}
	public SuccessStepFactory setName(String name) {
		this.name = name;
		return this;
	}
		public SuccessStepFactory setNextAppearanceInDays(int durationOfNextAppearance) {
		this.nextAppearanceInDays = durationOfNextAppearance;
		return this;
	}
	public SuccessStepFactory setBehaviourIfWrong(BehaviourIfWrong behaviourIfWrong) {
		this.behaviourIfWrong = behaviourIfWrong;
		return this;
	}

	public SuccessStepFactory setAppUser(AppUser appUser) {
		this.appUser=appUser;
		return this;
	}
    public SuccessStep getNewObject() {
    	return new SuccessStep(//
    			this.id//
    			, this.name//
    			, this.nextAppearanceInDays//
    			, this.behaviourIfWrong//
    			, this.appUser//
    	);
	}


}
