package fr.gtm.project.proxibanque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"fr.gtm.project.proxibanque.web","fr.gtm.project.proxibanque.business"})
@EnableJpaRepositories ("fr.gtm.project.proxibanque.dao")
public class MvcConfig {
	
	@Bean 
	public InternalResourceViewResolver viewResolver() {  // Declaration d'un bean
		final InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp") ;
		vr.setViewClass(JstlView.class) ;
		return vr ; 
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean()  ; 
		lcemfb.setPersistenceUnitName("proxibanque");
		return lcemfb ; 
	}
	
	@Bean 
	public PlatformTransactionManager transactionManager() {
		final JpaTransactionManager tm = new JpaTransactionManager() ;
		tm.setEntityManagerFactory(this.entityManagerFactory().getObject());
		return tm ; 
	}

}
