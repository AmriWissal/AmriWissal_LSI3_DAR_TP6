package Service;

import CorbaConversion.IConversionRemotePOA;
//Définition de la classe ConversionIMPL qui hérite du POA
public class ConversionIMPL extends IConversionRemotePOA {
    @Override
    public double ConversionMontant(double montant) {
        return montant * 3.3;
    }
}
