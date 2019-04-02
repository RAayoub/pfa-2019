package config;

import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.tags.MessageTag;

import ma.ensa.entities.Administrateur;
import ma.ensa.entities.Cellule;
import ma.ensa.entities.Classe;
import ma.ensa.entities.Cours;
import ma.ensa.entities.Document;
import ma.ensa.entities.Ecole;
import ma.ensa.entities.Etudiant;
import ma.ensa.entities.Examen;
import ma.ensa.entities.Filiere;
import ma.ensa.entities.Interet;
import ma.ensa.entities.Matiere;
import ma.ensa.entities.Message;
import ma.ensa.entities.MessageAjout;
import ma.ensa.entities.MessageText;
import ma.ensa.entities.Photo;
import ma.ensa.entities.Question;
import ma.ensa.entities.Reponse;
import ma.ensa.entities.TravauxDerige;
import ma.ensa.entities.Video;



@Configuration
@ComponentScan("ma.ensa.dao,ma.ensa.service")
@EnableTransactionManagement
public class AppConfig {
		
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/prepaplatform");
	    dataSource.setUsername("root");
	    dataSource.setPassword("");
	    return dataSource;
	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setHibernateProperties(getHibernateProperties());
        sessionFactory.setAnnotatedClasses(new Class[]{
        	Administrateur.class,
        	Cellule.class,
        	Classe.class,
        	Cours.class,
        	Document.class,
        	Ecole.class,
        	Etudiant.class,
        	Examen.class,
        	Filiere.class,
        	Interet.class,
        	Matiere.class,
        	Message.class,
        	MessageAjout.class,
        	MessageText.class,
        	Photo.class,
        	Question.class,
        	Reponse.class,
        	TravauxDerige.class,
        	Video.class
        		});
        return sessionFactory;
     }
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.hbm2ddl.auto","create");
	    properties.put("hibernate.show_sql","true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}
	
	//@Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
	
}
