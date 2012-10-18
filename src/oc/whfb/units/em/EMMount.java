package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class EMMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public EMMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Saurus Hornnacken Veteran
		// defaults[1] = Saurus Hornnacken
		// defaults[2] = Skin Häuptling
		// defaults[3] = Skink Priester

		if(defaults[0] || defaults[1]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampfechse"), defaults[0] ? 30 : 20));
		if(defaults[0]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Carnosaurus"), 210));
		if(defaults[2]) {			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stegadon"), 235));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ehrwürdiges Stegadon"), 275));			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Terradon"), 30));
		}
		if(defaults[3]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Maschine der Götter"), 290));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
