package oc.whfb.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class WEFalkenreiter extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	
	public WEFalkenreiter() {
		name = BuildaHQ.translate("Falkenreiter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Falkenreiter"), 3, 12, 40);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/WEFalkenreiter.jpg"));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
