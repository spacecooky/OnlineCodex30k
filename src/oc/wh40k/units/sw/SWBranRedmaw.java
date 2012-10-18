package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;

public class SWBranRedmaw extends Eintrag {

	public SWBranRedmaw() {
		name = "Bran Redmaw";
		grundkosten = 210;

                BuildaHQ.addToInformationVector("SWHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SWBranRedmaw.jpg"));
		

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
