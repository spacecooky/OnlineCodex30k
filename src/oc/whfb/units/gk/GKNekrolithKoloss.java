package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKNekrolithKoloss extends Eintrag {
	
	OptionsUpgradeGruppe o1;

	public GKNekrolithKoloss() {
		name = BuildaHQ.translate("Nekrolith-Koloss");
		grundkosten = 170;
                
                add(ico = new oc.Picture(this));
                
                seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("zus. Handwaffe"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bogen der Wüste"), 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
		complete();
	}
	
	@Override
	public void refreshen() {
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
}
