package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYToxotrophen extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter pod;

	public TYToxotrophen() {
		name = "Toxotrophen";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Toxotrophe", "Toxotrophen", 1, 3, 55);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYToxotrophen.jpg"));

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
