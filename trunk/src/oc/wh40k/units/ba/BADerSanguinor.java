package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;

public class BADerSanguinor extends Eintrag {

	public BADerSanguinor() {
		name = "Der Sanguinor";
		grundkosten = 275;

		BuildaHQ.addToInformationVector("BAHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BADerSanguinor.jpg"));

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
