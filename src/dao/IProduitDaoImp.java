package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IProduitDaoImp implements IProduitDao {

	public IProduitDaoImp() {}

	/*
	 * ajout de produits dans la base de données
	 * @param p du produit a ajouter
	 */
	@Override
	public Produit save(Produit p) {
		/*
		 * creation de la connection
		 * avec le patern singleton
		 * donc pas besoin de la fermer apres
		 */
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO PRODUITS (DESIGNATION, PRIX, QUANTITE) VALUES (?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			ps.close();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
				;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/*
	 * rechercher un produit par un mot clé
	 * cette methode retourne une liste de produits
	 */
	@Override
	public List<Produit> chercherParMotCle(String motCle) {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps.setString(1, motCle);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	/*
	 * supprimer un produit via son id
	 */
	@Override
	public void supprimer(Long id) {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/*
	 * mise a jour d'un produit donné
	 */
	@Override
	public Produit update(Produit p) {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE PRODUITS SET DESIGNATION=?, PRIX=?, QUANTITE=? WHERE ID=?");
			
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/*
	 * renvoyer un produit via son id
	 * Lire un produit a partir de son id
	 */
	@Override
	public Produit getProduit(Long id) {
		Produit p =null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID =?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p=new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
