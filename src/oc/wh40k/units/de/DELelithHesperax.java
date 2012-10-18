package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DELelithHesperax extends Eintrag {

    public DELelithHesperax() {
        name = "Lelith Hesperax";
        grundkosten = 175;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        
        add(ico = new oc.Picture("oc/wh40k/images/DELelithHesperax.jpg"));
        

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
	}

}
