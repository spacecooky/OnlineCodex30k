package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class ORPikkUpKammer extends RuestkammerVater {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;
	OptionsEinzelUpgrade oe6;
	OptionsEinzelUpgrade oe7;
	OptionsEinzelUpgrade oe8;

	public ORPikkUpKammer() {
		grundkosten = 35;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/Pikk-Up.gif"));
		

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bazzukka", 5));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rotä Farbä", 5));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grothälfaz", 5));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombschleuda", 5));
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 10));
		add(oe6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Entaplankä", 5));
		add(oe7 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirnä", 10));
		add(oe8 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vastärktä Rammä", 5));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
	}

}
