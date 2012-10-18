package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMCaptainZhrukhalAndrocles extends Eintrag {

	public SMCaptainZhrukhalAndrocles() {
		name = "Captain Zhrukhal Androcles";
		grundkosten = 155;

		BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));
                
		complete();
	}

	@Override
	public void deleteYourself() {

		BuildaHQ.addToInformationVector("SMEnableCommandSquad", -1);

		super.deleteYourself();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
            
        }

}
