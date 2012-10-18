package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class TADornenhaiKammer extends RuestkammerVater {

	public TADornenhaiKammer() {
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/DornenhaiGross.gif"));

		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fahrzeugsensorik", 10));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Verbesserte Zielerfassung", 5));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Feuerleitsystem", 10));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtsichtger�t", 5));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flechettewerfer", 10));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "St�rsystem", 5));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "K�dersystem", 5));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
	}
	
}
