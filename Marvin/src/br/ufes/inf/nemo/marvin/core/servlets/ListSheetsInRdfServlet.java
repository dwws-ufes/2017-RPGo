package br.ufes.inf.nemo.marvin.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import br.ufes.inf.nemo.marvin.core.domain.RPGCharacter;
import br.ufes.inf.nemo.marvin.core.persistence.RPGCharacterDAO;

/**
 * Servlet implementation class ListSheetsInRdfServlet
 */
@WebServlet(urlPatterns = { "/data/charactersheets" })
public class ListSheetsInRdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ListSheetsInRdfServlet.class.getCanonicalName());
	
	@EJB
	private RPGCharacterDAO rpgCharacterDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSheetsInRdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		
		List<RPGCharacter> sheets = rpgCharacterDAO.retrieveAll();

		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/Marvin/data/CharacterSheet/";
		String dbNS = "http://dbpedia.org/onthology/";
		model.setNsPrefix("db", dbNS);
		
		Resource dbFictionalCharacter = ResourceFactory.createResource(dbNS + "FictionalCharacter");
		Property dbCharacteristics = ResourceFactory.createProperty(dbNS + "Characteristic");
		Property dbStatus = ResourceFactory.createProperty(dbNS + "Status");
		Property dbHorror = ResourceFactory.createProperty(dbNS + "Fear");
		Property dbAchievements = ResourceFactory.createProperty(dbNS + "Achievement");

		for (RPGCharacter sheet : sheets) {
			model.createResource(myNS + sheet.getId())
				.addProperty(RDF.type, dbFictionalCharacter)
				.addProperty(RDFS.label, sheet.getName())
				.addProperty(RDFS.comment, sheet.getImpactQuote())
				.addProperty(dbCharacteristics, sheet.getTraits())
				.addProperty(dbStatus, sheet.getConditions())
				.addProperty(dbHorror, sheet.getHorror())
				.addProperty(dbAchievements, sheet.getTrumps());
			
			logger.log(Level.INFO, "Added RPGCharacter/" + sheet.getId() + " to the RDF model");
			
		}
		
		try (PrintWriter out = response.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
