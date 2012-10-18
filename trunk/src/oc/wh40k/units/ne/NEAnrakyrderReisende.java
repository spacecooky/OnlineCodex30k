package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class NEAnrakyrderReisende extends Eintrag {
    
    RuestkammerStarter rkTransport;

	public NEAnrakyrderReisende() {
		name = "Anrakyr der Reisende";
		grundkosten = 165;

		BuildaHQ.addToInformationVector("NEHochlord", 1);
		BuildaHQ.addToInformationVector("NEAnrakyrderReisende", 1);

		add(ico = new oc.Picture("oc/wh40k/images/NEAnrakyrderReisende.jpg"));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "NEKommandogleiterKammer", "Kommando-Gleiter");
		rkTransport.initKammer();
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("NEHochlord", -1);
		BuildaHQ.addToInformationVector("NEAnrakyrderReisende", -1);
	}

}
