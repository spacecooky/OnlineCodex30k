package oc.wh30k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORWarhoundScoutTitan extends Eintrag {

	OptionsUpgradeGruppe o1, o2;

	public ORWarhoundScoutTitan() {
		name = "Warhound Scout Titan";
		grundkosten = 750;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Vulcan mega-bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Turbo laser destructor", "Double-barrelled Turbo laser destructor", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma blastgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Inferno gun", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Plasma blastgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vulcan mega-bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Turbo laser destructor", "Double-barrelled Turbo laser destructor", 0));
		ogE.addElement(new OptionsGruppeEintrag("Inferno gun", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
		
	}

}
