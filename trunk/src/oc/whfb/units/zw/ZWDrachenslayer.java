package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ZWDrachenslayer extends Eintrag {

	RuestkammerStarter rkRunen;
	
	public ZWDrachenslayer() {
		name = BuildaHQ.translate("Drachenslayer");
		grundkosten = 50;

		seperator(12);
		
		rkRunen = new RuestkammerStarter(ID, randAbstand, cnt, "ZWRunen", "");
		rkRunen.initKammer(false, false, true, false, false, false);
		rkRunen.setButtonText(BuildaHQ.translate("Runen"));
		add(rkRunen);

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
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}
}
