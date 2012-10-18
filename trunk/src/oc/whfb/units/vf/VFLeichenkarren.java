package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class VFLeichenkarren extends Eintrag {

	OptionsUpgradeGruppe o1;
	
	public VFLeichenkarren() {
		name = BuildaHQ.translate("Leichenkarren");
		grundkosten = 75;
		
		setCountToMinimum(false);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hexenfeuer"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Unheiliger Sog"), 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
