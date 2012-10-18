package oc.wh40k.units.as;

import oc.BuildaHQ;
import oc.Eintrag;

public class ASErzkonfessorKyrinov extends Eintrag {

	public ASErzkonfessorKyrinov() {
		name = "Erzkonfessor Kyrinov";
		grundkosten = 90;
        
        BuildaHQ.addToInformationVector("ASKonfessor", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASErzkonfessorKyrinov.jpg"));

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
