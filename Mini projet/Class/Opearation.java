import java.sql.*;
import java.time.LocalDate;

public class Opearation {
ConnectionData data = new ConnectionData();
    private String numeroCompte;
    private double montant;
   private String type;
    private LocalDate date;
    private String Query;
    private double solde;
    
    public Opearation(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    public Opearation(String numeroCompte, double montant) {
        this.numeroCompte = numeroCompte;
        this.montant = montant;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {

        this.solde = solde;
        
    }
    public Opearation() {
    }
    public Opearation(String numeroCompte, double montant, String type, LocalDate date, String query) {
        this.numeroCompte = numeroCompte;
        this.montant = montant;
        this.type = type;
        this.date = date;
        Query = query;
    }
    public String getNumeroCompte() {
        return numeroCompte;
    }
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getQuery() {
        return Query;
    }
    public void setQuery(String query) {
        Query = query;
    }


    void select()throws SQLException{
        Object date;
        setQuery("SELECT * FROM public.operation;");
        Statement st = data.myConnexion().createStatement();
        ResultSet rs = st.executeQuery(getQuery());
        while (rs.next()) {
            numeroCompte=rs.getString(1);
            montant = rs.getDouble(2);
            type =rs.getString(3);
            date=rs.getDate(4);

            System.out.println("\n\t\t\t\tOpearation\n numeroCompte=  " 
            + numeroCompte + "\t| montant=  " + montant + "\t| type=  " + type
            + "\t| date=  " + date + "");
        }

            }
            void insert()throws SQLException{
        setQuery("INSERT INTO public.opeartion( numerocompte, montant, type, date_operation) "+
            "VALUES (?, ?, ?);");
            PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
            ps.setString(1, numeroCompte);
            ps.setDouble(2, montant);
            ps.setString(3, type);
            ps.setDate(4, Date.valueOf(date));
            
            ps.execute();
            System.out.println("INSERTED");
            }

            void update(String numeroCompte,Double newmontant,String newtype)throws SQLException{
        setQuery("UPDATE public.operation SET  montant=?,type, date=? WHERE numerocompte=?;");
        PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
        ps.setDouble(1, newmontant);
        ps.setString(2, newtype);
        ps.setDate(3, Date.valueOf(date));
        ps.setString(4, numeroCompte);
        System.out.println("UPDATED");
            }

            void delete(String numeroCompte)throws SQLException{
        setQuery("DELETE FROM public.operation WHERE numerocompte=?;");
        PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
       ps.setString(1, numeroCompte);
       ps.executeQuery();
       System.out.println("DELETED");
            }

            Double depo(double montant) throws SQLException{
                setQuery("INSERT INTO public.operation( numerocompte, montant, type, date) "+
                "VALUES (?, ?, ?,?);");
               
                
                PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
                ps.setString(1, numeroCompte);
                ps.setDouble(2, montant);
                ps.setString(3, "Depôt");
                
                ps.setDate(4, Date.valueOf(LocalDate.now()));
                
                ps.execute();
                System.out.println("DEPOSED");

                String inseSol = "UPDATE  compteclient set solde=? where numerocompte= ?";
                PreparedStatement insp = data.myConnexion().prepareStatement(inseSol);
                insp.setDouble(1, Math.abs(montant+solde()));
                insp.setString(2, numeroCompte);
                insp.executeUpdate();

                return getSolde();
            }

            Double Retrait(double montant) throws SQLException{
                setQuery("INSERT INTO public.operation( numerocompte, montant, type, date) "+
                "VALUES (?, ?, ?,?);"); 
                if (montant<=solde()){
                    PreparedStatement ps = data.myConnexion().prepareStatement(getQuery());
                    ps.setString(1, numeroCompte);
                    ps.setDouble(2, montant);
                    ps.setString(3, "Depôt");
                    
                    ps.setDate(4, Date.valueOf(LocalDate.now()));
                    
                    ps.execute();
                    System.out.println("COLLECTED");

                    String inseSol = "UPDATE  compteclient set solde=? where numerocompte= ?";
                    PreparedStatement insp = data.myConnexion().prepareStatement(inseSol);
                    insp.setDouble(1, Math.abs(montant-solde()));
                    insp.setString(2, numeroCompte);
                    insp.executeUpdate();
                }
                else{
                    System.out.println("Solde Insufisant");
                }
               return getSolde();
            }
               

                double solde() throws SQLException{
                    double soldee=0;
                    String
                     soldeString="SELECT solde from compteclient  where numerocompte=?  ;";
                    PreparedStatement st = data.myConnexion().prepareStatement(soldeString);
                    st.setString(1, numeroCompte);
                    ResultSet rs = st.executeQuery();
                    while(rs.next()){
                        soldee=rs.getDouble(1);
                    }
                    return soldee;
                }
            }
            
            
