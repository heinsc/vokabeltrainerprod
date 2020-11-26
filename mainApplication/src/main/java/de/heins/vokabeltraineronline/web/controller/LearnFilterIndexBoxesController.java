package de.heins.vokabeltraineronline.web.controller;

import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.heins.vokabeltraineronline.business.service.IndexBoxService;
import de.heins.vokabeltraineronline.web.entities.IndexBoxes;
import de.heins.vokabeltraineronline.web.entities.SessionAppUser;
import de.heins.vokabeltraineronline.web.entities.attributereference.IndexBoxAttrRef;
import de.heins.vokabeltraineronline.web.entities.htmlmodelattribute.LearnFilterIndexBoxesModAtt;

@Controller
public class LearnFilterIndexBoxesController {
	private static enum Constants {
		learnFilterIndexBoxesPage
	}
	@Autowired
	private IndexBoxService indexBoxService;
	public LearnFilterIndexBoxesController() {
		super();
	}

	@RequestMapping("/controlPageLearnFilterIndexBoxes")
	public String showLearnFilterIndexBoxesPage(//
			Model model//
			, StandardSessionFacade session//
	) throws Exception {
		SessionAppUser sessionAppUser = (SessionAppUser)session.getAttribute(//
				ControllerConstants.sessionAppUser.name()//
		);
		LearnFilterIndexBoxesModAtt learnFilterIndexBoxesModAtt = new LearnFilterIndexBoxesModAtt();
		model.addAttribute("learnFilterIndexBoxesModAtt", learnFilterIndexBoxesModAtt);
		IndexBoxes indexBoxAttrRefList = indexBoxService.findAllForAppUser(sessionAppUser);
		session.setAttribute(ControllerConstants.sessionIndexBoxAttrRefList.name(), indexBoxAttrRefList);
		return Constants.learnFilterIndexBoxesPage.name();

	}
	@RequestMapping(value = "/controlActionLearnFilterIndexBoxes", method = RequestMethod.POST, params = {"learn"})
	public String learn(
			StandardSessionFacade session
	) throws Exception {
		session.setAttribute(ControllerConstants.sessionPoolWithWrongAnswers.name(), null);
		session.setAttribute(ControllerConstants.sessionStockOfAllQuestionsWithAnswers.name(), null);
		return "redirect:" + ControllerConstants.controlPageLearnDoLearn.name();

	}
	@RequestMapping(value = "/controlActionLearnFilterIndexBoxes", method = RequestMethod.POST, params = {"cancel"})
	public String cancel() throws Exception {
		return "redirect:" + ControllerConstants.controlPageMenu.name();

	}
	@RequestMapping(value = "/controlActionLearnFilterIndexBoxes", method = RequestMethod.POST, params = {"logout"})
	public String logout() throws Exception {
		return "redirect:" + ControllerConstants.controlPageLogin.name();
	}

	@RequestMapping({"controlLinkAddIndexBoxToFilterOnLearningPage"})
	public String addIndexBoxToFilter(//
			@RequestParam(name = "index", required = false, defaultValue = "")
	        int index//
	        , Model model//
			, StandardSessionFacade session//
	) throws Exception {
		LearnFilterIndexBoxesModAtt learnFilterIndexBoxesModAtt = new LearnFilterIndexBoxesModAtt();
		model.addAttribute("learnFilterIndexBoxesModAtt", learnFilterIndexBoxesModAtt);
		IndexBoxes indexBoxAttrRefList = (IndexBoxes) session.getAttribute(//
				ControllerConstants.sessionIndexBoxAttrRefList.name()//
		);
		IndexBoxAttrRef indexBox = indexBoxAttrRefList.get(index);
		indexBox.setFilterOn(true);
		
		return Constants.learnFilterIndexBoxesPage.name();
	}

	@RequestMapping({"controlLinkRemoveIndexBoxFromFilterOnLearningPage"})
	public String removeIndexBoxFromFilter(//
			@RequestParam(name = "index", required = false, defaultValue = "")
	        int index//
	        , Model model//
			, StandardSessionFacade session//
	) throws Exception {
		LearnFilterIndexBoxesModAtt learnFilterIndexBoxesModAtt = new LearnFilterIndexBoxesModAtt();
		model.addAttribute("learnFilterIndexBoxesModAtt", learnFilterIndexBoxesModAtt);
		IndexBoxes indexBoxAttrRefList = (IndexBoxes) session.getAttribute(ControllerConstants.sessionIndexBoxAttrRefList.name());
		IndexBoxAttrRef indexBox = indexBoxAttrRefList.get(index);
		indexBox.setFilterOn(false);
		
		return Constants.learnFilterIndexBoxesPage.name();
	}


}