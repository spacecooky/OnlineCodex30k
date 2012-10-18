package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class NETrazynderUnendliche extends Eintrag {
    
    RuestkammerStarter rkTransport;

	public NETrazynderUnendliche() {
		name = "Trazyn der Unendliche";
		grundkosten = 175;

		BuildaHQ.addToInformationVector("NEHochlord", 1);

		add(ico = new oc.Picture("oc/wh40k/images/NETrazynderUnendliche.jpg"));

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
	}

}
