package oc.necro.sonstige;

import oc.NamePanel;
import oc.Sonstige;

public class Werte extends Sonstige {

    NamePanel guthaben;

	public Werte() {

        add(guthaben = new NamePanel(ID, randAbstand, cnt, "0", "Guthaben"));

        seperator();

		complete();
	}

	@Override
	public void refreshen() {

		
	}

}
