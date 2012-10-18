package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerVater;

public class TATeufelsrochenKammer extends RuestkammerVater {

	public TATeufelsrochenKammer() {

		grundkosten = 80;
	}

	public void initButtons(boolean... defaults) {



		add(ico = new oc.Picture("oc/wh40k/images/TeufelsrochenGross.gif"));



		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Schwärmer Raketensystem", 20));

		seperator();

		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fahrzeugsensorik", 10));

		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Verbesserte Zielerfassung", 5));

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
