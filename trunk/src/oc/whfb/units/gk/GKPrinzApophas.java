package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;

public class GKPrinzApophas extends Eintrag {
	
	public GKPrinzApophas(){
		name = BuildaHQ.translate("Prinz Apophas");
		grundkosten = 130;
                
                add(ico = new oc.Picture(this));
                
                seperator();

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
		
		setUnikat(true);
	}
}
