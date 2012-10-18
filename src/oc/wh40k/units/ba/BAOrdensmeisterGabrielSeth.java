package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;

public class BAOrdensmeisterGabrielSeth extends Eintrag {

	public BAOrdensmeisterGabrielSeth() {
		name = "Ordensmeister Gabriel Seth";
		grundkosten = 160;

		BuildaHQ.addToInformationVector("BAHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BAOrdensmeisterGabrielSeth.jpg"));

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
