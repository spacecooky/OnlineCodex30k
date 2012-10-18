package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMMagisterSevrinLoth extends Eintrag {

	public SMMagisterSevrinLoth() {
		name = "Magister Sevrin Loth";
		grundkosten = 205;

		BuildaHQ.addToInformationVector("SMEnableHonourGuard", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMMagisterSevrinLoth.gif"));
                
		complete();
	}

	@Override
	public void deleteYourself() {

		BuildaHQ.addToInformationVector("SMEnableHonourGuard", -1);

		super.deleteYourself();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
            
        }

}
