package fr.gtm.project.proxibanque.web;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.entity.Client;

@Controller
public class IndexController {

	@Autowired
	private ClientService service;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/dashboard/{id}")
	public ModelAndView dashboard(@PathVariable("id") Integer clientId) {
		final ModelAndView mav = new ModelAndView("dashboard");
		mav.addObject("client", this.service.read(clientId));
		return mav;
	}

	@PostMapping("/index")
	public ModelAndView search(@RequestParam String keywords) {
		final ModelAndView mav = new ModelAndView("index");
		final Integer id = this.service.findClient(keywords);
		if (id != null) {
			mav.addObject("searchId", id);
		} else {
			mav.setViewName("errors/generic");
			mav.addObject("message",
					"Aucun résultat, veuillez vous adresser à un conseiller.");
		}
		return mav;
	}

	@PostMapping("/{id}/validate")
	public ModelAndView validate(@PathVariable("id") Integer searchId,
			@RequestParam("birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthDate) {
		final Client client = this.service.validateClient(searchId, birthDate);
		if (client != null) {
			return new ModelAndView(
					"redirect:/dashboard/" + client.getId() + ".html");
		} else {
			final ModelAndView mav = new ModelAndView("errors/generic");
			mav.addObject("message",
					"Aucun résultat, veuillez vous adresser à un conseiller.");
			return mav;
		}
	}
}
