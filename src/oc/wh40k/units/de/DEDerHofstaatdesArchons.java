package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DEDerHofstaatdesArchons extends Eintrag {

    AnzahlPanel squad1;
    AnzahlPanel squad2;
    AnzahlPanel squad3;
    AnzahlPanel squad4;
    RuestkammerStarter rkBarke;
    RuestkammerStarter rkViper;
    RuestkammerStarter rkTantalus;

    public DEDerHofstaatdesArchons() {
        name = "Der Hofstaat des Archons\n";
        grundkosten = 0;
        überschriftSetzen = true;
        setEintragsCNT(0);

        BuildaHQ.addToInformationVector("DEDerHofstaatdesArchons", 1);

        add(ico = new oc.Picture("oc/wh40k/images/DEDerHofstaatdesArchons.jpg"));
        

		add(squad1 = new AnzahlPanel(ID, randAbstand, cnt, "Lhamaeanerin", "Lhamaeanerinnen", 1, 2, 10));
		add(squad2 = new AnzahlPanel(ID, randAbstand, cnt, "Medusid", "Medusiden", 1, 2, 15));
		add(squad3 = new AnzahlPanel(ID, randAbstand, cnt, "Sslyth", "Sslyth", 1, 3, 35));
		add(squad4 = new AnzahlPanel(ID, randAbstand, cnt, "Yr'ghul", "Yr'ghule", 1, 5, 15));

        squad2.setNichtDieErsteOption(true);
        squad3.setNichtDieErsteOption(true);
        squad4.setNichtDieErsteOption(true);

		seperator();

		rkBarke = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenbarke", "Schattenbarke");
		rkBarke.initKammer();
		add(rkBarke);

		rkViper = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenviper", "Schattenviper");
		rkViper.initKammer();
		add(rkViper);

		rkTantalus = new RuestkammerStarter(ID, randAbstand, cnt, "DETantalusKammer", "Tantalus [Forgeworld]");
        rkTantalus.setToolTipText("aus Imperial Armour Apocalypse (Second Edition)");
		rkTantalus.initKammer();
		add(rkTantalus);

        complete();
    }

    @Override
    public void refreshen() {
		int selectedSquads = BuildaHQ.getCountFromInformationVector("DEDerHofstaatdesArchons");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("DEArchon");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Hofstaat > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}

        rkBarke.setAktiv(squad1.getModelle() + squad2.getModelle() + squad3.getModelle() + squad4.getModelle() <= 10 && !rkViper.isSelected() && !rkTantalus.isSelected());
        rkViper.setAktiv(squad1.getModelle() + squad2.getModelle() + squad3.getModelle() + squad4.getModelle() <= 5 && !rkBarke.isSelected() && !rkTantalus.isSelected());
        rkTantalus.setAktiv(squad1.getModelle() + squad2.getModelle() + squad3.getModelle() + squad4.getModelle() <= 16 && !rkBarke.isSelected() && !rkViper.isSelected());
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("DEDerHofstaatdesArchons", -1);
    }

}
