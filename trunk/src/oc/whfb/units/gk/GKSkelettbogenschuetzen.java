package oc.whfb.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class GKSkelettbogenschuetzen extends Eintrag {

	AnzahlPanel squad;
	
	OptionsEinzelUpgrade oe1;
	
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
		
	public GKSkelettbogenschuetzen() {
		name = BuildaHQ.translate("Skelettbogensch�tzen");
		grundkosten = 0;
                
                add(ico = new oc.Picture(this));
                
                seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Skelettbogensch�tzen"), 10, 100, 6);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte R�stung"), 1));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartentr�ger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
}
