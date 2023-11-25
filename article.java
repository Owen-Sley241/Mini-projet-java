public class article{
	private int reference;
	private String designation;
	private double prixUnitaire;
	private int quantiteStock;
	public article(int ref, String des, double prix, int qu){
		this.reference = ref;
		this.designation = des;
		this.prixUnitaire = prix;
		this.quantiteStock = qu;
	}
	public int getReference(){
		return reference;
	}
	public void setReference(int ref){
		this.reference = ref;
	}
	public String getDesignation(){
		return designation;
	}
	public void setDesignation(String des){
		this.designation = des;
	}
	public double getPrixUnitaire(){
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prix){
		this.prixUnitaire = prix;
	}
	public int getQuantiteStock(){
		return quantiteStock;
	}
	public void setQuantiteStock(int qu){
		this.quantiteStock = qu;
	}
	public String affiche(){
		String infos;
		infos = "Reference: "+reference+", Designation: "+designation+", Prix Unitaire: "+prixUnitaire+", Quantite de stock: "+quantiteStock;
		return infos;
	}
}
