package oc.whfb.units.og;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class OGGnoblars extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC, oeM, oeS, oeT;
	
	public OGGnoblars() {
		name = BuildaHQ.translate("Gnoblars");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gnoblars"), 10, 100, 2.5);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 5));

		seperator();
		
		add(oeT = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Gnoblar Fallensteller"), 25));
		
		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			if(oeT.isSelected()){
				ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/OGGnoblarFallensteller" + JPG);
			} else {
				ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			}
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
