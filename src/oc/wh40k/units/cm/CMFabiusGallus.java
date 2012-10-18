package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;

public class CMFabiusGallus extends Eintrag {

	public CMFabiusGallus() {
		name = "Fabius Gallus";
		grundkosten = 165;

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("EliteKrieger");
		BuildaHQ.addToInformationVector("CMFabiusGallus", 1);
		
		add(ico = new oc.Picture("oc/wh40k/images/FabiusBile.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
        BuildaHQ.addToInformationVector("CMFabiusGallus", -1);
        if (BuildaHQ.getCountFromInformationVector("CMFabiusGallus") <= 0) {
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("EliteKrieger");
        }
		super.deleteYourself();
	}

}
