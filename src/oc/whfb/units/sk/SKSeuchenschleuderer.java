package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SKSeuchenschleuderer extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	
	public SKSeuchenschleuderer() {
		name = BuildaHQ.translate("Seuchenschleuderer");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Seuchenschleuderer"), 5, 100, 16);		
		squad.setGrundkosten(0);
		add(squad);
		
		seperator();
		
		add(oe1= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 13));

		complete();
	}

	@Override
	public void refreshen(){	
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
