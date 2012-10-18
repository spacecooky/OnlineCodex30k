package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DEMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public DEMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Hochgeborener
		// defaults[1] = Erzzauberin
		// defaults[2] = Adliger
		// defaults[3] = Zauberin

		boolean commander = (defaults[0] || defaults[1]);

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dunkelelfenross"), commander ? 18 : 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampfechse"), commander? 30 : 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzer Pegasus"), 50));		
		if(commander || defaults[2]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mantikor"), 200));
		if(commander) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzer Drache"), 320));
		if(defaults[0] || defaults[2]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Echsenstreitwagen"), 90));		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
