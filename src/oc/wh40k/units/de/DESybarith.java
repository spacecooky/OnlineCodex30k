/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oc.wh40k.units.de;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DESybarith extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

	public DESybarith() {
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

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Geisterharnisch", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahngaswerfer", 20));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
