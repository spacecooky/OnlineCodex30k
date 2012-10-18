package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMOrdensmeisterPedroKantor extends Eintrag {

	public SMOrdensmeisterPedroKantor() {
		name = "Ordensmeister Pedro Kantor";
		grundkosten = 175;

		BuildaHQ.addToInformationVector("SMEnableHonourGuard", 1);
                
		BuildaHQ.addToInformationVector("SMChapterMaster", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMOrdensmeisterPedroKantor.jpg"));

		seperator();

		complete();
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

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("SMEnableHonourGuard", -1);
                BuildaHQ.addToInformationVector("SMChapterMaster", -1);
		super.deleteYourself();
	}

}
