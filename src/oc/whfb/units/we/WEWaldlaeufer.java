package oc.whfb.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class WEWaldlaeufer extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	
	public WEWaldlaeufer() {
		name = BuildaHQ.translate("Waldläufer");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Waldläufer"), 5, 15, 24);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/WEWaldlaeufer.jpg"));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 8));

		complete();
	}

	@Override
	public void refreshen() {	
	}	
}
