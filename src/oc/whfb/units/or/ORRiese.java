package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORRiese extends Eintrag {
	
	OptionsEinzelUpgrade o1;
	
	public ORRiese() {
		name = BuildaHQ.translate("Riese");
		grundkosten = 200;
		
		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Kriegsbemalung"), 20));

		complete();
	}

	@Override
	public void refreshen() {	
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((250 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		o1.setAktiv( BuildaHQ.getCountFromInformationVector("WILDORK") > 0);
	}
}
