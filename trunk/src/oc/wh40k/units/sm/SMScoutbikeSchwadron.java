package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class SMScoutbikeSchwadron extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;

	public SMScoutbikeSchwadron() {
		name = "Scoutbike-Schwadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Scouts auf Bike", 3, 10, 20);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ScoutbikeSchwadron.gif"));

		seperator();

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Granatwerfer", "Astartes-Granatwerfer", 3, 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Splitterminen", 10));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, true, false, true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		// This Sarge may only change ONE weapon
		rkBoss.getKammer().switchEntry("ScoutBikeSarge", true);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
	}

}
