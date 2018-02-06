
package clientwsfootball;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import eu.dataaccess.footballpool.TCountryInfo;
import java.util.List;


public class ClientWsFootball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Nº total de tarjetas amarillas = " + yellowCardsTotal());
        
        //System.out.println("Los defensas españoles son: " + allDefenders("Spain").getString());
        System.out.println("Todos los defensas son: "+ allDefenders("").getString());
         List<TCountryInfo> tcountryinfo = countryNames(true).getTCountryInfo();
        for(TCountryInfo tcountryinfo1: tcountryinfo){
            System.out.println(tcountryinfo1.getSName());
            String country = tcountryinfo1.getSName();
            System.out.println(allDefenders(country).getString());
        }
    }

    
    
    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }    
    
}
  
