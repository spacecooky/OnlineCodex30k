package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class BDCChaosbrut extends Eintrag {

	AnzahlPanel squad;
	
	public BDCChaosbrut() {
		name = BuildaHQ.translate("Chaosbrut");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Chaosbrut"), 1, 2, 55);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DESchwarzeReiter.jpg"));
		
		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {	
	}
}
