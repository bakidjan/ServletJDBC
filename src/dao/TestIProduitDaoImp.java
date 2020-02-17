package dao;

import java.util.List;

public class TestIProduitDaoImp {

	public static void main(String[] args) {
		IProduitDaoImp iproduitDaoImp = new IProduitDaoImp();
		Produit p1 = new Produit("asus", 400, 26);
		//iproduitDaoImp.save(p1);
		Produit p2 = new Produit("ordi portable", 390, 20);
		//iproduitDaoImp.save(p2);
		Produit p3 = new Produit("dell vostro", 300, 60);
		//iproduitDaoImp.save(p3);
		Produit p4 = new Produit("hp henvy", 250, 40);
		Produit p5 = iproduitDaoImp.getProduit(p3.getId());
		//iproduitDaoImp.save(p4);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());
		System.out.println(p5.toString());
		//iproduitDaoImp.supprimer(p1.getId());
		
		List<Produit> produits = iproduitDaoImp.chercherParMotCle("%d%");
		for(Produit p : produits) {
			System.out.println(p.toString());
		}

	}

}
