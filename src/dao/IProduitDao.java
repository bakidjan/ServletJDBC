package dao;

import java.util.List;

public interface IProduitDao {
	public Produit save(Produit p);
	public List<Produit> chercherParMotCle(String motCle);
	public void supprimer(Long id);
	public Produit update(Produit p);
	public Produit getProduit(Long id);
}
