import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CompteClient {
    String idCleint;
    ConnectionData data = new ConnectionData();
    private String NumeroCompte= new GenerateurID().GenerateurNum();
    private String cle_Securite=new GenerateurID().cle_Securite(),Type_Commpte;
    private LocalDate date_ouverture;
    // Un Client peut Avoir 1 Ou Plusieur ou Compte
    private List <Client> client;
    public CompteClient(String
     numeroCompte, 
    String cle_Securite, String
     type_Commpte, LocalDate date_ouverture,
           List <Client> client) {
        NumeroCompte = numeroCompte;
        this.cle_Securite = cle_Securite;
        Type_Commpte = type_Commpte;
        this.date_ouverture = date_ouverture;
        this.client = client;
    }
    public CompteClient() {
    }
    public String getNumeroCompte() {
        return NumeroCompte;
    }
    public void setNumeroCompte(String numeroCompte) {
        NumeroCompte = numeroCompte;
    }
    public String getCle_Securite() {
        return cle_Securite;
    }
    public void setCle_Securite(String cle_Securite) {
        this.cle_Securite = cle_Securite;
    }
    public String getType_Commpte() {
        return Type_Commpte;
    }
    public void setType_Commpte(String type_Commpte) {
        Type_Commpte = type_Commpte;
    }
    public LocalDate getDate_ouverture() {
        return date_ouverture;
    }
    public void setDate_ouverture(LocalDate date_ouverture) {
        this.date_ouverture = date_ouverture;
    }
    public List <Client> getClient() {
        return client;
    }
    public void setClient(List <Client> client) {
        this.client = client;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((NumeroCompte == null) ? 0 : NumeroCompte.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CompteClient other = (CompteClient) obj;
        if (NumeroCompte == null) {
            if (other.NumeroCompte != null)
                return false;
        } else if (!NumeroCompte.equals(other.NumeroCompte))
            return false;
        return true;
    }


    private String Query;
    public CompteClient(String numeroCompte) {
        NumeroCompte = numeroCompte;
    }
    public CompteClient(String numeroCompte, String cle_Securite) {
        NumeroCompte = numeroCompte;
        this.cle_Securite = cle_Securite;
    }
    public CompteClient(String idCleint, String type_Commpte, LocalDate date_ouverture) {
        this.idCleint = idCleint;
        Type_Commpte = type_Commpte;
        this.date_ouverture = date_ouverture;
    }
    public CompteClient(String idCleint, String cle_Securite, String type_Commpte, LocalDate date_ouverture) {
        this.idCleint = idCleint;
        this.cle_Securite = cle_Securite;
        Type_Commpte = type_Commpte;
        this.date_ouverture = date_ouverture;
    }
    public String getQuery() {
        return Query;
    }
    public void setQuery(String query) {
        Query = query;
    }

    void select() throws SQLException{
        String num=null,cle=null,type=null;
        Object date=null;
setQuery("SELECT *"+
" FROM public.compteclient;");
Statement st = data.myConnexion().createStatement();
ResultSet rs=st.executeQuery(getQuery());
while (rs.next()){
    num =rs.getString(1);
    cle=rs.getString(2);
   type=rs.getString(3);
   date= rs.getDate(4);
   idCleint=rs.getString(5); 
   System.out.println(
    "\n\t\t\t\t\t\t" 
  +"CompteClient" +"   \n\t\t\t\t*****************************************\n"
  +"IdClient= "+idCleint+"\t"
  +" NumeroCompte= " + num + 
  " \t| cle_Securite= " + cle + " \t| Type_Commpte= "
          + type + " \t| date_ouverture= " + date + "");
   }
   
    }


void insert(String Type_Compte,String idClient) throws SQLException{
setQuery("INSERT INTO public.compteclient("+
"numerocompte, cle_securite, type, date_ouverture,idclient)"
+"VALUES (?, ?, ?, ?,?);");
PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
ps.setString(1,getNumeroCompte());
ps.setString(2,getCle_Securite());
ps.setString(5, idClient);
ps.setDate(4, Date.valueOf(LocalDate.now()));
ps.setString(3, Type_Compte);
ps.execute();
System.out.println("Inserted");
    }

void update(String newcle) throws SQLException{
setQuery("UPDATE public.compteclient "
+" SET  cle_securite=?"+
" WHERE numerocompte=?;");
PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
ps.setString(1,newcle);
ps.setString(2, NumeroCompte);
ps.executeUpdate();
ps.close();
System.out.println("UPDATED");

    }


void delete(String cleAuthe) throws SQLException{
setQuery("DELETE FROM public.compteclient"
	+" WHERE numerocompte=? and cle_securite=?;");
    PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
    ps.setString(1, NumeroCompte);
    ps.setString(2, cleAuthe);
    ps.execute();
  System.out.println("DELETED");
    }






    @Override
    public String toString() {
        return "CompteClient [NumeroCompte=" + NumeroCompte + 
        ", cle_Securite=" + cle_Securite + ", Type_Commpte="
                + Type_Commpte + ", date_ouverture=" + date_ouverture + "]";
    }

void infoCompte(){
        System.out.println(" \n \t \t Numero Compte "+getNumeroCompte()
         +"\n \t\t Cle de Sécurité "+ getCle_Securite()+"\n");
    }
}
