package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class SKSkavensklaven extends Eintrag {

	AnzahlPanel squad;

	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeC;
	
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	
	OptionsUpgradeGruppe o1;

	public SKSkavensklaven() {
		name = BuildaHQ.translate("Skavensklaven");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Skavensklaven"), 20, 100, 2);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oe1= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 0.5));
		add(oe2= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schleudern"), 0.5));
		add(oe3= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Speere"), 0.5));
		
		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 2));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 4));
		
		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 0.5);
		oe2.setPreis(squad.getModelle() * 0.5);
		oe3.setPreis(squad.getModelle() * 0.5);
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
