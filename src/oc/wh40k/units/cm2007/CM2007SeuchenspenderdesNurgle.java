package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CM2007SeuchenspenderdesNurgle extends Eintrag {

	public CM2007SeuchenspenderdesNurgle() {
		name = "Seuchenspender des Nurgle";
		grundkosten = 450;

		add(ico = new oc.Picture("oc/wh40k/images/SeuchenspenderdesNurgle.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Synchronisierter Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
