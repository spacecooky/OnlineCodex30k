package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ZWKanone extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	RuestkammerStarter rkRunen;
	
	public ZWKanone() {
		name = BuildaHQ.translate("Kanone");
		grundkosten = 90;

		add(ico = new oc.Picture("oc/whfb/images/ZWKanone.jpg"));

		seperator(12);

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Maschinist"), 15));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Zwergenmuskete"), 5));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Pistolenpaar"), 5));

		seperator();

		rkRunen = new RuestkammerStarter(ID, randAbstand, cnt, "ZWMaschinenrunen", "");
		rkRunen.initKammer(true, false, false);
		rkRunen.setButtonText(BuildaHQ.translate("Runen"));
		add(rkRunen);

		complete();
	}

	@Override
	public void refreshen() {
		oe2.setAktiv(oe1.isSelected());
		oe3.setAktiv(oe1.isSelected());
	}
}
