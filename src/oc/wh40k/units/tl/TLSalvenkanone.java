package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TLSalvenkanone extends Eintrag {

	RuestkammerStarter rkPod;

	public TLSalvenkanone() {
		name = "Salvenkanone";
		grundkosten = 100;

		BuildaHQ.addToInformationVector("TLSupport", 1);
		
		add(ico = new oc.Picture("oc/wh40k/images/SMSalvenkanone.jpg"));

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "TLDropPodKammer", "Landungskapsel");
		rkPod.initKammer(false);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void refreshen() {
		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLSupport");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHeavySupport");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("SM-Unterstützung > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}
	
	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TLSupport", -1);
		super.deleteYourself();
	}

}
