package oc.wh40k.units.sw;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SWContemptorDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public SWContemptorDreadnought() {
		name = "Contemptor Dreadnought";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Sbolter", "Cybot-Nahkampfwaffe + Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + SFlamer", "Cybot-Nahkampfwaffe + Schwerer Flammenwerfer", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
//		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kheres Assault Cannon", "Kheres Pattern Assault Cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Sbolter", "Cybot-Nahkampfwaffe + Sturmbolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + SFlamer", "Cybot-Nahkampfwaffe + Schwerer Flammenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Sbolter", "Kettenfaust + Sturmbolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + SFlamer", "Kettenfaust + Schwerer Flammenwerfer", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Black Cull", "Saga of the Black Cull", 0));
		ogE.addElement(new OptionsGruppeEintrag("Forsaken One", "Saga of the Forsaken One", 0));
		ogE.addElement(new OptionsGruppeEintrag("Iron God", "Saga of the Iron God", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                
                seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zus�tzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wolf Tail Talisman", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wolftooth Necklace", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cyclone Missile Launcher", "Carapace-mounted Cyclone Missile Launcher", 35));

		complete();
	}

	@Override
	public void refreshen() {
                o1.alwaysSelected();
                o2.alwaysSelected();
                o3.alwaysSelected();
	}
	
}
