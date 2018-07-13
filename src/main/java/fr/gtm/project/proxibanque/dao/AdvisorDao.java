package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.project.proxibanque.entity.Advisor;

public interface AdvisorDao extends JpaRepository <Advisor, Integer> {
	
	/**
	 * Recuperation du conseiller par sin login 
	 * 
	 * @param login le login recherché
	 * @return Advisor le conseillé trouvé ou null
	 */
	Advisor findOneByLogin(final String login) ;

}
