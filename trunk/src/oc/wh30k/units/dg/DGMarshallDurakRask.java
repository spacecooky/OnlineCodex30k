package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;

public class DGMarshallDurakRask extends Eintrag {

	public DGMarshallDurakRask() {
		name = "Marshall Durak Rask";
		grundkosten = 165;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		BuildaHQ.addToInformationVector("DGPraetor", 1);

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("DGPraetor", -1);
		super.deleteYourself();
	}

}
