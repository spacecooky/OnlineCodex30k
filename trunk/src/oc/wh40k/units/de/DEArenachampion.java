package oc.wh40k.units.de;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DEArenachampion extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

	public DEArenachampion() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
