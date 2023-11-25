public abstract class personne
{   
	protected int iden;
    protected String nomsocial;
    protected String adresse;
	protected personne(int iden, String nomsocial, String adresse){
		this.iden = iden;
		this.nomsocial = nomsocial;
		this.adresse = adresse;
	}
	protected personne(personne p){
		this(p.iden,p.nomsocial,p.adresse);
	}
	protected int getIden(){
	   return iden;
	}
	protected void setIden(int iden){
	   this.iden = iden;
	}
	protected String getNomsocial(){
		return nomsocial;
	}
	protected void setNomsocial(String nomsocial){
	    this.nomsocial = nomsocial;
	}
	protected String getAdresse(){
        return adresse;
	}
	protected void setAdresse(String adresse){
	   this.adresse = adresse;
	}
	@Override
	public String toString(){
		String infos;
        infos = "Identifiant: "+iden+", Nomsocial: "+nomsocial+", adresse: "+adresse ;
		return infos ;
	}
	protected void affiche(){
	  System.out.println(toString());
	}
}
 
//netbice prendre 