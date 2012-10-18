package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IGInfantryPlatoonKammer extends RuestkammerVater {

	RuestkammerStarter commandSquad;
	RuestkammerStarter infantrySquad1;
	RuestkammerStarter infantrySquad2;
	RuestkammerStarter infantrySquad3;
	RuestkammerStarter infantrySquad4;
	RuestkammerStarter infantrySquad5;
	RuestkammerStarter heavyWeaponsSquad1;
	RuestkammerStarter heavyWeaponsSquad2;
	RuestkammerStarter heavyWeaponsSquad3;
	RuestkammerStarter heavyWeaponsSquad4;
	RuestkammerStarter heavyWeaponsSquad5;
	RuestkammerStarter specialWeaponsSquad1;
	RuestkammerStarter specialWeaponsSquad2;
	RuestkammerStarter conscriptsSquad;
        OptionsEinzelUpgrade o1;

	@SuppressWarnings("unused")
	private boolean hasChenkov = false;
	private boolean isDemonHunters = false;
	private boolean isWitchHunters = false;

	public IGInfantryPlatoonKammer() {
	}

	@Override
	public void initButtons(boolean... defaults) {
		name = "Infantry Platoon";
		grundkosten = 0;

		checkDraftOption();

		add(ico = new oc.Picture("oc/wh40k/images/IGInfantryPlatoon.jpg"));
		

		seperator();

                add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Infantry Platoon", 0));

		commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "IGCommandSquad", "Command Squad", 1);
		commandSquad.initKammer();
		add(commandSquad);

		seperator();

		infantrySquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantrySquad", "Infantry Squad", 1);
		infantrySquad1.initKammer();
		add(infantrySquad1);

		seperator();

		infantrySquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantrySquad", "Infantry Squad", 1);
		infantrySquad2.initKammer();
		add(infantrySquad2);

		seperator();

		infantrySquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantrySquad", "Infantry Squad", 1);
		infantrySquad3.initKammer();
		add(infantrySquad3);

		seperator();

		infantrySquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantrySquad", "Infantry Squad", 1);
		infantrySquad4.initKammer();
		add(infantrySquad4);

		seperator();

		infantrySquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantrySquad", "Infantry Squad", 1);
		infantrySquad5.initKammer();
		add(infantrySquad5);

		cnt = randAbstand;

		heavyWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad1.initKammer();
		add(heavyWeaponsSquad1);

		seperator();

		heavyWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad2.initKammer();
		add(heavyWeaponsSquad2);

		seperator();

		heavyWeaponsSquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad3.initKammer();
		add(heavyWeaponsSquad3);

		seperator();

		heavyWeaponsSquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "IGHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad4.initKammer();
		add(heavyWeaponsSquad4);

		seperator();

		heavyWeaponsSquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "IGHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad5.initKammer();
		add(heavyWeaponsSquad5);

		seperator();

		specialWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSpecialWeaponsSquad", "Special Weapons Squad", 1);
		specialWeaponsSquad1.initKammer();
		add(specialWeaponsSquad1);

		seperator();

		specialWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSpecialWeaponsSquad", "Special Weapons Squad", 1);
		specialWeaponsSquad2.initKammer();
		add(specialWeaponsSquad2);

		seperator();

		conscriptsSquad = new RuestkammerStarter(ID, randAbstand, cnt, "IGConscriptsSquad", "Conscripts Squad", 1);
		conscriptsSquad.initKammer();
		//conscriptsSquad.setButtonText("Conscripts Squad . . . . . . . 80 Pkt.");
		add(conscriptsSquad);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
                o1.setSelected(true);

		//hasChenkov = (Boolean) commandSquad.getKammer().getSpecialValue();
		//conscriptsSquad.getKammer().switchEntry("CHENKOV", hasChenkov);
		conscriptsSquad.getKammer().switchEntry(
			"CHENKOV",
			BuildaHQ.getCountFromInformationVector("IGChenkov") > 0
		);

		commandSquad.setLegal(commandSquad.isSelected());

		infantrySquad1.setLegal(infantrySquad1.isSelected());
		infantrySquad2.setLegal(infantrySquad2.isSelected());
		infantrySquad3.setAktiv(infantrySquad2.isSelected());
		infantrySquad4.setAktiv(infantrySquad3.isSelected());
		infantrySquad5.setAktiv(infantrySquad4.isSelected());

		heavyWeaponsSquad2.setAktiv(heavyWeaponsSquad1.isSelected());
		heavyWeaponsSquad3.setAktiv(heavyWeaponsSquad2.isSelected());
		heavyWeaponsSquad4.setAktiv(heavyWeaponsSquad3.isSelected());
		heavyWeaponsSquad5.setAktiv(heavyWeaponsSquad4.isSelected());

		specialWeaponsSquad2.setAktiv(specialWeaponsSquad1.isSelected());
	}

	private void checkDraftOption() {
		isDemonHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Daemonenjaeger");
		isWitchHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Hexenjaeger");

		if(isDemonHunters) BuildaHQ.addToInformationVector("DJDraftTroops", 1);
		if(isWitchHunters) BuildaHQ.addToInformationVector("HXDraftTroops", 1);
	}

	@Override
	public void deleteYourself() {
		if(isDemonHunters) BuildaHQ.addToInformationVector("DJDraftTroops", -1);
		if(isWitchHunters) BuildaHQ.addToInformationVector("HXDraftTroops", -1);
		super.deleteYourself();
	}

}
