package oc.whfb.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;

public class GKGrabjaeger extends Eintrag {

	AnzahlPanel squad;
	
	public GKGrabjaeger() {
		name = BuildaHQ.translate("Grabjäger");
		grundkosten = 0;
                
//                ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//                ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//                panel.add(ico);
                add(ico = new oc.Picture(this));

                seperator();
                        
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Grabjäger"), 3, 100, 55);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
