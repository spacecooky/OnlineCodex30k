package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DEInccubi extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
    RuestkammerStarter rkBarke;
    RuestkammerStarter rkViper;

	public DEInccubi() {
		name = "Inccubi-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Inccubi", 3, 10, 22);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEInccubi.jpg"));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DEKlaivex", "Upgrade zum Klaivex");
		rkBoss.initKammer();
		add(rkBoss);

		seperator();

		rkBarke = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenbarke", "Schattenbarke");
		rkBarke.initKammer();
		add(rkBarke);

		rkViper = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenviper", "Schattenviper");
		rkViper.initKammer();
		add(rkViper);

		complete();
	}

	@Override
	public void refreshen() {
        rkBarke.setAktiv(squad.getModelle() <= 10 && !rkViper.isSelected());
        rkViper.setAktiv(squad.getModelle() <= 5 && !rkBarke.isSelected());
	}

}
