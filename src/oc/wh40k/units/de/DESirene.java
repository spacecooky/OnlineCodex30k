package oc.wh40k.units.de;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DESirene extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

	public DESirene() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schattenpistole", 15));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahngaswerfer", 10));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
