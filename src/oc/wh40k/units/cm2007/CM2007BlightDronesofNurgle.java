package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CM2007BlightDronesofNurgle extends Eintrag {

    OptionsEinzelUpgrade o1;
    OptionsEinzelUpgrade o2;

	public CM2007BlightDronesofNurgle() {
//		name = "Blight Drones of Nurgle";
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/CMBlightDroneofNurgle.jpg"));

        add(new AnzahlPanel(ID, randAbstand, cnt, "Blight Drone of Nurgle", "Blight Drones of Nurgle", 1, 3, 125));

        seperator();

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mawcannon", 0));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zwillingsmaschkan.", "Zwillingsmaschinenkanone", 0));
//      auch wenns sinnlos ist, bitte nicht entfernen, da sonst die Fehlermeldung nicht richtig angezeigt wird

		complete();
	}

	@Override
	public void refreshen() {
        o1.setSelected(true);
        o2.setSelected(true);
        
	}

}
