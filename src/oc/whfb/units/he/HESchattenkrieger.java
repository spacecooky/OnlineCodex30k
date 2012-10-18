package oc.whfb.units.he;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class HESchattenkrieger extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	
	public HESchattenkrieger() {
		name = BuildaHQ.translate("Schattenkrieger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Schattenkrieger"), 5, 100, 16);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/HESchattenkrieger.jpg"));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 12));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
