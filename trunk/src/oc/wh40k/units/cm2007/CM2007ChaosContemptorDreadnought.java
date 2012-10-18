package oc.wh40k.units.cm2007;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CM2007ChaosContemptorDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public CM2007ChaosContemptorDreadnought() {
		name = "Chaos Contemptor Dreadnought";
		grundkosten = 195;

		add(ico = new oc.Picture("oc/wh40k/images/CMChaosContemptorDreadnought.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + sync. Bolter", "Cybot-Nahkampfwaffe + synchronisierter Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + SFlamer", "Cybot-Nahkampfwaffe + schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Plasma Bl", "Cybot-Nahkampfwaffe + Plasma Blaster", 15));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Soulburner", "Cybot-Nahkampfwaffe + Soulburner", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
//		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Butcher Cannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Conversion Beamer", 35));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + sync. Bolter", "Cybot-Nahkampfwaffe + synchronisierter Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + SFlamer", "Cybot-Nahkampfwaffe + schwerer Flammenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Plasma Bl", "Cybot-Nahkampfwaffe + Plasma Blaster", 25));
		ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Soulburner", "Cybot-Nahkampfwaffe + Soulburner", 30));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + sync. Bolter", "Kettenfaust + synchronisierter Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + SFlamer", "Kettenfaust + schwerer Flammenwerfer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Plasma Bl", "Kettenfaust + Plasma Blaster", 30));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Soulburner", "Kettenfaust + Soulburner", 35));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Dedicated to Khorne", 25));
		ogE.addElement(new OptionsGruppeEintrag("Dedicated to Slaanesh", 25));
		ogE.addElement(new OptionsGruppeEintrag("Dedicated to Nurlge", 25));
		ogE.addElement(new OptionsGruppeEintrag("Dedicated to Tzeentch", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc Launcher", "Carapace-mounted Havoc Launcher", 35));

		complete();
	}

	@Override
	public void refreshen() {
                o1.alwaysSelected();
                o2.alwaysSelected();
                
                o1.setAktiv("Cybot-Nahkampfwaffe + Plasma Blaster", o1.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || !(o2.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || o2.isSelected("Kettenfaust + Plasma Blaster")));
                o2.setAktiv("Cybot-Nahkampfwaffe + Plasma Blaster", o2.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || !(o1.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || o2.isSelected("Kettenfaust + Plasma Blaster")));
                o2.setAktiv("Cybot-Nahkampfwaffe + Plasma Blaster", o2.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || !(o1.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || o2.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster")));
                
                o1.setAktiv("Cybot-Nahkampfwaffe + Soulburner", o1.isSelected("Cybot-Nahkampfwaffe + Soulburner") || !(o2.isSelected("Cybot-Nahkampfwaffe + Soulburner") || o2.isSelected("Kettenfaust + Soulburner")));
                o2.setAktiv("Cybot-Nahkampfwaffe + Soulburner", o2.isSelected("Cybot-Nahkampfwaffe + Soulburner") || !(o1.isSelected("Cybot-Nahkampfwaffe + Soulburner") || o2.isSelected("Kettenfaust + Soulburner")));
                o2.setAktiv("Cybot-Nahkampfwaffe + Soulburner", o2.isSelected("Cybot-Nahkampfwaffe + Soulburner") || !(o1.isSelected("Cybot-Nahkampfwaffe + Soulburner") || o2.isSelected("Cybot-Nahkampfwaffe + Soulburner")));
                
	}
	
}
