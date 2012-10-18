package oc.wh40k.units.dk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DKQuartermaster extends Eintrag {

	RuestkammerStarter rkTransport;

	public DKQuartermaster() {
		name = "Death Korps Quartermaster";
		grundkosten = 60;

		add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
		rkTransport.initKammer();
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
	}


}
