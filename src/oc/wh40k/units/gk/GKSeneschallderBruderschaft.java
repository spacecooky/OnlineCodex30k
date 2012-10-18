package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKSeneschallderBruderschaft extends Eintrag {

	public GKSeneschallderBruderschaft() {
		name = "Seneschall der Bruderschaft";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/GKSeneschallderBruderschaft.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Digitalwaffen", 5));
		ogE.addElement(new OptionsGruppeEintrag("Empyreische Hirnminen", 10));
        ogE.addElement(new OptionsGruppeEintrag("Psiaktive Munition", 5));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
