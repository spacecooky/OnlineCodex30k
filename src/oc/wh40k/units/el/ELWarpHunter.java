package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELWarpHunter extends Eintrag {

	OptionsUpgradeGruppe o1;

	public ELWarpHunter() {
		name = "Warp Hunter";
		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/ELWarpHunter.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("T/L Shuriken catapults", "Twin-linked Shuriken catapults", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spirit stones", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star engines", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vector engines", 20));
     	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Holo-field", 35));

		complete();
	}

    @Override
	public void refreshen() {
		o1.alwaysSelected();
	}

}
