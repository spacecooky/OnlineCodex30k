package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;

public class SWLoganGrimnar extends Eintrag {

	public SWLoganGrimnar() {
		name = "Logan Grimnar";
		grundkosten = 275;

		BuildaHQ.addToInformationVector("SWHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SWLoganGrimnar.jpg"));
		

        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Wolfsgarde-Rudel");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Wolfsgarde-Rudel");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);

		// If this is the only HQ, count it as 1 (otherwise 0.5)
		if( BuildaHQ.getCountFromInformationVector("SWHQ") == 1 ) {
				setEintragsCNT(1);
		} else {
				setEintragsCNT(0.5);
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("SWHQ", -1);
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Wolfsgarde-Rudel");
        
        BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Wolfsgarde-Rudel");
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Wolfsgarde-Rudel");

		super.deleteYourself();
	}

}
