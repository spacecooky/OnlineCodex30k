package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEFuerstinMalys extends Eintrag {

    public DEFuerstinMalys() {
        name = "Fürstin Malys";
        grundkosten = 130;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        BuildaHQ.addToInformationVector("DEArchon", 1);

        add(ico = new oc.Picture("oc/wh40k/images/DEFuerstinMalys.jpg"));
        

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("DEHQ", -1);
        BuildaHQ.addToInformationVector("DEArchon", -1);
    }
    
}
