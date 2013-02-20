package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class SHLegionThunderhawkGunship extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3, o4;

	public SHLegionThunderhawkGunship() {
		name = "Legion Thunderhawk Gunship";
		grundkosten = 900;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Thunderhawk cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Turbo-laser destructor", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bomb clusters", 0));
		ogE.addElement(new OptionsGruppeEintrag("6 Hellstrike missiles", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Chaff launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured cockpit", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flare shield", 50));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		if (!o2.isSelected()) o2.setSelected(0, true);
	}

}