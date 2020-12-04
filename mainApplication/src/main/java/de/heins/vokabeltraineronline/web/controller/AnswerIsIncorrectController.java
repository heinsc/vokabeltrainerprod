package de.heins.vokabeltraineronline.web.controller;


import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AnswerIsIncorrectController {
	private static enum Constants {
		answerIsIncorrectPage
	}
	public AnswerIsIncorrectController() {
		super();
	}

	@RequestMapping("/controlPageAnswerIsIncorrect")
	public String showAnswerIsIncorrectPage(//
			StandardSessionFacade session//
	) throws Exception {
		return Constants.answerIsIncorrectPage.name();

	}

	@RequestMapping(value = "/controlActionAnswerIsIncorrect", method = RequestMethod.POST, params = {"submit"})
	public String submit() throws Exception {	return "redirect:" + ControllerConstants.controlPageLearnDoLearn.name();

}


}