package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class VFBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;		
	int maxCosts = 25;
	boolean isAST = false;

	public VFBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = AST
		// defaults[1] = Blutritter
		// defaults[2] = Verfluchte/ Fluchritter

		isAST = defaults[0];
		if(defaults[0]) maxCosts = 125;
		if(defaults[1]) maxCosts = 75;
		if(defaults[2]) maxCosts = 50;
		
		if(maxCosts >= 125) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drakenhofbanner"), 125));
		if(maxCosts >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Blutfeste"), 75));
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Hügelgräber"), 45));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kreischendes Banner"), 40));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Königliche Standarte"), BuildaHQ.translate("Königliche Standarte von Strigos"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ikone der Vergeltung"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der toten Legion"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Fluchfahne Mousillons"), BuildaHQ.translate("Fluchfahne von Mousillon"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Banner der Albträume"), BuildaHQ.translate("Banner der ewigen Albträume"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte d. Lebenskraft"), BuildaHQ.translate("Standarte der höllischen Lebenskraft"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Standarte des Untods"), BuildaHQ.translate("Standarte des immerwährenden Untodes"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Höllenfeuerbanner"), 10));
		
		CommonMagicItems.addCommonBanner(ogE, maxCosts, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		if(!isAST) if(!o1.isSelected()) o1.setSelected(0, true);
		setButtonState(BuildaHQ.noErrors);
	}
}
