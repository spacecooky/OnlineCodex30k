package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BDCGabe extends RuestkammerVater {

	OptionsUpgradeGruppe og;

	public BDCGabe() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
        
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Vielarmige Bestie"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gewaltige Hauer"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verwachsene Haut"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rune der wahren Bestie"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Übernatürliche Sinne"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schattenfell"), 5));
		
		add(og = new OptionsUpgradeGruppe(ID, randAbstand + 10, cnt, "", ogE));
		setHeadline(og, BuildaHQ.translate("Gaben des Chaos"));
		setUeberschrift(BuildaHQ.translate("Gaben des Chaos"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
	}

}
