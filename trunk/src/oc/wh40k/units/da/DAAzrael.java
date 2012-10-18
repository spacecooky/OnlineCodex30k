package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;

public class DAAzrael extends Eintrag {

	public DAAzrael() {
		name = "Azrael";
		grundkosten = 225;

		add(ico = new oc.Picture("oc/wh40k/images/DAAzrael.gif"));
		

		seperator();

		BuildaHQ.addToInformationVector("DAAzrael", 1);

		complete();
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("DAAzrael", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
