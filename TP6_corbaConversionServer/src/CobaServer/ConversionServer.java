package CobaServer;
import Service.ConversionIMPL;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import javax.naming.Context;
import javax.naming.InitialContext;
// définition de la classe ConversioServer
public class ConversionServer {
    public static void main(String[] args) {
        try {
        //etape a : information sur l'url et le numéro  de port du serveur
        ORB orb =ORB.init(args,null);
        // etape b : recupération du RootPOA
        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        // activation de POA manager
        poa.the_POAManager().activate();
            // etape c : instanciation du context
            Context ctx = new InitialContext();
            // etape d: création de l'objet distant
            ConversionIMPL od = new ConversionIMPL();
            // Liaison de l'objet distant avec le nom "00" dans le contexte JNDI (herite du POA)
            ctx.rebind("00",poa.servant_to_reference(od));
            // lancement du serveur
            orb.run();
    }catch (Exception e){e.printStackTrace();
        }
}
}
