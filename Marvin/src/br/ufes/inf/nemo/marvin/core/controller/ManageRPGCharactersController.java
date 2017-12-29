package br.ufes.inf.nemo.marvin.core.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.marvin.core.application.ManageRPGCharactersService;
import br.ufes.inf.nemo.marvin.core.domain.RPGCharacter;

@Named
@SessionScoped
public class ManageRPGCharactersController extends CrudController<RPGCharacter> {
	private static final long serialVersionUID = 1L;
	
	String webDescription;
	
	@EJB
	private ManageRPGCharactersService manageRPGCharactersService;
	
	@Override
	protected CrudService<RPGCharacter> getCrudService() {
		return manageRPGCharactersService;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageRPGCharacters.filter.byName", "name", getI18nMessage("msgsCore", "manageRPGCharacters.text.filter.byName")));
		addFilter(new LikeFilter("manageRPGCharacters.filter.byPlayerName", "playerName", getI18nMessage("msgsCore", "manageRPGCharacters.text.filter.byPlayerName")));
	}

	public void suggestDescription() {
		String name = selectedEntity.getName();
		System.out.println("Searching for " + name);
		if (name != null && name.length() > 3) {
			String query = "PREFIX dbo: <http://dbpedia.org/ontology/> " 
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "SELECT ?desc " + "WHERE { "
					+ "?x a dbo:FictionalCharacter ; " 
					+ "rdfs:label ?name ;" 
					+ "dbo:abstract ?desc . " 
					+ "FILTER (?name =\"" + name + "\"@en) " 
					+ "FILTER (langMatches(lang(?desc),\"EN\")) " + "}";
			QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
			ResultSet results = queryExecution.execSelect();
			if (results.hasNext()) {
				QuerySolution querySolution = results.next();
				Literal literal = querySolution.getLiteral("desc");
				
				FacesContext context = FacesContext.getCurrentInstance();
				
				String shortDescription;
				
				if(literal.getString().length() > 750) {
					int lastDotIndex = literal.getString().lastIndexOf('.', 750);
					shortDescription = literal.getString().substring(0, lastDotIndex + 1);
				}
				else
					shortDescription = literal.getString();
				
		        context.addMessage(null, new FacesMessage("About your character",  "Taken from WEB: " + shortDescription) );
		        
				System.out.println("Done for " + name + ": " + literal.getValue());
			}
		}
	}	
}
