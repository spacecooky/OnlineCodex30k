package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class NEImotekhderSturmherr extends Eintrag {
    
    RuestkammerStarter rkTransport;

	public NEImotekhderSturmherr() {
		name = "Imotekh der Sturmherr";
		grundkosten = 225;

		BuildaHQ.addToInformationVector("NEHochlord", 1);

		add(ico = new oc.Picture("oc/wh40k/images/NEImotekhderSturmherr.jpg"));

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
