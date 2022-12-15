/*
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    LocalDate date=  LocalDate.of(1997, 6, 28);
    Scanner sc = new Scanner(System.in);
private Client client;
private CompteClient compteClient;
private Opearation opearation;
private Jointure jointure;
private String numCompte;


 void Menue() throws SQLException{
    System.out.println("1. SERVICE Client");
    System.out.println("2. SERVICE Compte");
System.out.println("3. Les TRANSACTION Compte  ");
System.out.println("4.Jointure");
    

    switch (sc.nextInt()) {
        case 1:
            client();
            break;
    
        case 2:
        CompteClient();
        break;
        case 3:
            operationCleint();
            break;

            case 4:
            joinntClient();
            break;
    }
}

     void client() throws SQLException{
        
        System.out.println("1. Ajouter un Client "); 
       System.out.println("2. Modifier les Donner d'un Client");
       System.out.println("3. Suprimer un Client");

         switch (sc.nextInt()) {
            case 1:
            System.out.println("Entre Le Nom  | Prenom  | Date de naisdance Y,M,D");
             client= new Client(new Scanner(System.in).nextLine(),
             new Scanner(System.in).nextLine(), LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
    
             client.insert();
             client.info();
             client.select();
             MenuCl();
                break;
                
            case 2:
            System.out.println("Entre L'année puis le mois puis le jour");
                client.update(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()),
                new Scanner(System.in).nextLine());
                client.info();
                MenuCl();

                break;

                case 3:
                System.out.println("Entre L'ID du client  ");
                client.delete(new Scanner(System.in).nextLine());

                MenuCl();
                break;

         }


    }

    void CompteClient() throws SQLException{
        System.out.println("1. Creé un Compte ");
        System.out.println("2. Modifier Un Compte");
        System.out.println("3.Suprimer Un Compte");

        switch (new Scanner(System.in).nextInt()) {
            case 1:
                System.out.println
                ("Entre le type de Compte Soit Courant Ou Epargne ||   Entre L'id Du client");
                
               new CompteClient().insert(sc.nextLine(), sc.nextLine());
                new CompteClient().select();
                new CompteClient().infoCompte();
                MenuCm();
                break;
        
            case 2:
            Auth();
            System.out.println
            ("Entre  la nouvelle Valeur de la  Clé de Sécurite ");
            compteClient.update(sc.nextLine());
           compteClient.infoCompte();
           MenuCm();
          
                break;

            case 3:
            Auth();
            System.out.println
            ("Entre   la   Clé de Sécurite ");

            compteClient.delete( sc.nextLine());
            MenuCm();
                break;

               
        }

    }

    void operationCleint() throws SQLException{
        Auth();
       if(Auth().length()>=4){
        System.out.println("1.Effectuer un dépôt");
        System.out.println("2.Effectuer un Retrait");
        System.out.println("Consulter votre Solde");
        
        switch (sc.nextInt()) {
            case 1:
                System.out.println("Entre  Le Montant de dépôt");
                opearation.depo(sc.nextInt());
                MenuOop();
                break;
         
            case 2:
            System.out.println("Entre  Le Montant de Retrait");
            opearation.Retrait(sc.nextInt());
            MenuOop();
                break;
            case 3:
            System.out.println(" \t\t Compte Numéro  | "+ opearation.getNumeroCompte());
            System.out.println("\t\t  Votre Solde est | " +opearation.solde());
            MenuOop();
                break;

       }
              
        }
    }

    /**
     * @throws SQLException
     */
    /* 
    
    
void joinntClient() throws SQLException{
        jointure = new Jointure();
        System.out.println("1.Afficher un la liste des Adresse Client");
        System.out.println("2.Afficher La lsite des Compte Client");
        System.out.println("Afficher des Operation Client");

        switch (sc.nextInt()) {
            case 1:
                
                jointure.JointureClientAdresse(numCompte);
               
                MenuJon();
                        
                break;
        case 2:
        jointure.JointureClientCompte(numCompte);
        
        MenuJon();
       
        break;
           case 3:
           jointure.jointureCompteOperation(numCompte);
                
           MenuJon();
            break;  
            
            default :System.exit(0);
        }
            
        }
    

    String Auth() throws SQLException{
        ConnectionData data = new ConnectionData();
        System.out.println("\t $$$ Authentification  $$$ \n");
            System.out.println
            ("Entre le Numéro de Compte  ");

                    PreparedStatement st = 
                    data.myConnexion().
                    prepareStatement("SELECT numerocompte from compteclient  where numerocompte=?  ;");
                    st.setString(1, sc.nextLine());
                    ResultSet rs = st.executeQuery();
                    while(rs.next()){
                        numCompte=rs.getString(1);
                    }
            jointure = new Jointure(); 
            opearation = new Opearation(numCompte);
            compteClient = new CompteClient(numCompte); 
            return numCompte;
    }

    void MenuOop() throws SQLException{

        System.out.println("\nEntre 'M' pour le Menu principale 'P' pour le Menu Précédant");
        if (sc.nextLine().toUpperCase().equals("M")) {
            Menue();
       }
                if (sc.nextLine().toUpperCase().equals("P"));
            operationCleint();
    }

    void MenuCm() throws SQLException{
        System.out.println("\nEntre 'M' pour le Menu principale 'P' pour le Menu Précédant");
        if (sc.nextLine().toUpperCase().equals("M")) {
             Menue();
        }
                if (sc.nextLine().toUpperCase().equals("P"));
            CompteClient();
    }

    void MenuCl() throws SQLException{
        System.out.println("\nEntre 'M' pour le Menu principale 'P' pour le Menu Précédant");
        if (sc.nextLine().toUpperCase().equals("M")) {
             Menue();
        }
                if (sc.nextLine().toUpperCase().equals("P"));
            client();
    }

    void MenuJon() throws SQLException{
        System.out.println("\nEntre 'M' pour le Menu principale 'P' pour le Menu Précédant");
        if (sc.nextLine().toUpperCase().equals("M")) {
             Menue();
        }
                if (sc.nextLine().toUpperCase().equals("P"));
            joinntClient();
    }
}

 */