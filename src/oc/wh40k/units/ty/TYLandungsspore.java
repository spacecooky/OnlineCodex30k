package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TYLandungsspore extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public TYLandungsspore() {
		grundkosten = 40;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/TYLandungsspore.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("Stachelhagel", 10));
		ogE.addElement(new OptionsGruppeEintrag("Stachelsalve", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Säurespucker", "Synchronisierter Säurespucker", 10));
		ogE.addElement(new OptionsGruppeEintrag("Stachelwürger", 15));
		ogE.addElement(new OptionsGruppeEintrag("Biozidkanone", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
