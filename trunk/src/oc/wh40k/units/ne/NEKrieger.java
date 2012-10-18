package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class NEKrieger extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkTransport;

	public NEKrieger() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Necron-Krieger", 5, 20, 13);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEKrieger.jpg"));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "NETransporterKammer", "Transporter");
		rkTransport.initKammer(true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
