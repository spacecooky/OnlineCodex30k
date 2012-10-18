package oc.wh40k.units.de;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DEDracon extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

	public DEDracon() {
		grundkosten = 5;
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Splittergewehr", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splitterkarabiner", 5));
        ogE.addElement(new OptionsGruppeEintrag("Splitterpistole", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schattenpistole", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Giftklinge", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Peiniger", 20));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Geisterharnisch", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahngaswerfer", 20));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        
        o2.setAktiv(o1.isSelected("Splitterpistole") || o1.isSelected("Schattenpistole"));
	}

}
