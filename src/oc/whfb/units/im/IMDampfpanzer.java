package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;

public class IMDampfpanzer extends Eintrag {

	public IMDampfpanzer() {
		name = BuildaHQ.translate("Dampfpanzer");
		grundkosten = 300;

		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((250 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		try {
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 4 : 2);
		} catch (Exception e){
			setUnikat(true, 2);
		}
	}
}
