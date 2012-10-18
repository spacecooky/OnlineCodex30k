package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYZoantrophen extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter pod;

	public TYZoantrophen() {
		name = "Zoantrophen";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Zoantroph", "Zoantrophen", 1, 3, 60);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYZoantrophen.jpg"));

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
