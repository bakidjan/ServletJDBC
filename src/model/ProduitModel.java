package model;

import java.util.ArrayList;
import java.util.List;

import dao.Produit;

/*
 * le model permet de stocker les données de la sevlet
 */
public class ProduitModel {
	private String motCle;
	private List<Produit> produits = new ArrayList<Produit>();
	
	public ProduitModel() {}

	/**
	 * @param motCle
	 * @param produits
	 */
	public ProduitModel(String motCle, List<Produit> produits) {
		super();
		this.motCle = motCle;
		this.produits = produits;
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
