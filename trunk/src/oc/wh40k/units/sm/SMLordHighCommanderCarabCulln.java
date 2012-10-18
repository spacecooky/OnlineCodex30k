package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMLordHighCommanderCarabCulln extends Eintrag {

	public SMLordHighCommanderCarabCulln() {
		name = "Lord High Commander Carab Culln";
		grundkosten = 215;

		BuildaHQ.addToInformationVector("SMEnableHonourGuard", 1);
		BuildaHQ.addToInformationVector("SMLordHighCommanderCarabCulln", 1);
		BuildaHQ.addToInformationVector("SMChapterMaster", 1);
		BuildaHQ.addToInformationVector("SMOnlyOneChapterMaster", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMMagisterSevrinLoth.gif"));
                
		complete();
	}

	@Override
	public void deleteYourself() {

		BuildaHQ.addToInformationVector("SMEnableHonourGuard", -1);
		BuildaHQ.addToInformationVector("SMLordHighCommanderCarabCulln", -1);
		BuildaHQ.addToInformationVector("SMChapterMaster", -1);
		BuildaHQ.addToInformationVector("SMOnlyOneChapterMaster", -1);

		super.deleteYourself();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
            
            if(BuildaHQ.getCountFromInformationVector("SMChapterMaster") > 1 && BuildaHQ.getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
                setFehlermeldung("nur ein Ordensmeister");
            } else {
                setFehlermeldung("");
            }
            
        }

}
