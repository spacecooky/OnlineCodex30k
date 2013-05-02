package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class WELegionStormEagleAssaultGunship extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3;

	public WELegionStormEagleAssaultGunship() {
		name = "Storm Eagle";
		grundkosten = 210;

		//add(ico = new oc.Picture("oc/wh40k/images/BABaalPredator.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin multi-melta", "Twin-linked multi-melta", 15));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("4 Tempest rockets", 0));
		ogE.addElement(new OptionsGruppeEintrag("4 Hellstrike missiles", 20));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannon", 40));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
		ogE.addElement(new OptionsGruppeEintrag("Searchlight", 1));
		ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
		if(!o2.isSelected()) o2.setSelected(0, true);
	}
	
}
