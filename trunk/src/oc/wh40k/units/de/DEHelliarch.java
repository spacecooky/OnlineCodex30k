package oc.wh40k.units.de;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DEHelliarch extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

	public DEHelliarch() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 0));
        ogE.addElement(new OptionsGruppeEintrag("Fangklaue", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 5));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahngaswerfer", 20));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
