import java.util.Date;
public class commande{
	private int numComm;
	Date dateComm;
	client client;
	public commande(int num, Date da, client cli){
		this.numComm = num;
		this.dateComm = da;
		this.client = cli;
	}
	public int getNumComm(){
		return numComm;
	}
	public void setNumComm(int num){
		this.numComm = num;
	}
	public Date getDatecomm(){
		return dateComm;
	}
	public void setDateComm(Date da){
		this.dateComm = da;
	}
	public client getClient(){
		return client;
	}
	public void setClient(client cli){
		this.client = cli;
	}
	public String affiche(){
		String cam;
		cam = "Numero de commande: "+numComm+", Date de commande: "+dateComm+", "+client+", chiffre d'affaire: "+client.getChiffreaffaire();
		return cam;
	}
}
