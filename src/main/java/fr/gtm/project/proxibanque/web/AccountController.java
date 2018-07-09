package fr.gtm.project.proxibanque.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.project.proxibanque.business.AccountService;
import fr.gtm.project.proxibanque.entity.Account;
import fr.gtm.project.proxibanque.entity.Message;

@Controller
@RequestMapping("/compte")
@SessionAttributes({ "accounts" })
public class AccountController {

	@Autowired
	private AccountService accountService;

	@ModelAttribute
	public List<Account> accounts() {
		return new ArrayList<>();
	}

	@RequestMapping("/creation")
	public ModelAndView prepareForm() {
		final ModelAndView mav = new ModelAndView("new-account");
		mav.addObject("accounts", this.accountService.getList());
		return mav;
	}

	@PostMapping("/creation")
	public String validateForm(Float balance, String label, String number,
			Model model) {
		final Message result = this.accountService.create(balance, label,
				number);
		model.addAttribute("result", result);
		return "creation";
	}
}
