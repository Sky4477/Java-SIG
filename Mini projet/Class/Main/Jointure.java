
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
public class Jointure {
    private Client client= new Client();
    private String Query;
    private CompteClient compteClient = new CompteClient();
    private Opearation operationClient;
    private AdresseClient adresseClient=new AdresseClient();
    private Object date;
    public Object getDate() {
        return date;
    }
    public void setDate(Object date) {
        this.date = date;
    }
    ConnectionData data= new ConnectionData();
    public String getQuery() {
        return Query;
    }
    public void setQuery(String query) {
        Query = query;
    }

    void JointureClientAdresse() throws SQLException{
       setQuery("select cl.idclient,cl.nom,cl.prenom,cl.date_naisssance,ad.email,"+
       " ad.telephone,ad.adresse,ad.ville,ad.code_postal from client cl "+
      " left join adresseclient ad on ad.clientid = cl.idclient  "+
      " ");
       PreparedStatement ps = data.myConnexion().prepareStatement((getQuery()));
      
       ResultSet rs =ps.executeQuery();
       while (rs.next()) {
        client.setIdClient(rs.getString(1));
        client.setNom(rs.getString(2));
        client.setPrenom(rs.getString(3));
         date=rs.getString(4);
        adresseClient.setEmail(rs.getString(5));
        adresseClient.setTelephone(rs.getInt(6));
       adresseClient.setAdresse(rs.getString(7));
        adresseClient.setVille(rs.getString(8));
        adresseClient.setCode_postal(rs.getString(9));
        System.out.println(" \t\t\t\t\tClient\n"+ " \t\t idClient= " + 
        client.getIdClient() + ", nom= " + client.getNom() + ", prenom= " + 
        client.getPrenom() + ", Date_naissance= " + date
                + "");
        System.out.println( "\t\t\t\t\tAdresseClient \n"+ "  email = " + adresseClient.getEmail() 
        + " telephone= " + adresseClient.getTelephone()+" adresse= " + adresseClient.getAdresse() + 
        " ville= " +adresseClient. getVille() + " Code_postal= "
                + adresseClient.getCode_postal()   + "\n");

       }

    

    
    }
void JointureClientCompte() throws SQLException{
    setQuery("select cl.idclient,cl.nom,cl.prenom,cm.numerocompte,cm.cle_securite, "
   +" cm.type,cm.date_ouverture from client cl"+
    " left join compteclient cm ON cm.idclient = cl.idclient"+
    " ;");
    PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
    ResultSet rs =ps.executeQuery();
    while (rs.next()) {
        client.setIdClient(rs.getString(1));
        client.setNom(rs.getString(2));
        client.setPrenom(rs.getString(3));
         compteClient.setNumeroCompte(rs.getString(4));
         compteClient.setCle_Securite(rs.getString(5));
         compteClient.setType_Commpte(rs.getString(6));
         date=rs.getString(7);

         System.out.println(" \t\t\t\t\tClient\n"+ " \t\t idClient= " + 
         client.getIdClient() + ", nom= " + client.getNom() + ", prenom= " + 
         client.getPrenom() + "");

         System.out.println(
            "\n\t\t\t\t\t\t" 
          +"CompteClient" +"   \n\t\t\t\t*****************************************\n"
          +" NumeroCompte= " + compteClient.getNumeroCompte() + 
          " \t| cle_Securite= " + compteClient.getCle_Securite() + " \t| Type_Commpte= "
                  + compteClient.getType_Commpte() + " \t| date_ouverture= " + date + "\n");
    }
   

}

Jointure jointureCompteOperation(String Numcomp) throws SQLException{
    setQuery("select cm.numerocompte,cm.type,cm.solde,op.idoperation,"+
    " op.montant,op.type, op.date from compteclient cm "+
    " left join operation op ON op.numerocompte = cm.numerocompte "+
   " where cm.numerocompte=?;");
   PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
   ps.setString(1, Numcomp);
   ResultSet rs =ps.executeQuery();
   while (rs.next()) {
    
    System.out.println(
            "\n\t\t\t\t\t\t" 
          +"CompteClient" +"   \n\t\t\t\t*****************************************\n"
          +" NumeroCompte= " + rs.getString(1) + 
         " \t| Type_Commpte= "
                  + rs.getString(2) + " \t| Solde= " + rs.getDouble(3) + "\n");

                  System.out.println("\n\t\t\t\tOpearation\n numeroCompte=  " 
                  + rs.getInt(4) + "\t| montant=  " + rs.getDouble(5) + 
                  "\t| type=  " + rs.getString(6)
                  + "\t| date=  " + rs.getDate(7) + "");
   }
    return new Jointure();
}
   
}