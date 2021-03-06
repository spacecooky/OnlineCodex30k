package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABSquadSergeant extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

	public ABSquadSergeant() {
		grundkosten = 0;
	}

    @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

		sizeSetzen();
	}

    @Override
	public void refreshen() {
	}

}
