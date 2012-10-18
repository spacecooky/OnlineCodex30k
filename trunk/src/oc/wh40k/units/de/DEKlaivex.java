package oc.wh40k.units.de;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DEKlaivex extends RuestkammerVater {

	public DEKlaivex() {
		grundkosten = 15;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Demi-Klaivar", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blutstein", 15));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Erwähltes Opfer", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ansturm", 15));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
