package oc.whfb.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class WEWaldreiter extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	public WEWaldreiter() {
		name = BuildaHQ.translate("Waldreiter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Waldreiter"), 5, 10, 24);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/WEWaldreiter.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 9));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 18));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 9));


		complete();
	}

	@Override
	public void refreshen() {
	}
}
