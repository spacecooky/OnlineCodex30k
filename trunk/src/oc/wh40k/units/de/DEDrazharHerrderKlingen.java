package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEDrazharHerrderKlingen extends Eintrag {

    public DEDrazharHerrderKlingen() {
        name = "Drazhar, Herr der Klingen";
        grundkosten = 230;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        
        add(ico = new oc.Picture("oc/wh40k/images/DEDrazharHerrderKlingen.jpg"));
        

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
