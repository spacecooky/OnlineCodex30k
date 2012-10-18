package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IGKommissarYarrick extends Eintrag {

	RuestkammerStarter rkTransport;

	public IGKommissarYarrick() {
		name = "Kommissar Yarrick";
		grundkosten = 185;

		BuildaHQ.addToInformationVector("IGCommissarYarrick", 1);

		add(ico = new oc.Picture("oc/wh40k/images/IGCommissarYarrick.jpg"));
		

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("IGCommissarYarrick") > 1) {
			setFehlermeldung("0-1 Auswahl!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("IGCommissarYarrick", -1);
	}

}
