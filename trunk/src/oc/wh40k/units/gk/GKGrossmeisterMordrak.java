package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKGrossmeisterMordrak extends Eintrag {

	public GKGrossmeisterMordrak() {
		name = "Groﬂmeister Mordrak";
		grundkosten = 200;

        //BuildaHQ.addToInformationVector("GKGrossmeisterMordrak", 1);

		add(ico = new oc.Picture("oc/wh40k/images/GKGrossmeisterMordrak.jpg"));

		seperator();

        BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Geisterritter");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		//BuildaHQ.addToInformationVector("GKGrossmeisterMordrak", -1);
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Geisterritter");
		super.deleteYourself();
	}

}
