package oc.whfb.units.em;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class EMDschungelschwarm extends Eintrag {

	AnzahlPanel squad;
	
	public EMDschungelschwarm() {
		name = BuildaHQ.translate("Dschungelschwarm");
		grundkosten = 0;
		
		setCountToMinimum(false); // Unit cannot resolve minimum number of core units

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Dschungelschwarm"), 1, 6, 45);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/EMDschungelschwarm.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
