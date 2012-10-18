package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IGImperialerSchildInfanteriekompanie extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter t4;
	RuestkammerStarter t5;
	RuestkammerStarter t6;
	RuestkammerStarter t7;

        int i = 0;

	public IGImperialerSchildInfanteriekompanie() {
		name = "\"Imperialer Schild\"-Infanteriekompanie";
		grundkosten = 150;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGImperialerSchildInfanteriekompanie.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGCompanyCommandSquadKammer", "", 1);
		t1.initKammer(true);
		t1.setButtonText("Kommandozug");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantryPlatoonKammer", "", 1);
		t2.initKammer(false);
		t2.setButtonText("Infanteriezug");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantryPlatoonKammer", "", 1);
		t3.initKammer(false);
		t3.setButtonText("Infanteriezug");
		add(t3);

		seperator();

		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantryPlatoonKammer", "", 1);
		t4.initKammer(false);
		t4.setButtonText("Infanteriezug");
		add(t4);

		seperator();

		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantryPlatoonKammer", "", 1);
		t5.initKammer(false);
		t5.setButtonText("Infanteriezug");
		add(t5);

		seperator();

		t6 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantryPlatoonKammer", "", 1);
		t6.initKammer(false);
		t6.setButtonText("Infanteriezug");
		add(t6);

		seperator();

		t7 = new RuestkammerStarter(ID, randAbstand, cnt, "IGInfantryPlatoonKammer", "", 1);
		t7.initKammer(false);
		t7.setButtonText("Infanteriezug");
		add(t7);

		complete();
	}

	
	public void refreshen() {
            t1.setLegal(t1.isSelected());
            t2.setLegal(t2.isSelected());
            t3.setLegal(t3.isSelected());
            t4.setLegal(t4.isSelected());
            t5.setAktiv(t4.isSelected() && t3.isSelected() && t2.isSelected() && t1.isSelected());
            t6.setAktiv(t5.isSelected());
            t7.setAktiv(t6.isSelected());
	}

}
