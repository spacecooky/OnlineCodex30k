package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMDeathstormDropPod extends Eintrag {

    OptionsUpgradeGruppe o1;

	public SMDeathstormDropPod() {
		name = "Deathstorm Drop Pod";
		grundkosten = 75;
		�berschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/SMDeathwindDropPod.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("WW Raketenwerfer", "Whirlwind Raketenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanonen", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
	}

}
