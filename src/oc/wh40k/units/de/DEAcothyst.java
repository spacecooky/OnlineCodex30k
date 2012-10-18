package oc.wh40k.units.de;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DEAcothyst extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public DEAcothyst() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Toxin-Nadler", 5));
        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Unterw.-Handschuh", "Unterwerfungshandschuh", 10));
        ogE.addElement(new OptionsGruppeEintrag("Hexgewehr", 15));
        ogE.addElement(new OptionsGruppeEintrag("Scherenhand", 15));
        ogE.addElement(new OptionsGruppeEintrag("Injektorhandschuh", 20));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 20));
        ogE.addElement(new OptionsGruppeEintrag("Schockpeitsche", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
