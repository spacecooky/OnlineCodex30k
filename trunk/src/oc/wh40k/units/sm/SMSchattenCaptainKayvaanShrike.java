package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMSchattenCaptainKayvaanShrike extends Eintrag {

	public SMSchattenCaptainKayvaanShrike() {
		name = "Schatten-Captain Kayvaan Shrike";
		grundkosten = 195;

		BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMSchattenCaptainKayvaanShrike.jpg"));

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
