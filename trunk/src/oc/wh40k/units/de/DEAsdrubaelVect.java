package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DEAsdrubaelVect extends Eintrag {

	public DEAsdrubaelVect() {
		name = "Asdrubael Vect";
		grundkosten = 240;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        BuildaHQ.addToInformationVector("DEArchon", 1);

		add(ico = new oc.Picture("oc/wh40k/images/DEAsdrubaelVect.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bote der Zerstörung", 200));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
        BuildaHQ.addToInformationVector("DEHQ", -1);
        BuildaHQ.addToInformationVector("DEArchon", -1);
	}

}
