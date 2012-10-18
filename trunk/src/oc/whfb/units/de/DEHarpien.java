package oc.whfb.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class DEHarpien extends Eintrag {

	AnzahlPanel squad;
	
	public DEHarpien() {
		name = BuildaHQ.translate("Harpien");
		grundkosten = 0;
		
		setCountToMinimum(false); // Unit cannot resolve minimum number of core units

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Harpien"), 5, 10, 11);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/DEHarpien.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
