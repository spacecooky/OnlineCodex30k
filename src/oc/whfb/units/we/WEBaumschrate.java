package oc.whfb.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class WEBaumschrate extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	
	public WEBaumschrate() {
		name = BuildaHQ.translate("Baumschrate");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Baumschrate"), 3, 12, 65);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/WEBaumschrate.jpg"));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
