package oc.wh30k.units.ih;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IHTransportKammerEagle  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3;

	public IHTransportKammerEagle () {
            grundkosten = 210;
	}

	public void initButtons(boolean... defaults) {


		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked multi-melta", 15));
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
		
        sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
	}
        
}