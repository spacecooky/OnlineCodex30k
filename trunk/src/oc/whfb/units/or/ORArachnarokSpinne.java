package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORArachnarokSpinne extends Eintrag {

	
	public ORArachnarokSpinne() {
		name = BuildaHQ.translate("Arachnarok-Spinne");
		grundkosten = 290;

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Netzschleuda"), 30));
		
		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
