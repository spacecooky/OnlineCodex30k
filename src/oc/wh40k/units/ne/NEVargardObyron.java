package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;

public class NEVargardObyron extends Eintrag {

	public NEVargardObyron() {
		name = "Vargard Obyron";
		grundkosten = 160;
        
		add(ico = new oc.Picture("oc/wh40k/images/NEVargardObyron.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        
        boolean hasNemesor = BuildaHQ.getCountFromInformationVector("NENemesorZanndrekh") > 0;
        setEintragsCNT(hasNemesor ? 0.0 : 1.0);
	}

}
