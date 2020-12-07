package de.heins.vokabeltraineronline.web.controller;


import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.heins.vokabeltraineronline.business.service.QuestionWithAnswerService;
import de.heins.vokabeltraineronline.web.entities.PoolWithWrongAnswers;
import de.heins.vokabeltraineronline.web.entities.SessionAppUser;
import de.heins.vokabeltraineronline.web.entities.StockOfAllQuestionsWithAnswers;
import de.heins.vokabeltraineronline.web.entities.attributereference.QuestionWithAnswerAttrRef;


@Controller
public class DeclareCorrectDespiteErrorsController {
	private static enum Constants {
		declareCorrectDespiteErrorsPage
	}
	@Autowired
	private LearnDoLearnController learnDoLearnController;
	@Autowired
	private QuestionWithAnswerService questionWithAnswerService;
	public DeclareCorrectDespiteErrorsController() {
		super();
	}

	public String showDeclareCorrectDespiteErrorsPage(//
			StandardSessionFacade session//
	) throws Exception {
		return Constants.declareCorrectDespiteErrorsPage.name();

	}

	@RequestMapping(value = "/controlActionDeclareCorrectDespiteErrors", method = RequestMethod.POST, params = {"declareCorrect"})
	public String declareAsCorrect(//
			Model model//
			, StandardSessionFacade session
	) throws Exception {
		QuestionWithAnswerAttrRef questionWithAnswerAttrRef//
			= (QuestionWithAnswerAttrRef)session.getAttribute(//
					ControllerConstants.sessionQuestionWithAnswerAttrRef.name()//
			);
		SessionAppUser sessionAppUser = (SessionAppUser) session.getAttribute(//
				ControllerConstants.sessionAppUser.name()//
		);
		PoolWithWrongAnswers pool = (PoolWithWrongAnswers) session.getAttribute(//
				ControllerConstants.sessionPoolWithWrongAnswers.name()//
		);
		StockOfAllQuestionsWithAnswers stock = (StockOfAllQuestionsWithAnswers) session.getAttribute(//
				ControllerConstants.sessionStockOfAllQuestionsWithAnswers.name()//
		);
		questionWithAnswerService.markAsAnsweredCorrectAndSave(//
				questionWithAnswerAttrRef//
				, sessionAppUser//
				, pool//
				, stock//
		);
		return learnDoLearnController.showLearnDoLearnPage(model, session);
	}
	@RequestMapping(value = "/controlActionDeclareCorrectDespiteErrors", method = RequestMethod.POST, params = {"declareIncorrect"})
	public String declareAsIncorrect(//
			Model model//
			, StandardSessionFacade session
			) throws Exception {
		QuestionWithAnswerAttrRef sessionQuestionWithAnswerAttrRef//
		= (QuestionWithAnswerAttrRef)session.getAttribute(//
				ControllerConstants.sessionQuestionWithAnswerAttrRef.name()//
		);
	SessionAppUser sessionAppUser = (SessionAppUser) session.getAttribute(ControllerConstants.sessionAppUser.name());
	PoolWithWrongAnswers poolOfQuestionsWithIncorrectAnswer = (PoolWithWrongAnswers) session.getAttribute(//
			ControllerConstants.sessionPoolWithWrongAnswers.name()//
	);
	StockOfAllQuestionsWithAnswers stockOfAllNonAskedQuestions = (StockOfAllQuestionsWithAnswers) session.getAttribute(//
			ControllerConstants.sessionStockOfAllQuestionsWithAnswers.name()//
	);
	questionWithAnswerService.markAsAnsweredIncorrectlyAndSave(//
			sessionQuestionWithAnswerAttrRef//
			, sessionAppUser//
			, stockOfAllNonAskedQuestions//
			, poolOfQuestionsWithIncorrectAnswer//
	);
	return learnDoLearnController.showLearnDoLearnPage(model, session);
}


}