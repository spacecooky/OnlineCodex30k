package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class RHRenegadeMilitiaHeavyWeaponPlatoon extends Eintrag {

	RuestkammerStarter commandSquad;
	RuestkammerStarter heavyWeaponsSquad1;
	RuestkammerStarter heavyWeaponsSquad2;
	RuestkammerStarter heavyWeaponsSquad3;
	RuestkammerStarter sabreGun;

	public RHRenegadeMilitiaHeavyWeaponPlatoon() {
		name = "Renegade Militia Heavy Weapon Platoon";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/RHRenegadeMilitiaHeavyWeaponPlatoon.jpg"));
		

		seperator();

		seperator();

		commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "RHMilitiaCommandSquadKammer", "Militia Command Squad", 1);
		commandSquad.initKammer();
		add(commandSquad);

		seperator();

		heavyWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "RHHeavyWeaponsSquadKammer", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad1.initKammer();
		add(heavyWeaponsSquad1);

		seperator();

		heavyWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "RHHeavyWeaponsSquadKammer", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad2.initKammer();
		add(heavyWeaponsSquad2);

		seperator();

		heavyWeaponsSquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "RHHeavyWeaponsSquadKammer", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad3.initKammer();
		add(heavyWeaponsSquad3);

		seperator();

		sabreGun = new RuestkammerStarter(ID, randAbstand, cnt, "RHSabreGunPlatformBatteryKammer", "Sabre Gun Platform Battery", 1);
		sabreGun.initKammer();
		add(sabreGun);
		
		
		

		complete();
	}

	@Override
	public void refreshen() {
		commandSquad.setLegal(commandSquad.isSelected());
		heavyWeaponsSquad1.setLegal(heavyWeaponsSquad1.isSelected());
		heavyWeaponsSquad2.setAktiv(heavyWeaponsSquad1.isSelected());
		heavyWeaponsSquad3.setAktiv(heavyWeaponsSquad2.isSelected());
	}
}
