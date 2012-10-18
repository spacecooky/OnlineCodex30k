package oc.wh40k.units.rh;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class RHRenegadeOgrynBerserkers extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkTransport;

	boolean lastState = false;

	public RHRenegadeOgrynBerserkers() {
		name = "Renegade Ogryn Berserkers";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ogryn Berserkers", 2, 5, 40);
		squad.setGrundkosten(10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGOgrynSquad.jpg"));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power weapon",15));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
