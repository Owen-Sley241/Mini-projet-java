import java.util.Scanner;
import java.util.Vector;
import java.util.Date;
public class commerciale
{ 
	/*Declaration et initialisation des vecteurs:
	-clients
	-articles
	-commandes
	-lignes*/
	static private Vector<client>clients = new Vector<client>();;       
	static private Vector<article>articles = new Vector<article>();
	static private Vector<commande>commandes = new Vector<commande>();
	static private Vector<ligne> lignes = new Vector<ligne>();

	/*Methode charger de l'ajoute des commandes dans le vecteur commandes
	puis d'afficher toute les commandes */
	public static void PasserCommande(commande c){
        commandes.add(c);
		System.out.println("------------Liste des commandes passees avec succes------------");
		for (commande i : commandes){
            System.out.println(i.affiche()); 
		}
	}
	/*Methode charger de la suppression des commandes dans le vecteur commandes
	puis d'afficher le contenu du vecteur commandes s'il n'est pas vide sinon elle affiche aucune commande */
	public static void AnnulerCommande(commande c){
		commande p = null;
		boolean g = false;
		for (commande i : commandes){
			if (i.getNumComm() == c.getNumComm()){ 
              p = i;
			  g = true;
			}
		}
		if(g == false){
			System.out.println("Erreur, cette commande n'existe pas dans notre liste de commandes.");
		}else{
			commandes.remove(p);
		}
		System.out.println("------------Nouvelle liste des commandes------------");
		if (commandes.size() == 0){
				System.out.println("\t\tAucune commande");
		}else{
			for (commande i : commandes){
				System.out.println(i.affiche());	
		    }
		}
	}
	/*Methode charger de l'ajoute des articles dans le vecteur articles
	puis d'afficher tous les articles */
	public static void AjouterArticle(article a){
        articles.add(a);  
		System.out.println("------------liste des articles------------");
		for (article i : articles){
           System.out.println(i.affiche());
		}
	}
	/*Methode charger de la suppression des articles dans le vecteur articles
	puis d'afficher le contenu du vecteur articles s'il n'est pas vide sinon elle affiche aucun article */
	public static void SupprimerArticle(article a){
		article p = null;
		boolean n = false;
		for (article i : articles){
			if (i.getDesignation().equals(a.getDesignation())){
			   p = i;
			   n = true;
			}
		}
		if(n == false){
			System.out.println("Erreur, cet article n'exixte pas dans notre liste des articles ");
		}else{
			articles.remove(p);
		}
		System.out.println("------------Nouvelle liste des article------------");
		if (articles.size() == 0){
		    System.out.println("\t\tAucun article");
        }else{
	         for (article i : articles){
		         System.out.println(i.affiche());	
             }
        }
	}
	/*Methode charger de l'ajoute des clients dans le vecteur clients
    puis d'afficher tous les clients */
	public static void AjouterClient(client cl){
		clients.add(cl);
		System.out.println("------------liste des clients------------");
		for (client i : clients){
			i.affiche();
		}
	}
	/*Methode charger de la suppression des clients dans le vecteur clients
    puis d'afficher le contenu du vecteur clients s'il n'est pas vide sinon elle affiche aucun client */
	public static void SupprimerClient(client cl){
		client p = null;
		boolean t = false;
		for (client i : clients){
			if (i.getNomsocial().equals(cl.getNomsocial()) && i.getIden() == cl.getIden()){
			   p = i;
			   t = true;
			}
		}
		if (t == false){
			System.out.println("Erreur, ce client n'est pas enregistre dans notre base de donnees, nos clients sont les suivants.");
		}else{
			clients.remove(p);
		}
		System.out.println("------------Nouvelle liste des clients------------");
		if (clients.size() == 0){
				System.out.println("\t\tAucun client");
		}else{
			for (client i : clients){
				i.affiche();	
		    }
		}
	}
	public static void main(String[] args){
		Scanner clavier = new Scanner(System.in);
		int choix = 0;
		do{
			System.out.println("\n------------Gestion commerciale------------");
			System.out.println("(1) - Ajouter un article");
			System.out.println("(2) - Supprimer un article");
			System.out.println("(3) - Ajouter un client");
			System.out.println("(4) - Supprimer un client");
			System.out.println("(5) - passer une commande");
			System.out.println("(6) - Annuler une commande");
			System.out.println("(0) - Quitter");
			System.out.print("Enter votre choix:");
			choix = clavier.nextInt();
			switch (choix){
				case 1 :
					System.out.println("\n------------Ajouter un article------------");
					clavier.nextLine();
					String des = " ";
					while (true){    //Boucle infinie pour gerer la redondance des articles
						System.out.println("Designation: ");
					    String de = clavier.nextLine();
						if (articles.size() != 0){
							boolean exist = false;
							for (article i : articles){
							   if (i.getDesignation().equals(de)){
								   exist = true;
								   System.out.println("\nIl existe deja un produit qui porte cette designation, veuiller reprendre avec une autre designation.");
							   }else{
								   continue;
							   } 
							}
							if (exist == false){
								   des = de;
								   break;
							}else{
								continue;
							}
						}else{
					        des = de;
							break;
						}
					}
					int ref;
					if (articles.size() == 0){
						ref = 1;
					}else{
						article b = articles.lastElement();
						int n1 = b.getReference();
						ref = n1 + 1;
					}
					int qu = 0;
					while(true){  //Boucle infinie pour controler la saisie de l'utilisateur
						System.out.println("Quantite de stock: ");
						if (clavier.hasNextInt()){
							qu = clavier.nextInt();
							break;
						}else{
							System.out.println("\nErreur de saisie vous n'avez pas entrer un caractere numerique, veuiller reperendre");
							clavier.nextLine();
						}
					}
					double prix = 0;
					while(true){//Boucle infinie pour controler la saisie de l'utilisateur
						System.out.println("Prix unitaire: ");
						if (clavier.hasNextDouble()){
							prix = clavier.nextDouble();
							break;
						}else{
							System.out.println("\nErreur de saisie vous n'avez pas entrer un caractere numerique, veuiller reperendre");
							clavier.nextLine();
						}
					}
					article a = new article(ref, des, prix, qu);//Declaration de la variable a de type article et affectation des attribus: ref, des, prix, qu 
					AjouterArticle(a);//Appel de la methode AjouterArticle avec comme parametre la variable a 
					break;
				case 2 :
				    System.out.println("\n------------Supprimer un article------------");
					int ref2 = 0;
					int qu2 = 0;
					double prix2 = 0;
					clavier.nextLine();
					System.out.println("Donner la designation de l'article a supprimer: ");
					String des2 = clavier.nextLine();//Affectation des attribus: ref2, des2, prix2, qu2 a la variable a 
					a = new article(ref2, des2, prix2, qu2);//Appel de la methode SupprimerArticle avec comme parametre la variable a 
					SupprimerArticle(a);
					break;
				case 3 :
				    System.out.println("\n------------Ajouter un client------------");
					clavier.nextLine();
					int ide;/*Decleration de la variable ide et affectation d'une valeur en fonction de l'etat du vecteur clients
					         si il est vide ide recoit 1 sinon il recoit l'ide incrementer du dernier client ajoute */
					if (clients.size() == 0){
						ide = 1;
					}else{
						client b2 = clients.lastElement();
						int n2 = b2.getIden();
						ide = n2 + 1;
					}
					System.out.println("Veuillez saisir votre nom: ");
					String nom = clavier.nextLine();
					System.out.println("Veuillez saisir votre adresse: ");
					String adresse = clavier.nextLine(); 
					double chif = 0;
					while(true){ //Boucle infinie pour controler la saisie de l'utilisateur
						System.out.println("Veuillez saisir votre chiffre d'affaires: ");
						if (clavier.hasNextDouble()){
							chif = clavier.nextDouble();
							break;
						}else{
							System.out.println("\nErreur de saisie vous n'avez pas entrer un caractere numerique, veuiller reperendre");
							clavier.nextLine();
						}
					}
					client cl = new client(ide, nom, adresse, chif);//Declaration de la variable cl de type client et affectation des attribus: ide, nom, adresse, chif 
					AjouterClient(cl);//Appel de la methode AjouterClient avec comme parametre la variable cl 
					break;
				case 4 :
					System.out.println("\n------------Supprimer un client------------");
					clavier.nextLine();
					System.out.println("Veuiller saisir le nom du client a Supprimer: ");				
			     	String nom1 = clavier.nextLine();
					String adresse1 = " ";
					int ide1 = 0;
					while(true){//Boucle infinie pour controler la saisie de l'utilisateur
						System.out.println("Veuiller saisir l'identifiant du client a Supprimer: ");
						if (clavier.hasNextInt()){
							ide1 = clavier.nextInt();
							break;
						}else{
							System.out.println("\nErreur de saisie vous n'avez pas entrer un caractere numerique, veuiller reperendre");
							clavier.nextLine();
						}
					}
					double chif1 = 0;
					cl = new client(ide1, nom1, adresse1, chif1);//Affectation des attribus: ide1, nom1, adresse1, chif1 au client cl
					SupprimerClient(cl); //Appel de la methode SupprimerClient avec comme parametre la variable cl 
					break;
				case 5 :
				    System.out.println("\n------------Passer une commande------------");
					clavier.nextLine();
		            System.out.println("Veuiller saisir votre nom: ");
					String nom2 = clavier.nextLine();
					System.out.println("Veuiller saisir votre adresse: ");
					String adresse2 = clavier.nextLine();
					int num;/*Decleration des variables ide2 et num et affectation des valeurs en fonction de l'etat du vecteur commandes
					        si il est vide ide2 et num recoivent 1 sinon ils recoivent l'ide incrementer de la derniere commande passee */
					int ide2;
					if (commandes.size() == 0){
						num = 1;
						ide2 = 1;
					}else{
						commande b1 = commandes.lastElement();
						int n3 = b1.getNumComm();
						num = n3 + 1;
						ide2 = num;
					}
		            double chif2 = 0;
					while(true){ //Boucle infinie pour controler la saisie de l'utilisateur
						System.out.println("Veuillez saisir votre chiffre d'affaires: ");
						if (clavier.hasNextDouble()){
							chif2 = clavier.nextDouble();
							break;
						}else{
							System.out.println("\nErreur de saisie vous n'avez pas entrer un caractere numerique, veuiller reperendre");
							clavier.nextLine();
						}
					}
					commande c = new commande(num, new Date(), new client(ide2, nom2, adresse2, chif2));/*Declaration de la variable c de type commande et affectation des attribus: 
					                                                                                    num, new Date(), new client(ide2, nom2, adresse2, chif2) a la commande c */
					PasserCommande(c);//Appel de la methode PasserCommande avec comme parametre la variable c 
					break;
				case 6 :
					System.out.println("\n------------Annuler commande------------");
					clavier.nextLine();
					String nom3 = " ";
					int num2 = 0;
					while(true){//Boucle infinie pour controler la saisie de l'utilisateur
						System.out.println("Veuiller saisir le numero de la commande a supprimer: ");
						if (clavier.hasNextInt()){
							num2 = clavier.nextInt();
							break;
						}else{
							System.out.println("\nErreur de saisie vous n'avez pas entrer un caractere numerique, veuiller reperendre.");
							clavier.nextLine();
						}
					}
					int ide3 = 0; 
					double chif3 = 0;
					String adresse3 = " ";
					c = new commande(num2, new Date(), new client(ide3, nom3, adresse3, chif3));//Affectation des attribus: num2, new Date(), new client(ide3, nom3, adresse3, chif3) a la commande c
					AnnulerCommande(c);//Appel de la methode AnnulerCommande avec comme parametre la variable c 
					break;
				case 0 :
					 System.out.println("\nVous avez quitte la gestion commerciale, merci pour votre visite et a la prochaine.");
					 break;
				default :
				     System.out.println("CHOIX INCORRECT");
			}
		}while (choix!=0);
		System.out.println("------------[FIN DU MINI PROJET JAVA]------------");
	}
}