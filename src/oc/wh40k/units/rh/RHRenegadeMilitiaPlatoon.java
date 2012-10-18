package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class RHRenegadeMilitiaPlatoon extends Eintrag {

	RuestkammerStarter commandSquad;
	RuestkammerStarter infantrySquad1;
	RuestkammerStarter infantrySquad2;
	RuestkammerStarter infantrySquad3;
	RuestkammerStarter infantrySquad4;
	RuestkammerStarter infantrySquad5;

	public RHRenegadeMilitiaPlatoon() {
		name = "Renegade Militia Platoon";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/RHRenegadeMilitiaPlatoon.jpg"));
		

		seperator();

		commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "RHMilitiaCommandSquadKammer", "Militia Command Squad", 1);
		commandSquad.initKammer();
		add(commandSquad);

		seperator();

		infantrySquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "RHMilitiaSquadKammer", "Militia Squad", 1);
		infantrySquad1.initKammer();
		add(infantrySquad1);

		seperator();

		infantrySquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "RHMilitiaSquadKammer", "Militia Squad", 1);
		infantrySquad2.initKammer();
		add(infantrySquad2);

		seperator();

		infantrySquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "RHMilitiaSquadKammer", "Militia Squad", 1);
		infantrySquad3.initKammer();
		add(infantrySquad3);

		seperator();

		infantrySquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "RHMilitiaSquadKammer", "Militia Squad", 1);
		infantrySquad4.initKammer();
		add(infantrySquad4);

		seperator();

		infantrySquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "RHMilitiaSquadKammer", "Militia Squad", 1);
		infantrySquad5.initKammer();
		add(infantrySquad5);

		complete();
	}

	@Override
	public void refreshen() {
		commandSquad.setLegal(commandSquad.isSelected());
		infantrySquad1.setLegal(infantrySquad1.isSelected());
		infantrySquad2.setLegal(infantrySquad2.isSelected());
		infantrySquad3.setAktiv(infantrySquad2.isSelected());
		infantrySquad4.setAktiv(infantrySquad3.isSelected());
		infantrySquad5.setAktiv(infantrySquad4.isSelected());	
	}
}
