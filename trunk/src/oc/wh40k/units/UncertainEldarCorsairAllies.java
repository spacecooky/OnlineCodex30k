package oc.wh40k.units;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;

public class UncertainEldarCorsairAllies extends Eintrag {

    public UncertainEldarCorsairAllies() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            BuildaHQ.addToInformationVector("ECUncertainAllies", 1);
            BuildaHQ.addToInformationVector("ECEldarAllies", 1);
        }
    }

    @Override
    public void refreshen() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            if (BuildaHQ.getCountFromInformationVector("ECEldarAllies") > 1) {
                setFehlermeldung("Eldar-Alliierte > 1!");
            } else {
                int corsairSquads = BuildaHQ.getCountFromInformationVector("ECCorsairSquad");
                int uncertainAllies = BuildaHQ.getCountFromInformationVector("ECUncertainAllies");
                if(uncertainAllies > corsairSquads) {
                    setFehlermeldung("Corsair Squads < " + uncertainAllies + "!");
                } else {
                    setFehlermeldung("");
                }
            }
        }
    }

    @Override
    public void deleteYourself() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            BuildaHQ.addToInformationVector("ECUncertainAllies", -1);
            BuildaHQ.addToInformationVector("ECEldarAllies", -1);
        }
    }
    
}
