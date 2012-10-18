package oc.whfb.units.og;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;

public class OGSaebelzahnrudel extends Eintrag {

	AnzahlPanel squad;
	
	public OGSaebelzahnrudel() {
		name = BuildaHQ.translate("S�belzahnrudel");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("S�belzahnrudel"), 1, 10, 21);
		squad.setGrundkosten(0);
		add(squad);

		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		try {
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 6 : 3);
		} catch (Exception e){
			setUnikat(true, 3);
		}
	}
}
