package oc.wh40k.units.ec;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ECExarch extends RuestkammerVater {
    
    OptionsUpgradeGruppe o1;

	public ECExarch() {
		grundkosten = 12;
	}

	@Override
	public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Prism Lanc", 10));
        ogE.addElement(new OptionsGruppeEintrag("Haywire Launcher", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cynosure", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Withdraw", 15));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
