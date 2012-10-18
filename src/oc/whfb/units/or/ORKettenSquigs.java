package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class ORKettenSquigs extends Eintrag {

	AnzahlPanel squad;
	
	public ORKettenSquigs() {
		name = BuildaHQ.translate("Ketten-Squig");
		grundkosten = 65;

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico);		
			
			panel.repaint(); }*/
	}
}
