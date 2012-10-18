package oc.wh40k.units.as;

import oc.BuildaHQ;
import oc.Eintrag;

public class ASUriahJacobus extends Eintrag {

	public ASUriahJacobus() {
		name = "Uriah Jacobus";
		grundkosten = 90;
        
        BuildaHQ.addToInformationVector("ASKonfessor", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASUriahJacobus.jpg"));

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
		BuildaHQ.addToInformationVector("ASKonfessor", -1);
	}

}
