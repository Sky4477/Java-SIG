
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.IntStream;;
public class GenerateurID {
    
    public String getGeneID(int i){
        byte[] bytearray;
        String myID;
        StringBuffer IdString;
        bytearray = new byte[256]; 
        new Random().nextBytes(bytearray);
        myID = new String(bytearray, Charset.forName("UTF-8")); 
        IdString = new StringBuffer(); 

        for (int m = 0; m < myID.length(); m++) { 

            char n = myID.charAt(m); 

            if (((n >= 'A' && n <= 'Z') 
                || (n >= '0' && n <= '9')) )
                if (  i > 0) { 
                IdString.append(n); 
                i--; 
            } 
        } 
        return IdString.toString(); 
    }
  
    
    String GenerateurNum(){
        
        final Random random = new Random();
        final Set<Integer> intSet = new HashSet<>();
        while (intSet.size() < 4) {
            intSet.add(random.nextInt(49) + 1);
        }
        final int[] ints = new int[intSet.size()];
        final Iterator<Integer> iter = intSet.iterator();
        for (int i = 0; iter.hasNext(); ++i) {
            ints[i] = iter.next();
        }
        int  Num=(int) (Math.random()*(900-100+1)+100);
        String n= Num+"";
        return n;
        

    }

    public String cle_Securite(){
        final Random random = new Random();
        final Set<Integer> intSet = new HashSet<>();
        while (intSet.size() < 2) {
            intSet.add(random.nextInt(49) + 1);
        }
        final int[] ints = new int[intSet.size()];
        final Iterator<Integer> iter = intSet.iterator();
        for (int i = 0; iter.hasNext(); ++i) {
            ints[i] = iter.next();
        }
        int  Num=(int) (Math.random()*(900-100+1)+100);
        String n= Num+"";
        return n;
    }
}
