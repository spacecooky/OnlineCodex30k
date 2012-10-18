package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class GKGefolgedesInquisitors extends Eintrag {

    RuestkammerStarter rk1;
    RuestkammerStarter rk2;
    RuestkammerStarter rk3;
    RuestkammerStarter rk4;
    RuestkammerStarter rk5;
    RuestkammerStarter rk6;
    RuestkammerStarter rk7;
    RuestkammerStarter rk8;
    RuestkammerStarter rk9;
    RuestkammerStarter rk10;
    RuestkammerStarter rkTransport;

	public GKGefolgedesInquisitors() {
		name = "Gefolge des Inquisitors";
		grundkosten = 0;
        überschriftSetzen = true;
//        setEintragsCNT(0.0);

        BuildaHQ.addToInformationVector("GKGefolge", 1);

		add(ico = new oc.Picture("oc/wh40k/images/GKGefolgedesInquisitors.jpg"));

        rk1 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeArcoFlagellanten", "");
        rk1.initKammer();
        rk1.setButtonText("Arco-Flagellanten");
        rk1.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk1);

        rk2 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeHeilige", "");
        rk2.initKammer();
        rk2.setButtonText("Heilige");
        rk2.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk2);

        rk3 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeKreuzritter", "");
        rk3.initKammer();
        rk3.setButtonText("Kreuzritter");
        rk3.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk3);

        rk4 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeBesessene", "");
        rk4.initKammer();
        rk4.setButtonText("Besessene");
        rk4.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk4);

        rk5 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeTodeskultAssassinen", "");
        rk5.initKammer();
        rk5.setButtonText("Todeskult-Assassinen");
        rk5.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk5);

        rk6 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeServitoren", "");
        rk6.initKammer();
        rk6.setButtonText("Inquisitions-Servitoren");
        rk6.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk6);

        rk7 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeJokaeroWaffenschmiede", "");
        rk7.initKammer();
        rk7.setButtonText("Jokaero-Waffenschmiede");
        rk7.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk7);

        rk8 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeMystiker", "");
        rk8.initKammer();
        rk8.setButtonText("Mystiker");
        rk8.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk8);

        rk9 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgePsioniker", "");
        rk9.initKammer();
        rk9.setButtonText("Psioniker");
        rk9.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk9);

        rk10 = new RuestkammerStarter(ID, randAbstand, cnt, "GKGefolgeKriegerAkolythen", "");
        rk10.initKammer();
        rk10.setButtonText("Krieger-Akolythen");
        rk10.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk10);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "GKTransporterKammer", "Transporter");
		rkTransport.initKammer(true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(getKategorie() == 2) setEintragsCNT(0);
        if(getKategorie() == 3) setEintragsCNT(1);

        int models =
            (rk1.isSelected() ? (Integer)rk1.getKammer().getSpecialValue() : 0) +
            (rk2.isSelected() ? (Integer)rk2.getKammer().getSpecialValue() : 0) +
            (rk3.isSelected() ? (Integer)rk3.getKammer().getSpecialValue() : 0) +
            (rk4.isSelected() ? (Integer)rk4.getKammer().getSpecialValue() : 0) +
            (rk5.isSelected() ? (Integer)rk5.getKammer().getSpecialValue() : 0) +
            (rk6.isSelected() ? (Integer)rk6.getKammer().getSpecialValue() : 0) +
            (rk7.isSelected() ? (Integer)rk7.getKammer().getSpecialValue() : 0) +
            (rk8.isSelected() ? (Integer)rk8.getKammer().getSpecialValue() : 0) +
            (rk9.isSelected() ? (Integer)rk9.getKammer().getSpecialValue() : 0) +
            (rk10.isSelected() ? (Integer)rk10.getKammer().getSpecialValue() : 0);

        rk1.setLegal(models >= 3 && models <= 12);
        rk2.setLegal(models >= 3 && models <= 12);
        rk3.setLegal(models >= 3 && models <= 12);
        rk4.setLegal(models >= 3 && models <= 12);
        rk5.setLegal(models >= 3 && models <= 12);
        rk6.setLegal(models >= 3 && models <= 12);
        rk7.setLegal(models >= 3 && models <= 12);
        rk8.setLegal(models >= 3 && models <= 12);
        rk9.setLegal(models >= 3 && models <= 12);
        rk10.setLegal(models >= 3 && models <= 12);

        int maxCount = BuildaHQ.getCountFromInformationVector("GKInquisitor");
        int count = BuildaHQ.getCountFromInformationVector("GKGefolge");

        if(count > maxCount) {
            setFehlermeldung("Anzahl: 0-" + maxCount);
        } else {
            if(models >=3 && models <= 12) {
                setFehlermeldung("");
            } else {
                setFehlermeldung("Pflicht: 3-12 Modelle");
            }
        }
	}

	@Override
	public void deleteYourself() {
        BuildaHQ.addToInformationVector("GKGefolge", -1);
        try {
            super.deleteYourself();
        } catch(Exception ex) {
        }
	}

}
