package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SWNjalSturmbringer extends Eintrag {

	public SWNjalSturmbringer() {
		name = "Njal Sturmbringer";
		grundkosten = 245;

		BuildaHQ.addToInformationVector("SWHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SWNjalSturmbringer.jpg"));
		
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminator-Runenrüstung", 25));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
		// If this is the only HQ, count it as 1 (otherwise 0.5)
		if( BuildaHQ.getCountFromInformationVector("SWHQ") == 1 ) {
				setEintragsCNT(1);
		} else {
				setEintragsCNT(0.5);
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("SWHQ", -1);
	}
	
}
