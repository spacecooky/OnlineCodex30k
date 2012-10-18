package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class BTBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;
	boolean isAST = false;

	public BTBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = max. 25 Punkte
		// defaults[1] = max. 50 Punkte
		// defaults[2] = max. 125 Punkte
		// defaults[3] = fahrende Ritter

		int maxCost = 0;
		if(defaults[0]) maxCost = 25;
		if(defaults[1]) maxCost = 50;
		if(defaults[2]) maxCost = 125;
		if(defaults[2]) isAST = true;

		if(maxCost >= 100) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte der Herrin des Sees"), 100));
		if(maxCost >= 50)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte des Heldenmutes"), 50));
		if(maxCost >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner des Schutzes"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zwielichtbanner"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gobelin der Heldentaten"), 25));
		if(defaults[3])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der fahrenden Ritter"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner von Châlons"), 10));
		
		CommonMagicItems.addCommonBanner(ogE, maxCost, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		//if(!isAST) o1.alwaysSelected(); // AST -> Banner is optional
	}

}
