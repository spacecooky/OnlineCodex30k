package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TYSporenminen extends Eintrag {

	AnzahlPanel squad;

	public TYSporenminen() {
		name = "Sporenminen";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sporenminen", 3, 6, 10);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYSporenminen.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
