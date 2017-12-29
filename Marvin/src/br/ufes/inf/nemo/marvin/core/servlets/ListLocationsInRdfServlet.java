package br.ufes.inf.nemo.marvin.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

import br.ufes.inf.nemo.marvin.core.domain.RPGLocation;
import br.ufes.inf.nemo.marvin.core.persistence.RPGLocationDAO;

/**
 * Servlet implementation class ListLocationsInRdfServlet
 */
@WebServlet("/ListLocationsInRdfServlet")
public class ListLocationsInRdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = Logger.getLogger(ListLocationsInRdfServlet.class.getCanonicalName());
	
	@EJB
	private RPGLocationDAO rpgLocationDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLocationsInRdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/xml");
		
		List<RPGLocation> sheets = rpgLocationDAO.retrieveAll();

		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/Marvin/data/Location/";
		String dbNS = "http://dbpedia.org/onthology/";
		model.setNsPrefix("db", dbNS);
		
		Resource dbLocation = ResourceFactory.createResource(dbNS + "Location");

		for (RPGLocation sheet : sheets) {
			model.createResource(myNS + sheet.getId())
				.addProperty(RDF.type, dbLocation)
				.addProperty(RDFS.label, sheet.getName())
				.addProperty(RDFS.comment, sheet.getDescription());
			
			logger.log(Level.INFO, "Added RPGLocation/" + sheet.getId() + " to the RDF model");
			
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
