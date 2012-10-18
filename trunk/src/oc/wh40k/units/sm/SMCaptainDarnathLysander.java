package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMCaptainDarnathLysander extends Eintrag {

	public SMCaptainDarnathLysander() {
		name = "Captain Darnath Lysander";
		grundkosten = 200;

		BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);

		add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

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
