package oc.whfb.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMJaeger extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	boolean set = false;
	
	public IMJaeger() {
		name = BuildaHQ.translate("Jäger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Jäger"), 10, 20, 10);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 5));

		complete();
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
