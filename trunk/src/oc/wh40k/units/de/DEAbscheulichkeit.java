package oc.wh40k.units.de;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DEAbscheulichkeit extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public DEAbscheulichkeit() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Unterw.-Handschuh", "Unterwerfungshandschuh", 10));
        ogE.addElement(new OptionsGruppeEintrag("Scherenhand", 15));
        ogE.addElement(new OptionsGruppeEintrag("Injektorhandschuh", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
