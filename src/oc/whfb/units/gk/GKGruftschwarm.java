package oc.whfb.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class GKGruftschwarm extends Eintrag {

	AnzahlPanel squad;
	boolean set = false;

	public GKGruftschwarm() {
		name = BuildaHQ.translate("Gruftschwarm");
		grundkosten = 0;
                
                add(ico = new oc.Picture(this));
                
                seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gruftschwarm"), 2, 10, 40);
		squad.setGrundkosten(0);
		add(squad);

		complete();
	}

	@Override
	public void refreshen() {
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((250 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
}
