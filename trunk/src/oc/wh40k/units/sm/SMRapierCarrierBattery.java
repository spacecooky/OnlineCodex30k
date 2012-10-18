package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;

public class SMRapierCarrierBattery extends Eintrag {

	AnzahlPanel squad;

	public SMRapierCarrierBattery() {
		name = "Rapier Carrier Battery\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Rapier","Rapiers", 1, 3, 60);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMRapierCarrierBattery.jpg"));

		complete();

	}

	@Override
	public void refreshen() {
        
	}

}

