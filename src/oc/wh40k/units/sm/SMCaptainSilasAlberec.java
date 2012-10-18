package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMCaptainSilasAlberec extends Eintrag {

	public SMCaptainSilasAlberec() {
		name = "Captain Silas Alberec";
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
