package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;

public class CDUrakaTheWarfiendDaemonPrinceofKhorne extends Eintrag {

	public CDUrakaTheWarfiendDaemonPrinceofKhorne() {
		name = "Uraka \'The Warfiend\' Daemon Prince of Khorne";
		grundkosten = 170;

		add(ico = new oc.Picture("oc/wh40k/images/CDUraka.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
