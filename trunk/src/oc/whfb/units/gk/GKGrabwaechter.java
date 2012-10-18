package oc.whfb.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class GKGrabwaechter extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkBanner;
	
	public GKGrabwaechter() {
		name = BuildaHQ.translate("Grabw�chter");
		grundkosten = 0;
                
                add(ico = new oc.Picture(this));
                
                seperator();


		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Grabw�chter"), 10, 100, 11);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Hellebarden"), 2));
		
		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartentr�ger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));
		
		seperator();
		
		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "GKBanner", "");
		rkBanner.initKammer(false, true, false, false, true);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		rkBanner.setAktiv(oeS.isSelected());
		
		oe1.setPreis( squad.getModelle() * 2 );
		
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
}
