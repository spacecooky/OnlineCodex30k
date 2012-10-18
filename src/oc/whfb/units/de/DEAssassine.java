package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DEAssassine extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkGifts;
	RuestkammerStarter rkBanner;

	public DEAssassine() {
		name = BuildaHQ.translate("Assassine");
		grundkosten = 90;
		
		add(ico = new oc.Picture("oc/images/DEAssassine.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Zweite Handwaffe"), 6));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Repetier-Handarmbrust"), 10));

		seperator();

		rkGifts = new RuestkammerStarter(ID, randAbstand, cnt, "DEGiftsOfKhaine", "");
		rkGifts.initKammer(false, false, true);
		rkGifts.setButtonText(BuildaHQ.translate("Geschenke des Khaine"));
		add(rkGifts);
		
		setEintragsCNT(0);
		
		complete();
	}

	@Override
	public void refreshen() {
	}

}
