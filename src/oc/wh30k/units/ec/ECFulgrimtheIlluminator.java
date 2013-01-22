package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;

public class ECFulgrimtheIlluminator extends Eintrag {

	public ECFulgrimtheIlluminator() {
		name = "Fulgrim the Illuminator";
		grundkosten = 380;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		BuildaHQ.addToInformationVector("ECPraetor", 1);

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("ECPraetor", -1);
		super.deleteYourself();
	}

}
