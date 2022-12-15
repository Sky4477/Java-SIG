import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class AdresseClient {
    ConnectionData data = new ConnectionData();
    private String email,adresse,ville ,Code_postal,idclient;
    private int telephone;

    // Un Client peut Avoir Plusieur Adresse
    private List <Client> client = new ArrayList();
    
    public AdresseClient(String email, String adresse, 
     String ville, String code_postal, int telephone, List <Client> client) {
        this.email = email;
        this.adresse = adresse;
        this.ville = ville;
        Code_postal = code_postal;
        this.telephone = telephone;
        this.client = client;
    }
    public AdresseClient() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getCode_postal() {
        return Code_postal;
    }
    public void setCode_postal(String code_postal) {
        Code_postal = code_postal;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public List <Client> getClient() {
        return client;
    }
    public void setClient( List <Client> client) {
        this.client = client;
    }
    


    private String Query;
    public AdresseClient(String idclient,String email, String adresse, String ville, String code_postal, 
            int telephone) {
        this.email = email;
        this.adresse = adresse;
        this.ville = ville;
        Code_postal = code_postal;
        this.idclient = idclient;
        this.telephone = telephone;
    }
    public String getQuery() {
        return Query;
    }
    public void setQuery(String query) {
        Query = query;
    }

    void select() throws SQLException{
setQuery("SELECT * FROM public.adresseclient;");
Statement st = data.myConnexion().createStatement();
ResultSet rs = st.executeQuery(getQuery());
while (rs.next()) {
    idclient=rs.getString(1);
    email=rs.getString(2);
    telephone=rs.getInt(3);
    adresse=rs.getString(4);
    ville=rs.getString(5);
    Code_postal=rs.getString(6);
   
     System.out.println("\n\t\t\t\tAdresseClient\n email= " + email + "\t| adresse= " 
     + adresse + " \t| ville=  " + ville + "\t| Code_postal= "
     + Code_postal + "\t| telephone=  " + telephone );
}

    }
    void insert() throws SQLException{
setQuery("INSERT INTO public.adresseclient("+
	" clientid, email, telephone, adresse, ville, code_postal) "+
	"VALUES (?, ?, ?, ?, ?, ?);");
    PreparedStatement ps= data.myConnexion().prepareStatement(getQuery());
    ps.setString(1, idclient);
    ps.setString(2,email);
    ps.setInt(3, telephone);
    ps.setString(4,adresse);
    ps.setString(5, ville);
    ps.setString(6, Code_postal);
    ps.execute();
    System.out.println("INSERTED");
    }
    void update() throws SQLException{
setQuery("UPDATE public.adresseclient "+
" SET email=?, telephone=?, adresse=?, ville=?, code_postal=?"+
" WHERE idclient=? ;");
PreparedStatement ps=data.myConnexion().prepareStatement(getQuery());
ps.setString(1,email);
ps.setInt(2, telephone);
ps.setString(3,adresse);
ps.setString(4, ville);
ps.setString(5, Code_postal);
ps.setString(6, idclient);
ps.executeUpdate();
System.out.println("UPDATED");
    }
    void delete() throws SQLException{
setQuery("DELETE FROM public.adresseclient wherer clientid=?;");

PreparedStatement ps=data.myConnexion().prepareStatement(getQuery());
ps.setString(1, idclient);
ps.execute();
System.out.println("DELETED");
    }
    
        

    void showCleint(){
        for (Client i:client){
            System.out.println(i.toString());
        }
    }
}