package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORZhadsnarkDaRippa extends Eintrag {

	public ORZhadsnarkDaRippa() {

		kategorie = 1;



		name = "Zhadsnark 'Da Rippa' [IA8]";



		grundkosten = 150;





		add(ico = new oc.Picture("oc/wh40k/images/ZhadsnarkDaRippa.gif"));


		BuildaHQ.addToInformationVector("ORZhadsnark", 1);
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Waaghbikaz");
		


		complete();



	}

	public void deleteYourself() {
		BuildaHQ.addToInformationVector("ORZhadsnark", -1);
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Waaghbikaz");

		super.deleteYourself();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
