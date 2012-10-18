package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;

public class NETombStalker extends Eintrag {

    public NETombStalker() {
        name = "Tomb Stalker";
        grundkosten = 205;

        add(ico = new oc.Picture("oc/wh40k/images/NETombStalker.jpg"));
        

        BuildaHQ.addToInformationVector("NonNecronUnits", 1);

        complete();
    }

    @Override
    public void refreshen() {
    }

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("NonNecronUnits", -1);
		super.deleteYourself();
	}

}
