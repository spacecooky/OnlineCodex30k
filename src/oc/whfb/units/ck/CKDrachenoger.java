package oc.whfb.units.ck;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CKDrachenoger extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oeC;
	
	public CKDrachenoger() {
		name = BuildaHQ.translate("Drachenoger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Drachenoger"), 3, 100, 65);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/CKDrachenoger.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zusätzliche Handwaffen"), 8));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffen"), 12));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Champion"), 20));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 8);
		oe2.setPreis(squad.getModelle() * 12);
	}
}
