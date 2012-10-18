package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMStormtalon extends Eintrag {

	public SMStormtalon() {
		name = "Stormtalon";
		grundkosten = 130;


		add(ico = new oc.Picture("oc/wh40k/images/Stormtalon.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("sync. Laserkanone","synchronisierte Laserkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Typhoon-Raketenwerfer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Skyhammer-Raketenwerfer", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();

	}

	public void refreshen() {
	}
}
