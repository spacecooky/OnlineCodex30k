package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;

public class BAMephiston extends Eintrag {

	public BAMephiston() {
		name = "Mephiston";
		grundkosten = 250;

		BuildaHQ.addToInformationVector("BAHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BAMephiston.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("BAHQ", -1);
	}

}
