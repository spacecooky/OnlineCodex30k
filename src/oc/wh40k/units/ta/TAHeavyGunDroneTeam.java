package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class TAHeavyGunDroneTeam extends Eintrag {

	AnzahlPanel HeavyGunDroneTeam;
	OptionsEinzelZaehler o1;

	public TAHeavyGunDroneTeam() {
		name = "Heavy Gun-Drone Team";
		grundkosten = 0;

		HeavyGunDroneTeam = new AnzahlPanel(ID, randAbstand, cnt, "Heavy Gun-Drone Team", 2, 6, 25);
		add(HeavyGunDroneTeam);

		add(ico = new oc.Picture("oc/wh40k/images/HeavyGunDroneTeam.jpg"));
		

		seperator();

		o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Zielmarker", "Zielmarker statt Pulskanone", HeavyGunDroneTeam.getModelle(), 0);
		add(o1);
		seperator(8);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		o1.setMaxAnzahl(HeavyGunDroneTeam.getModelle());
	}
	
}
