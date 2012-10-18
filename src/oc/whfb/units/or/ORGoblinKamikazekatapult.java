package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORGoblinKamikazekatapult extends Eintrag {

	public ORGoblinKamikazekatapult() {
		name = BuildaHQ.translate("Goblin-Kamikazekatapult");
		grundkosten = 80;

		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((250 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
