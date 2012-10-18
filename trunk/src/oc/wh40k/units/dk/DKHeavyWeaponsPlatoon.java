package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DKHeavyWeaponsPlatoon extends Eintrag {

	RuestkammerStarter commandSquad;
	RuestkammerStarter heavyWeaponsSquad1;
	RuestkammerStarter heavyWeaponsSquad2;
	RuestkammerStarter heavyWeaponsSquad3;
	RuestkammerStarter heavyWeaponsSquad4;

	public DKHeavyWeaponsPlatoon() {
		name = "Heavy Weapon Platoon";
		grundkosten = 0;
		überschriftSetzen = true;


		add(ico = new oc.Picture("oc/wh40k/images/IGInfantryPlatoon.jpg"));
		

		seperator();

		commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "DKPlatoonCommandSquad", "Platoon Command Squad", 1);
		commandSquad.initKammer();
		add(commandSquad);

		seperator();

		heavyWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad1.initKammer();
		add(heavyWeaponsSquad1);

		seperator();

		heavyWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad2.initKammer();
		add(heavyWeaponsSquad2);

		seperator();

		heavyWeaponsSquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad3.initKammer();
		add(heavyWeaponsSquad3);

		seperator();

		heavyWeaponsSquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad4.initKammer();
		add(heavyWeaponsSquad4);

		complete();
	}

	@Override
	public void refreshen() {
		commandSquad.setAbwaehlbar(false);

        heavyWeaponsSquad1.setAbwaehlbar(false);
		heavyWeaponsSquad2.setAktiv(heavyWeaponsSquad1.isSelected());
		heavyWeaponsSquad3.setAktiv(heavyWeaponsSquad2.isSelected());
		heavyWeaponsSquad4.setAktiv(heavyWeaponsSquad3.isSelected());

        heavyWeaponsSquad1.getPanel().setLocation((int) heavyWeaponsSquad1.getPanel().getLocation().getX(), (int) commandSquad.getPanel().getLocation().getY() + (int)commandSquad.getPanel().getSize().height + 10);
        heavyWeaponsSquad2.getPanel().setLocation((int) heavyWeaponsSquad2.getPanel().getLocation().getX(), (int) heavyWeaponsSquad1.getPanel().getLocation().getY() + (int)heavyWeaponsSquad1.getPanel().getSize().height + 10);
        heavyWeaponsSquad3.getPanel().setLocation((int) heavyWeaponsSquad3.getPanel().getLocation().getX(), (int) heavyWeaponsSquad2.getPanel().getLocation().getY() + (int)heavyWeaponsSquad2.getPanel().getSize().height + 10);
        heavyWeaponsSquad4.getPanel().setLocation((int) heavyWeaponsSquad4.getPanel().getLocation().getX(), (int) heavyWeaponsSquad3.getPanel().getLocation().getY() + (int)heavyWeaponsSquad3.getPanel().getSize().height + 10);
    }
}
