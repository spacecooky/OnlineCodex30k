package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORWazdakkaGutsmek extends Eintrag {

	public ORWazdakkaGutsmek() {

		kategorie = 1;



		name = "Wazdakka Gutsmek";



		grundkosten = 180;





		add(ico = new oc.Picture("oc/wh40k/images/WazdakkaGutsmek.gif"));



		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Waaghbikaz");



		complete();



	}

	public void deleteYourself() {

		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Waaghbikaz");

		super.deleteYourself();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
