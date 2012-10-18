package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class SWCanisWolfsblut extends Eintrag {

	public SWCanisWolfsblut() {
		name = "Canis Wolfsblut";
		grundkosten = 185;

		BuildaHQ.addToInformationVector("SWHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SWCanisWolfsblut.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Fenriswolf", 10));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Fenriswolfsrudel");
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Fenriswolfsrudel");

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
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Fenriswolfsrudel");
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Fenriswolfsrudel");
		super.deleteYourself();
	}

}
