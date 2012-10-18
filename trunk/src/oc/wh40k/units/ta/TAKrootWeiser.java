package oc.wh40k.units.ta;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TAKrootWeiser extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public TAKrootWeiser() {
		grundkosten = 21;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Pulsgewehr", 5));
		ogE.addElement(new OptionsGruppeEintrag("Pulssturmgewehr", 5));
		add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));

		sizeSetzen();
 	}

	@Override
	public void refreshen() {
	}

}
