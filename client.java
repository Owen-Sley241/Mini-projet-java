class client extends personne{
	private double chiffreaffaire;
	public client(int iden, String nomsocial, String adresse, double chiffreaffaire){
		super(iden, nomsocial, adresse);
		this.chiffreaffaire = chiffreaffaire;
	}
	public double getChiffreaffaire(){
		return chiffreaffaire;
	}
	public void setChiffreaffaire(double chiffreaffaire){
		this.chiffreaffaire = chiffreaffaire;
	}
	
	public void affiche(){
		super.toString();
		String d = super.toString();
		System.out.println(d+", chiffreaffaire: "+chiffreaffaire);
	}  
}

