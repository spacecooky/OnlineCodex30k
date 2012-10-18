package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class VFBlutritterKammer extends RuestkammerVater {

	OptionsZaehlerGruppe oe1;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsUpgradeGruppe o5;
	OptionsZaehlerGruppe oe2;

	public VFBlutritterKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Könige"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Grabklinge"), 25));		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hexenfeuerlanze"), 10));
		
		CommonMagicItems.addCommonWeapons(ogE, 25, 15, 15, 15, 5);
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
	}

}
