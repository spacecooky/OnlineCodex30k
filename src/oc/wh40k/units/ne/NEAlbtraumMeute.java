package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class NEAlbtraumMeute extends Eintrag {

	AnzahlPanel squad;

	public NEAlbtraumMeute() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Albträume", 5, 20, 13);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEAlbtraumMeute.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
