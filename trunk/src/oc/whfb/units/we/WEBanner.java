package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppeUnique;
import oc.RuestkammerVater;

public class WEBanner extends RuestkammerVater {

	OptionsUpgradeGruppeUnique o1;

	int maxCosts = 25;

	public WEBanner() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		if(defaults[0])	maxCosts = 100;
		if(defaults[1]) maxCosts = 50;
		
		if(maxCosts >= 100) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ariels Standarte"), 100));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mittwinterbanner"), BuildaHQ.translate("Gaemrath - Mittwinterbanner"), 50));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Herbstlaubbanner"), BuildaHQ.translate("Faoghir - Herbstlaubbanner"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Brillanz"), BuildaHQ.translate("Saemrath - Brillanz"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Frühlingserwachen"), BuildaHQ.translate("Aech - Frühlingserwachen"), 25));
		
		CommonMagicItems.addCommonBanner(ogE, maxCosts, 25);
		
		add(o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Magische Standarten"));
		sizeSetzen();
		
	}

	@Override
	public void refreshen() {
		if(maxCosts != 100) if(!o1.isSelected()) o1.setSelected(0, true);
	}
}
