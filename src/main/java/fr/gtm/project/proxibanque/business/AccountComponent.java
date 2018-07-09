package fr.gtm.project.proxibanque.business;

import fr.gtm.project.proxibanque.entity.Account;
import fr.gtm.project.proxibanque.entity.Message;

public class AccountComponent {

	public Message validateAccountCreation(Account account) {
		final Message result = new Message(
				"Le nouveau compte a bien été créé !");
		// TODO
		return result;
	}
}
