package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TYSchwarmwachen extends Eintrag {

	AnzahlPanel squad;

	public TYSchwarmwachen() {
		name = "Schwarmwachen";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Schwarmwache", "Schwarmwachen", 1, 3, 50);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYTyrantenwachen.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
