package oc.wh40k.units.dk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class DKHeavyMortar extends RuestkammerVater {

    AnzahlPanel squad;
    private RuestkammerStarter rkTransport;

	public DKHeavyMortar() {
		grundkosten = 50;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGHellhound.jpg"));
		

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Crew", 3, 5, 6));
        squad.setGrundkosten(-18);
        squad.setNichtDieErsteOption(true);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
		rkTransport.initKammer();
		add(rkTransport);

		sizeSetzen();
	}

  @Override
	public void refreshen() {

	}

}
