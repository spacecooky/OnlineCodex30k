package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class NEEliminatoren extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkTransport;

	public NEEliminatoren() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Eliminatoren", 5, 10, 19);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEEliminatoren.jpg"));

        seperator();;

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "NETransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
