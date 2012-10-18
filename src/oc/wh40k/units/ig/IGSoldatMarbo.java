package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;

public class IGSoldatMarbo extends Eintrag {

	public IGSoldatMarbo() {
		name = "Soldat Sly Marbo";
		grundkosten = 65;

		BuildaHQ.addToInformationVector("IGSoldatMarbo", 1);

		add(ico = new oc.Picture("oc/wh40k/images/IGGuaredsmenMarbo.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("IGSoldatMarbo", -1);
	}

}
