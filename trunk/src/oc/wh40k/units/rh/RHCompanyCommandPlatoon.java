package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class RHCompanyCommandPlatoon extends Eintrag {

	RuestkammerStarter commandSquad;
	RuestkammerStarter heavyWeaponsSquad1;
	RuestkammerStarter heavyWeaponsSquad2;
	RuestkammerStarter heavyWeaponsSquad3;
	RuestkammerStarter heavyWeaponsSquad4;
	RuestkammerStarter heavyWeaponsSquad5;
	RuestkammerStarter heavyWeaponsSquad6;

	public RHCompanyCommandPlatoon() {
		name = "Company Command Platoon";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGInfantryPlatoon.jpg"));
		

		seperator();

		commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "RHCompanyCommandSquadKammer", "Company Command Squad", 1);
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

		heavyWeaponsSquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "RHHeavyWeaponsSquadKammer", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad4.initKammer();
		add(heavyWeaponsSquad4);

		seperator();

		heavyWeaponsSquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "RHHeavyWeaponsSquadKammer", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad5.initKammer();
		add(heavyWeaponsSquad5);

		seperator();
		
		heavyWeaponsSquad6 = new RuestkammerStarter(ID, randAbstand, cnt, "RHHeavyWeaponsSquadKammer", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad6.initKammer();
		add(heavyWeaponsSquad6);

		complete();
	}

	@Override
	public void refreshen() {
		commandSquad.setLegal(commandSquad.isSelected());
		heavyWeaponsSquad2.setAktiv(heavyWeaponsSquad1.isSelected());
		heavyWeaponsSquad3.setAktiv(heavyWeaponsSquad2.isSelected());
		heavyWeaponsSquad4.setAktiv(heavyWeaponsSquad3.isSelected());
		heavyWeaponsSquad5.setAktiv(heavyWeaponsSquad4.isSelected());
		heavyWeaponsSquad6.setAktiv(heavyWeaponsSquad5.isSelected());
	}
}
