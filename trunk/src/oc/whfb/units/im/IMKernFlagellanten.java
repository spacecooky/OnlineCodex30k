package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.BuildaMenu;

public class IMKernFlagellanten extends IMFlagellanten {

	boolean set = false;

	public IMKernFlagellanten() {
		super();
	}

	@Override
	public void refreshen() {
		setUnikat(true);
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
