package oc.wh40k.units.as;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class ASLaeuterer extends Eintrag {

	AnzahlPanel squad;

	public ASLaeuterer() {
		name = "L�uterer";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "L�uterer", 1, 3, 85);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASLaeuterer.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
