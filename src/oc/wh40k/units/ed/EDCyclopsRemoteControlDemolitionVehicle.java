package oc.wh40k.units.ed;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class EDCyclopsRemoteControlDemolitionVehicle extends Eintrag {

	AnzahlPanel squad;

	public EDCyclopsRemoteControlDemolitionVehicle() {
		name = "Cyclops Remote Control Demolition Vehicle";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Cyclops", 1, 3, 35);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGVendettaGunshipSquadron.jpg"));

        complete();
	}

	@Override
	public void refreshen() {
	}

}
