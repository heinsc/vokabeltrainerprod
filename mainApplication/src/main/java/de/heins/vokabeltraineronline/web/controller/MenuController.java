package de.heins.vokabeltraineronline.web.controller;

import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
	private static enum Constants {
		menuPage
	}
	public MenuController() {
		super();
	}

	@RequestMapping("/controlPageMenu")
	public String showMenuPage(//
			Model model//
			, StandardSessionFacade session//
	) throws Exception {
		return Constants.menuPage.name();

	}
	@RequestMapping(value = "/controlActionMenu", method = RequestMethod.POST, params = {"manageConfigurations"})
	public String manageConfigurations() throws Exception {
		// direct link to ManangeConfigurationsController
		return "redirect:" + ControllerConstants.controlPageManageConfigurations.name();

	}
	@RequestMapping(value = "/controlActionMenu", method = RequestMethod.POST, params = {"learn"})
	public String learn() throws Exception {
		// direct link to ManangeConfigurationsController
		return "redirect:" + ControllerConstants.controlPageLearnFilterIndexBoxes.name();

	}
	@RequestMapping(value = "/controlActionMenu", method = RequestMethod.POST, params = {"manageQuestionsWithAnswers"})
	public String manageQuestionsWithAnswers() throws Exception {
		// direct link to ManangeConfigurationsController
		return "redirect:" + ControllerConstants.controlPageManageQuestionsWithAnswers.name();

	}
	@RequestMapping(value = "/controlActionMenu", method = RequestMethod.POST, params = {"editAppUser"})
	public String editAppUser() throws Exception {
		// direct link to ManangeAppUserController
		return "redirect:" + ControllerConstants.controlPageEditAppUser.name();

	}
	@RequestMapping(value = "/controlActionMenu", method = RequestMethod.POST, params = {"deleteAppUser"})
	public String deleteAppUser() throws Exception {
		//direct Link to DeleteAppUserController
		return "redirect:" + ControllerConstants.controlPageDeleteAppUser.name();

	}
	@RequestMapping(value = "/controlActionMenu", method = RequestMethod.POST, params = {"logout"})
	public String logout() throws Exception {
		//direct Link to DeleteAppUserController
		return "redirect:" + ControllerConstants.controlPageLogin.name();
	}


}