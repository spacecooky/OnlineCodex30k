
package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007NoiseMarinesKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelZaehler o1;
	OptionsEinzelUpgrade o2;
	RuestkammerStarter rkRhino;
	RuestkammerStarter rkBoss;

	public CM2007NoiseMarinesKammer() {
            grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Noise Marines";
            grundkosten = 0;

            squad = new AnzahlPanel(ID, randAbstand, cnt, "Noise Marines", 5, 20, 20);
            add(squad);

            add(ico = new oc.Picture("oc/wh40k/images/NoiseMarines.gif"));
            

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Persönliche Ikone", 5));

            seperator(5);

            add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sonic Blaster", squad.getModelle(), 5));
            add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blastmaster", 40));

            seperator();

            rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Noise Marine Champion", 2);
            rkBoss.setGrundkosten(15);
            rkBoss.initKammer(true, false, false, false);
            rkBoss.setButtonText("Noise Marine Champion", false);
            rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
            add(rkBoss);

            seperator();

            rkRhino = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter", 2);
            rkRhino.initKammer();
            rkRhino.setButtonText("Transporter");
            add(rkRhino);

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            o1.setMaxAnzahl(squad.getModelle() - (o2.isSelected() ? 1 : 0) - (rkBoss.isSelected() ? 1 : 0));
	}

}
