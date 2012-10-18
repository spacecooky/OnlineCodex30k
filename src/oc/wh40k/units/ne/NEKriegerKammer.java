package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class NEKriegerKammer extends RuestkammerVater {

	AnzahlPanel squad;
	RuestkammerStarter rkTransport;

	public NEKriegerKammer() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Necron-Krieger", 5, 20, 13);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEKrieger.jpg"));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "NETransporterKammer", "Transporter");
		rkTransport.initKammer(true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
