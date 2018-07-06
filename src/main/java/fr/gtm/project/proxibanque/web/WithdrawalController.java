package fr.gtm.project.proxibanque.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/{id}/retrait")
public class WithdrawalController {

	@RequestMapping("/espece")
	public ModelAndView cashWithdrawal(@PathVariable Integer id) {
		final ModelAndView mav = new ModelAndView("withdrawal/cash");
		return mav;
	}

	@RequestMapping("/cartebleue")
	public ModelAndView cbWithdrawal(@PathVariable Integer id) {
		final ModelAndView mav = new ModelAndView("withdrawal/bankcard");
		return mav;
	}

	@RequestMapping("/chequier")
	public ModelAndView checkWithdrawal(@PathVariable Integer id) {
		final ModelAndView mav = new ModelAndView("withdrawal/checkbook");
		return mav;
	}
}
