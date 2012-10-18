package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DEHellion extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;

	public DEHellion() {
		name = "Hellion-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Hellion", 5, 20, 16);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEHellion.jpg"));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DEHelliarch", "Upgrade zum Helliarch");
		rkBoss.initKammer();
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
