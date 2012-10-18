package oc.whfb.units.ck;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CKChaoshunde extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	
	public CKChaoshunde() {
		name = BuildaHQ.translate("Chaoshunde");
		grundkosten = 0;

		setCountToMinimum(false); // Unit cannot resolve minimum number of core units

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Chaoshunde"), 5, 100, 6);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/CKChaoshunde.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Giftattacken"), 3));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schuppenhaut"), 1));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 3);
		oe2.setPreis(squad.getModelle() * 1);
	}
}
