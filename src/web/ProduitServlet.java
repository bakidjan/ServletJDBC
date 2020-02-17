package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.IProduitDaoImp;
import dao.Produit;
import model.ProduitModel;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet(name = "cs", urlPatterns = { "/produitServlet", "*.do" })
public class ProduitServlet extends HttpServlet {
	IProduitDao iProdDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		iProdDao = new IProduitDaoImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			//request.getRequestDispatcher("jsp/products.jsp").forward(request, response);
			/*
			 * charger les données a la page d'accueil
			 */
			response.sendRedirect("search.java?keyword=");
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			List<Produit> produits = iProdDao.chercherParMotCle("%" + motCle + "%");
			ProduitModel model = new ProduitModel();
			model.setProduits(produits);
			model.setMotCle(motCle);
			request.setAttribute("model", model);
			request.getRequestDispatcher("jsp/produits.jsp").forward(request, response);
		} else if (path.contentEquals("/saisie.do")) {
			request.setAttribute("produitP", new Produit());
			request.getRequestDispatcher("jsp/ajoutProduit.jsp").forward(request, response);
		} else if (path.equals("/save.do") && (request.getMethod().equals("POST"))) {
			//request.setAttribute("produitP", new Produit());
			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = new Produit(designation, prix, quantite);
			iProdDao.save(p);
			request.setAttribute("produitP", p);
			request.getRequestDispatcher("jsp/confirmationAjout.jsp").forward(request, response);
		}else if(path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			iProdDao.supprimer(id);
			//request.getRequestDispatcher("jsp/produits.jsp").forward(request, response);
			/*
			 * Pour la redirection, pas de / sinon erreur
			 */
			response.sendRedirect("chercher.do?motCle=");
		} else if(path.equals("/edit.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit p = iProdDao.getProduit(id);
			request.setAttribute("produitP", p);
			request.getRequestDispatcher("jsp/editProduit.jsp").forward(request, response);
		} else if(path.equals("/update.do")&&(request.getMethod().equals("POST"))) {
			Long id = Long.parseLong(request.getParameter("id"));
			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = new Produit(designation, prix, quantite);
			p.setId(id);
			iProdDao.update(p);
			request.setAttribute("produitP", p);
			request.getRequestDispatcher("jsp/confirmationAjout.jsp").forward(request, response);
		}
		else {
			response.sendError(response.SC_NOT_FOUND);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
