package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;

public class SWUlrikderTodeswolf extends Eintrag {

	public SWUlrikderTodeswolf() {
		name = "Ulrik der Todeswolf";
		grundkosten = 180;

		BuildaHQ.addToInformationVector("SWHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SWUlrikderTodeswolf.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
		// If this is the only HQ, count it as 1 (otherwise 0.5)
		if( BuildaHQ.getCountFromInformationVector("SWHQ") == 1 ) {
				setEintragsCNT(1);
		} else {
				setEintragsCNT(0.5);
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("SWHQ", -1);
	}

}
