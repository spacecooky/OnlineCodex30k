package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class WELegionGlaiveSuperheavySpecialWeaponsTank extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3, o4, o5;

	public WELegionGlaiveSuperheavySpecialWeaponsTank() {
		name = "Legion Glaive Super-heavy Special Weapons Tank";
		grundkosten = 625;
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Quad lascannons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laser destroyers", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy flamer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 25));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
		
	}

}
