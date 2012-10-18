package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;

public class BAAstorathderUnerbittliche extends Eintrag {

	public BAAstorathderUnerbittliche() {
		name = "Astorath der Unerbittliche";
		grundkosten = 220;

		BuildaHQ.addToInformationVector("BAHQ", 1);
		BuildaHQ.addToInformationVector("BAAstorath", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BAAstorathderUnerbittliche.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        this.setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("BAHQ", -1);
		BuildaHQ.addToInformationVector("BAAstorath", -1);
	}

}
