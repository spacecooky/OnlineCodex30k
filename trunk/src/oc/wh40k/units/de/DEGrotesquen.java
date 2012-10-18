package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DEGrotesquen extends Eintrag {

	AnzahlPanel squad;
    OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkBoss;
    RuestkammerStarter rkBarke;

	public DEGrotesquen() {
		name = "Grotesquen-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Grotesquen", 3, 10, 35);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEGrotesquen.jpg"));

		seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Säurewerfer", 10));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Stärke +1", 0));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DEAbscheulichkeit", "Upgrade zur Abscheulichkeit");
		rkBoss.initKammer();
		add(rkBoss);

		seperator();

		rkBarke = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenbarke", "Schattenbarke");
		rkBarke.initKammer();
		add(rkBarke);

		complete();
	}

	@Override
	public void refreshen() {
        oe1.setPreis(squad.getModelle() * 5);
        oe1.setAktiv(BuildaHQ.getCountFromInformationVector("DEUrienRakarth") > 0);

        rkBarke.setAktiv(squad.getModelle() <= 5);
	}

}
