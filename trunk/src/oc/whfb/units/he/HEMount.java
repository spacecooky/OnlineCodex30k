package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HEMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean commander = false;

	public HEMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Kommandant
		// defaults[1] = Erzmagier
		// defaults[2] = Edler
		// defaults[3] = Magier

		this.commander = (defaults[0] || defaults[1]);

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Elfenross"), this.commander ? 18 : 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Elfenross mit Harnisch"), this.commander ? 24 : 16));
		if(!defaults[3]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Riesenadler"), 50));
		if(defaults[0]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Greif"), 200));
		if(defaults[0] || defaults[1]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sonnendrache"), 230));		
		if(defaults[0] || defaults[1]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Monddrache"), 300));
		if(defaults[0]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sternendrache"), 370));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tiranoc-Streitwagen"), 85));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
