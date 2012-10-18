package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;

public class TYDerSchwarmherrscher extends Eintrag {

	public TYDerSchwarmherrscher() {
		name = "Der Schwarmherrscher";
		grundkosten = 280;

		BuildaHQ.addToInformationVector("TYTyrant", 1);

		add(ico = new oc.Picture("oc/wh40k/images/TYDerSchwarmherrscher.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
        super.deleteYourself();
		BuildaHQ.addToInformationVector("TYTyrant", -1);
	}

}
