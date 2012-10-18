package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;

public class NEOrikanderSeher extends Eintrag {
    
	public NEOrikanderSeher() {
		name = "Orikan der Seher";
		grundkosten = 165;

		add(ico = new oc.Picture("oc/wh40k/images/NEOrikanderSeher.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
