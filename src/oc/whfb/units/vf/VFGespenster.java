package oc.whfb.units.vf;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class VFGespenster extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	
	public VFGespenster() {
		name = BuildaHQ.translate("Gespenster");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gespenster"), 3, 10, 50);
		squad.setGrundkosten(0);
		add(squad);
		
		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Banshee"), 25));
		
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
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 4 : 2);
		} catch (Exception e){
			setUnikat(true, 2);
		}
	}

}
