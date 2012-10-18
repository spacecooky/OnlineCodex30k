package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class IGHalblingTrupp extends Eintrag {

	AnzahlPanel squad;

	boolean lastState = false;

	public IGHalblingTrupp() {
		name = "Halbling Trupp";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Halblinge", 3, 10, 10);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGRatlingSquad.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
