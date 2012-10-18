package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class ORSteintrolle extends Eintrag {

	AnzahlPanel squad;
	
	public ORSteintrolle() {
		name = BuildaHQ.translate("Steintrolle");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Steintroll"), BuildaHQ.translate("Steintrolle"), 1, 100, 45);
		squad.setGrundkosten(0);
		add(squad);
		
		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {			
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/ORTrolle1" + JPG);
						
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico);		
			
			panel.repaint(); }*/
	}
}
