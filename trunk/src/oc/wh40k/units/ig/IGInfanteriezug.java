package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.RuestkammerStarter;

public class IGInfanteriezug extends Eintrag {

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
	
	RuestkammerStarter sabreSquad1;
	RuestkammerStarter sabreSquad2;
	RuestkammerStarter sabreSquad3;
	RuestkammerStarter sabreSquad4;
	RuestkammerStarter sabreSquad5;
	
	RuestkammerStarter specialWeaponsSquad1;
	RuestkammerStarter specialWeaponsSquad2;
	RuestkammerStarter conscriptsSquad;

	private boolean isDemonHunters = false;
	private boolean isWitchHunters = false;

	public IGInfanteriezug() {
		name = "Infanteriezug";
		grundkosten = 0;
		überschriftSetzen = true;

		checkDraftOption();

		add(ico = new oc.Picture("oc/wh40k/images/IGInfantryPlatoon.jpg"));
		

		seperator();

		commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "IGKommandotrupp", "Kommandotrupp des Zuges", 1);
		commandSquad.initKammer();
		add(commandSquad);

		seperator();

		infantrySquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfanterietrupp", "Infanterietrupp", 1);
		infantrySquad1.initKammer();
		add(infantrySquad1);

		seperator();

		infantrySquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfanterietrupp", "Infanterietrupp", 1);
		infantrySquad2.initKammer();
		add(infantrySquad2);

		seperator();

		infantrySquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfanterietrupp", "Infanterietrupp", 1);
		infantrySquad3.initKammer();
		add(infantrySquad3);

		seperator();

		infantrySquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfanterietrupp", "Infanterietrupp", 1);
		infantrySquad4.initKammer();
		add(infantrySquad4);

		seperator();

		infantrySquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfanterietrupp", "Infanterietrupp", 1);
		infantrySquad5.initKammer();
		add(infantrySquad5);

		seperator();

		heavyWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGUnterstuetzungstrupp", "Unterstützungstrupp", 1);
		heavyWeaponsSquad1.initKammer();
		add(heavyWeaponsSquad1);

		seperator();

		heavyWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGUnterstuetzungstrupp", "Unterstützungstrupp", 1);
		heavyWeaponsSquad2.initKammer();
		add(heavyWeaponsSquad2);

		seperator();

		heavyWeaponsSquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGUnterstuetzungstrupp", "Unterstützungstrupp", 1);
		heavyWeaponsSquad3.initKammer();
		add(heavyWeaponsSquad3);

		seperator();

		heavyWeaponsSquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "IGUnterstuetzungstrupp", "Unterstützungstrupp", 1);
		heavyWeaponsSquad4.initKammer();
		add(heavyWeaponsSquad4);

		seperator();

		heavyWeaponsSquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "IGUnterstuetzungstrupp", "Unterstützungstrupp", 1);
		heavyWeaponsSquad5.initKammer();
		add(heavyWeaponsSquad5);

		seperator();
		
		sabreSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSabreWeaponsBattery", "[IA Aero.] Sabre Battery", 1);
		sabreSquad1.initKammer();
		add(sabreSquad1);

		seperator();

		sabreSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSabreWeaponsBattery", "[IA Aero.] Sabre Battery", 1);
		sabreSquad2.initKammer();
		add(sabreSquad2);

		seperator();

		sabreSquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSabreWeaponsBattery", "[IA Aero.] Sabre Battery", 1);
		sabreSquad3.initKammer();
		add(sabreSquad3);

		seperator();

		sabreSquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSabreWeaponsBattery", "[IA Aero.] Sabre Battery", 1);
		sabreSquad4.initKammer();
		add(sabreSquad4);

		seperator();

		sabreSquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSabreWeaponsBattery", "[IA Aero.] Sabre Battery", 1);
		sabreSquad5.initKammer();
		add(sabreSquad5);

		seperator();

		specialWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSpezialwaffentrupp", "Spezialwaffentrupp", 1);
		specialWeaponsSquad1.initKammer();
		add(specialWeaponsSquad1);

		seperator();

		specialWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGSpezialwaffentrupp", "Spezialwaffentrupp", 1);
		specialWeaponsSquad2.initKammer();
		add(specialWeaponsSquad2);

		seperator();

		conscriptsSquad = new RuestkammerStarter(ID, randAbstand, cnt, "IGRekrutentrupp", "Rekrutentrupp", 1);
		conscriptsSquad.initKammer();
        conscriptsSquad.setUeberschriftTrotzNullKostenAusgeben(true);
		//conscriptsSquad.setButtonText("Rekrutentrupp . . . . . . . . . 80 Pkt.");
		add(conscriptsSquad);

		complete();
	}

	@Override
	public void refreshen() {
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

		heavyWeaponsSquad1.setAktiv(!sabreSquad5.isSelected());
		heavyWeaponsSquad2.setAktiv(heavyWeaponsSquad1.isSelected() && !sabreSquad4.isSelected());
		heavyWeaponsSquad3.setAktiv(heavyWeaponsSquad2.isSelected() && !sabreSquad3.isSelected());
		heavyWeaponsSquad4.setAktiv(heavyWeaponsSquad3.isSelected() && !sabreSquad2.isSelected());
		heavyWeaponsSquad5.setAktiv(heavyWeaponsSquad4.isSelected() && !sabreSquad1.isSelected());
		
		sabreSquad2.setAktiv(sabreSquad1.isSelected());
		sabreSquad3.setAktiv(sabreSquad2.isSelected());
		sabreSquad4.setAktiv(sabreSquad3.isSelected());
		sabreSquad5.setAktiv(sabreSquad4.isSelected());
		
		specialWeaponsSquad2.setAktiv(specialWeaponsSquad1.isSelected());
	}

	private void checkDraftOption() {
		isDemonHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Daemonenjaeger");
		isWitchHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Hexenjaeger");

		if(isDemonHunters || isWitchHunters) {
			setCountToMinimum(false);
		}

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
