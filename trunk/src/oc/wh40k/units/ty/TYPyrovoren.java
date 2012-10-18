package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYPyrovoren extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter pod;

	public TYPyrovoren() {
		name = "Pyrovoren";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Pyrovore", "Pyrovoren", 1, 3, 45);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYPyrovoren.jpg"));

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
