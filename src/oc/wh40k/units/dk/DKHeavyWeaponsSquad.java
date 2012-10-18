package oc.wh40k.units.dk;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKHeavyWeaponsSquad extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public DKHeavyWeaponsSquad() {
		grundkosten = 65;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));
		
        
		ogE.addElement(new OptionsGruppeEintrag("3 Mortars", 0));
		ogE.addElement(new OptionsGruppeEintrag("3 Heavy bolters", 15));
		ogE.addElement(new OptionsGruppeEintrag("3 Autocannons", 15));
		ogE.addElement(new OptionsGruppeEintrag("3 T/L Heavy stubbers", "3 twin-linked Heavy stubbers", 15));
		ogE.addElement(new OptionsGruppeEintrag("3 Lascannons", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "krak grenades", 5));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        o1.alwaysSelected();
	}




}
