package de.heins.vokabeltraineronline.web.controller;

import java.util.List;

import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.heins.vokabeltraineronline.business.service.LearnProfileService;
import de.heins.vokabeltraineronline.web.entities.SessionAppUser;
import de.heins.vokabeltraineronline.web.entities.attributereference.LearnProfileAttrRef;
import de.heins.vokabeltraineronline.web.entities.htmlmodelattribute.EditLearnProfileModAtt;

@Controller
public class EditLearnProfileController {
	private static enum Constants {
		editLearnProfilePage//
		, editLearnProfileModAtt//
	}
	@Autowired
	private ManageConfigurationsController manageConfigurationsController;
	@Autowired
	private LearnProfileService learnProfileService;

	public EditLearnProfileController() {
		super();
	}

	public String showEditLearnProfilePage(//
			Model model//
			, StandardSessionFacade session//
	) {
		SessionAppUser sessionAppUser = (SessionAppUser) session.getAttribute(//
				ControllerConstants.sessionAppUser.name()//
		);
		EditLearnProfileModAtt editLearnProfileModAtt = new EditLearnProfileModAtt();
		learnProfileService.findLearnProfileByUser(sessionAppUser);
		List<String> selectableBehavioursIfPoolWithWrongAnswersIsFull = learnProfileService.getAllBehavioursIfPoolWithWrongAnswersIsFullAsStringArray();
		editLearnProfileModAtt.setSelectableBehavioursIfPoolWithWrongAnswersIsFull(selectableBehavioursIfPoolWithWrongAnswersIsFull);
		LearnProfileAttrRef learnProfile = learnProfileService.findLearnProfileByUser(sessionAppUser);
		editLearnProfileModAtt.setLearnProfile(learnProfile);
		model.addAttribute(//
				Constants.editLearnProfileModAtt.name()//
				, editLearnProfileModAtt//
		);
		return Constants.editLearnProfilePage.name();
	}

	@RequestMapping(value="/controlActionEditLearnProfile", method=RequestMethod.POST, params= {"submit"})
	public String submit(//
			Model model//
			, StandardSessionFacade session//
			, @ModelAttribute(name = "editLearnProfileModAtt")
			EditLearnProfileModAtt editLearnProfileModAtt
	) {
		SessionAppUser sessionAppUser = (SessionAppUser)session.getAttribute(//
				ControllerConstants.sessionAppUser.name()//
		);
		learnProfileService.updateLearnProfile(//
				sessionAppUser//
				, editLearnProfileModAtt.getLearnProfile().getMaxNumberOfWrongAnswersPerSession()//
				, editLearnProfileModAtt.getLearnProfile().getBehaviourIfPoolWithWrongAnswersIsFull()//
		);
		return manageConfigurationsController.showManageConfigurationsPage(model, session);
	}
	@RequestMapping(value="/controlActionEditLearnProfile", method=RequestMethod.POST, params= {"cancel"})
	public String cancel(Model model, StandardSessionFacade session) {
		return manageConfigurationsController.showManageConfigurationsPage(model, session);
		
	}

}
