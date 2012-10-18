/* Regeln zu finden unter:
 * http://www.games-workshop.com/MEDIA_CustomProductCatalog/m2430606_Apo_-_Dark_Eldar_-_Karneval_der_Schmerzen.pdf
 */

package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class DEKarnevalKammerGrotesquen extends RuestkammerVater {

	AnzahlPanel squad;
    OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkBoss;
    RuestkammerStarter rkBarke;

    public DEKarnevalKammerGrotesquen() {
		grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Grotesquen", 10, 10, 35);
        squad.setNichtDieErsteOption(true);
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

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe1.setPreis(squad.getModelle() * 5);
        oe1.setAktiv(BuildaHQ.getCountFromInformationVector("DEUrienRakarth") > 0);

        rkBarke.setAktiv(squad.getModelle() <= 10);
    }

}
