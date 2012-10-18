package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.whfb.armies.VOLKOgerAB2004;

public class OG2004GnoblarSchrottschleuder extends Eintrag {

	public OG2004GnoblarSchrottschleuder() {
		name = BuildaHQ.translate("Gnoblar-Schrottschleuder");
		grundkosten = 165;

		add(ico = new oc.Picture("oc/whfb/images/OGGnoblarSchrottschleuder.jpg"));
		
		VOLKOgerAB2004.SCHROTTSCHLEUDER ++;
		
		complete();
	}

	@Override
	public void refreshen() {
		int maxSelection = BuildaHQ.getCountFromInformationVector("OGFallensteller") + VOLKOgerAB2004.GNOBLERKRIEGER;
		
		if(VOLKOgerAB2004.SCHROTTSCHLEUDER > maxSelection) {
			setFehlermeldung("0-" + maxSelection + " " + BuildaHQ.translate("Auswahl"));
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		VOLKOgerAB2004.SCHROTTSCHLEUDER --;
		super.deleteYourself();
	}
}
