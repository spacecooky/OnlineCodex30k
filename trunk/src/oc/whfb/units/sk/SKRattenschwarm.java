package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;

public class SKRattenschwarm extends Eintrag {

	AnzahlPanel squad;
	
	public SKRattenschwarm() {
		name = BuildaHQ.translate("Rattenschwarm");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Rattenschwarm"), 2, 10, 25);		
		squad.setGrundkosten(0);
		add(squad);
		
		setCountToMinimum(false); // Unit cannot resolve minimum number of core units
		
		complete();
	}

	@Override
	public void refreshen(){
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
