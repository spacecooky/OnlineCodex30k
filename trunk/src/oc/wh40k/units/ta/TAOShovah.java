package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;

public class TAOShovah extends Eintrag {

    public TAOShovah() {
        name = "O'Shovah";
        grundkosten = 170;
        
        BuildaHQ.addToInformationVector("TA2006OShovah", 1);

        add(ico = new oc.Picture("oc/wh40k/images/OShovah.gif"));
        

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        
        double armySize = OnlineCodex.getInstance().getKosten();
        if(armySize < 1500) {
            setFehlermeldung("Armee < 1500 Pkt!");
        } else {
            setFehlermeldung("");
        }
    }
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("TA2006OShovah", -1);
    }
    
}
