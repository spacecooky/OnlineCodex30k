package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerVater;

public class TAHammerhaiKammer extends RuestkammerVater {

	public TAHammerhaiKammer() {
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/HammerhaiGross.gif"));
		

		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fahrzeugsensorik", 10));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Feuerleitsystem", 10));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtsichtgerät", 5));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Multiple Zielerfassung", 5));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flechettewerfer", 10));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Störsystem", 5));
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Ködersystem", 5));

		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Lenkraketen", 2, 10));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
	}

}
