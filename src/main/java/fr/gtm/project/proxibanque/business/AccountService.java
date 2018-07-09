package fr.gtm.project.proxibanque.business;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.project.proxibanque.entity.Account;
import fr.gtm.project.proxibanque.entity.Message;
import fr.gtm.project.proxibanque.entity.TYPE_CARD;

public class AccountService extends CrudService<Account> {

	@Autowired
	private WithdrawalComponent withdrawalComp;

	public Message transferInternal(Integer idAccount, Float amount) {
		// TODO
		return new Message("Virement effectué avec succès !");
	}

	public Message withdrawCash(Integer idAccount, Float amount) {
		return this.withdrawalComp.processCash(this.read(idAccount), amount);
	}

	public Message withdrawBankCard(Integer idAccount, TYPE_CARD type) {
		return this.withdrawalComp.processBankCard(this.read(idAccount), type);
	}

	public Message withdrawCheckBook(Integer idAccount) {
		return this.withdrawalComp.processCheckBook(this.read(idAccount));
	}
}
