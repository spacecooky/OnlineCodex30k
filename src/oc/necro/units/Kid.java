package oc.necro.units;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.ProfilPanel;
import oc.RuestkammerHelper;
import oc.RuestkammerStarter;

public class Kid extends Eintrag {

    RuestkammerHelper[] abt = new RuestkammerHelper[7];
    OptionsEinzelUpgrade oe1;
    RuestkammerStarter rkNKW;
    RuestkammerStarter rkPistolen;
    RuestkammerStarter rkGewehre;
    RuestkammerStarter rkSpezialwaffen;
    RuestkammerStarter rkSchwereWaffen;
    RuestkammerStarter rkGranaten;
    RuestkammerStarter rkAusruestung;
    RuestkammerStarter rkVerletzungen;
    RuestkammerStarter rkFertigkeiten;

	public Kid() {
		grundkosten = 25;

        new ProfilPanel(this, 3);

		add(ico = new oc.Picture("oc/images/necro/Kid.jpg"));

		seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "erstes Spiel"));
        oe1.setSelected(true);

        seperator();

        abt[0] = new Nahkampfwaffen();
        rkNKW = new RuestkammerStarter(ID, randAbstand, cnt, abt[0]);
		rkNKW.initKammer(false);
		rkNKW.setButtonText("Nahkampfwaffen");
        rkNKW.setName("Nahkampfwaffen");
        rkNKW.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkNKW);

		seperator();

        abt[1] = new Pistolen();
        rkPistolen = new RuestkammerStarter(ID, randAbstand, cnt, abt[1]);
		rkPistolen.initKammer(false);
		rkPistolen.setButtonText("Pistolen");
        rkPistolen.setName("Pistolen");
        rkPistolen.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkPistolen);

		seperator();

        abt[5] = new Granaten();
        rkGranaten = new RuestkammerStarter(ID, randAbstand, cnt, abt[5]);
		rkGranaten.initKammer();
		rkGranaten.setButtonText("Granaten");
		rkGranaten.setName("Granaten");
        rkGranaten.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkGranaten);

        seperator();

        abt[6] = new Ausruestung();
        rkAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, abt[6]);
		rkAusruestung.initKammer();
		rkAusruestung.setButtonText("Ausrüstung");
		rkAusruestung.setName("Ausrüstung");
        rkAusruestung.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkAusruestung);

        seperator();

        rkVerletzungen = new RuestkammerStarter(ID, randAbstand, cnt, "Verletzungen", "");
		rkVerletzungen.initKammer();
		rkVerletzungen.setButtonText("Verletzungen");
        rkVerletzungen.setName("Verletzungen");
        rkVerletzungen.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkVerletzungen);

        seperator();

        rkFertigkeiten = new RuestkammerStarter(ID, randAbstand, cnt, "Fertigkeiten", "");
		rkFertigkeiten.initKammer(BuildaHQ.zahlZuBool(3));
		rkFertigkeiten.setButtonText("Fertigkeiten");
        rkFertigkeiten.setName("Fertigkeiten");
        rkFertigkeiten.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkFertigkeiten);

		complete();
	}

	@Override
	public void refreshen() {
        for(int i=0;i<abt.length;i++) {
            if(abt[i] != null) abt[i].specialVoid(oe1.isSelected());
        }
		
	}

}
