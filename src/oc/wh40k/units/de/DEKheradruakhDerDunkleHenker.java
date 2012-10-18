package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEKheradruakhDerDunkleHenker extends Eintrag {

    public DEKheradruakhDerDunkleHenker() {
        name = "Kheradruakh, Der Dunkle Henker";
        grundkosten = 140;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        
        add(ico = new oc.Picture("oc/wh40k/images/DEKheradruakhDerDunkleHenker.jpg"));
        

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
