package oc.necro.sonstige;

import oc.RuestkammerStarter;
import oc.Sonstige;

public class Waffen extends Sonstige {

    RuestkammerStarter rkNKW;
    RuestkammerStarter rkPistolen;
    RuestkammerStarter rkGewehre;
    RuestkammerStarter rkSpezialwaffen;
    RuestkammerStarter rkSchwereWaffen;
    RuestkammerStarter rkGranaten;


	public Waffen() {
        titel = "Waffen in der Waffenkammer";

        rkNKW = new RuestkammerStarter(ID, randAbstand, cnt, "Nahkampfwaffen", "");
		rkNKW.initKammer(true);
		rkNKW.setButtonText("Nahkampfwaffen");
        rkNKW.setName("Nahkampfwaffen");
        rkNKW.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkNKW);

		seperator();

        rkPistolen = new RuestkammerStarter(ID, randAbstand, cnt, "Pistolen", "");
		rkPistolen.initKammer(true);
		rkPistolen.setButtonText("Pistolen");
        rkPistolen.setName("Pistolen");
        rkPistolen.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkPistolen);

		seperator();

        rkGewehre = new RuestkammerStarter(ID, randAbstand, cnt, "Gewehre", "");
		rkGewehre.initKammer(true);
		rkGewehre.setButtonText("Gewehre");
        rkGewehre.setName("Gewehre");
        rkGewehre.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkGewehre);

		seperator();

        rkSpezialwaffen = new RuestkammerStarter(ID, randAbstand, cnt, "Spezialwaffen", "");
		rkSpezialwaffen.initKammer(true);
		rkSpezialwaffen.setButtonText("Spezialwaffen");
		rkSpezialwaffen.setName("Spezialwaffen");
        rkSpezialwaffen.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkSpezialwaffen);

		seperator();

        rkSchwereWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "SchwereWaffen", "");
		rkSchwereWaffen.initKammer();
		rkSchwereWaffen.setButtonText("schwere Waffen");
		rkSchwereWaffen.setName("schwere Waffen");
        rkSchwereWaffen.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkSchwereWaffen);

		seperator();

        rkGranaten = new RuestkammerStarter(ID, randAbstand, cnt, "Granaten", "");
		rkGranaten.initKammer();
		rkGranaten.setButtonText("Granaten");
		rkGranaten.setName("Granaten");
        rkGranaten.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkGranaten);

		complete();
	}

	@Override
	public void refreshen() {

		
	}

}
