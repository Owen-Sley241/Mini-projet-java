public class ligne{
	private commande commande;
	private article article;
	private int quantiteComm;
	public ligne(commande com, article art, int qu){
		this.commande = com;
		this.article = art;
		this.quantiteComm = qu;
	}
	public commande getCommande(){
		return commande;
	}
	public void setCommande(commande com){
		this.commande = com;
	}
	public article getArticle(){
		return article;
	}
	public void setArticle(article art){
		this.article = art;
	} 
	public int getQuantitecomm(){
		return quantiteComm;
	}
	public void setQuantitecomm(int qu){
		this.quantiteComm = qu;
	}
}
