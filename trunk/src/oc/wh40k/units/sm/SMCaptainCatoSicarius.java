package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMCaptainCatoSicarius extends Eintrag {

	public SMCaptainCatoSicarius() {
		name = "Captain Cato Sicarius";
		grundkosten = 200;

		BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMCaptainCatoSicarius.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("SMEnableCommandSquad", -1);
		super.deleteYourself();
	}
	
}
