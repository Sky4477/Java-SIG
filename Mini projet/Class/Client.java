import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {

private String idClient=new GenerateurID().getGeneID(2),
nom,prenom;

private LocalDate Date_naissance ;
private  List <AdresseClient> adresseClient = new ArrayList<>();


ConnectionData data= new ConnectionData();

public Client(String idClient, String nom, String prenom, LocalDate date_naissance) {
    this.idClient = idClient;
    this.nom = nom;
    this.prenom = prenom;
    Date_naissance = date_naissance;
}
public Client() {
}
public String getIdClient() {
    return idClient;
}
public void setIdClient(String idClient) {
    this.idClient = idClient;
}
public String getNom() {
    return nom;
}
public void setNom(String nom) {
    this.nom = nom;
}
public String getPrenom() {
    return prenom;
}
public void setPrenom(String prenom) {
    this.prenom = prenom;
}
public LocalDate getDate_naissance() {
    return Date_naissance;
}
public void setDate_naissance(LocalDate date_naissance) {
    Date_naissance = date_naissance;
}
@Override
public String toString() {
    return " \t\t\t\t\tClient\n"+ "  idClient= " + 
    idClient + ", nom= " + nom + ", prenom= " + 
    prenom + ", Date_naissance= " + new Jointure().getDate()
            + "";
}
  



private String Query;
public Client(String nom, String prenom, LocalDate d) {
    this.nom = nom;
    this.prenom = prenom;
    Date_naissance = d;
}
    public String getQuery() {
        return Query;
    }
    public void setQuery(String query) {
        Query = query;
    }


    /**
     * @return
     * @throws SQLException
     */
    void select() 
    throws SQLException{
        String id=null,Nom=null,Prenom=null;
        Object date=null;

setQuery("SELECT *"+
"FROM public.client;");



Statement st = data.myConnexion().createStatement();

ResultSet rs=st.executeQuery(getQuery());

while (rs.next()){
    
   id =rs.getString(1);
   Nom=rs.getString(2);
   Prenom=rs.getString(3);
   date= rs.getDate(4); 
 
}

System.out.println( "\n \t\t\t\t\t\t" 
+"Client \n\n"+"\t\t\t\t*****************************************\n"
+" idClient= " + 
id + "\t\t| nom= " + Nom + "\t | prenom= " + 
Prenom + "\t | Date_naissance= " + date.toString()+"");

    }



    void insert() throws SQLException{
        
    setQuery("INSERT INTO public.client("+
	"idclient, nom, prenom, date_naisssance)"+
	"VALUES (?, ?, ?, ?);");
    PreparedStatement ps=data.myConnexion().prepareStatement(getQuery());
    ps.setString(1, getIdClient());
    ps.setString(2, nom);
    ps.setString(3, prenom);
    ps.setDate(4, Date.valueOf(Date_naissance) );
    ps.execute();
    System.out.println("Donner Insérer");
    }







    void update(LocalDate newdate,String idcleint) throws SQLException {
      setQuery("UPDATE public.client"
      +" SET  date_naisssance=?"
      +" WHERE idclient=?;");

PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
    ps.setDate(1, Date.valueOf(newdate));
    ps.setString(2, idcleint);
    ps.executeUpdate();System.out.println("Donner Modifier");



    }


    void delete(String ID) throws SQLException{
  setQuery(
"DELETE FROM public.client"+
" WHERE idclient=?;");
PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
ps.setString(1, ID);
ps.execute();
System.out.println("DELETED");

    }

    void info() throws SQLException{
     
    System.out.println(" \n \t\t VOTRE ID EST "+getIdClient()+"\n");
}

public void addAdresseClient(AdresseClient Adresse){
    adresseClient.add(Adresse);
}

void showAdresse(){
    for(AdresseClient i:adresseClient){
        
        System.out.println( "\t\t\t\t\tAdresseClient \n"+ "  email = " + i.getEmail() 
        + " telephone= " + i.getTelephone()+" adresse= " + i.getAdresse() + 
        " ville= " + i.getVille() + " Code_postal= "
                + i.getCode_postal()   + " ");
    
    }

    
    
}
}

