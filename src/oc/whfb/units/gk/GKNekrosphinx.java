package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class GKNekrosphinx extends Eintrag {

	OptionsEinzelUpgrade oe1;

	public GKNekrosphinx() {
		name = BuildaHQ.translate("Nekrosphinx");
		grundkosten = 225;
                
                add(ico = new oc.Picture(this));
                
                seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Giftstachel"), 10));
		
		complete();
	}
	@Override
	public void refreshen() {
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
}
