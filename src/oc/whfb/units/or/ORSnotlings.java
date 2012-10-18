package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class ORSnotlings extends Eintrag {

	AnzahlPanel squad;

	public ORSnotlings() {
		name = BuildaHQ.translate("Snotlings");
		grundkosten = 0;

		setCountToMinimum(false); // Unit cannot resolve minimum number of core units

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Snotlingbase"), BuildaHQ.translate("Snotlingbases"), 2, 100, 30);
		squad.setGrundkosten(0);
		add(squad);

		complete();
	}

	@Override
	public void refreshen() {
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}

}
