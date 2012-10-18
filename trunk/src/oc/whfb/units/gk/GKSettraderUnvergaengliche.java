package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class GKSettraderUnvergaengliche extends Eintrag {
	
	boolean genSelected = false;
	boolean hierophantSelected = false;
	OptionsEinzelUpgrade oGen;
	OptionsEinzelUpgrade oHierophant;
	RuestkammerStarter rkLore;

	public GKSettraderUnvergaengliche(){
		name = BuildaHQ.translate("Settra der Unvergängliche");
		grundkosten = 475;
                
                add(ico = new oc.Picture(this));
                
                seperator();

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		add(oHierophant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Hierophant"), 0, false));
		
		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, "GKMagicLores", "");
		rkLore.initKammer(true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);
		
		complete();
	}
	
	@Override
	public void refreshen() {	
		rkLore.setAbwaehlbar(false);
		rkLore.getKammer().specialAction(true);
		
		oGen.setSelected(true);//Settra MUSS General der Armee sein
		
		// Unique entry: GENERAL
		boolean genGlobal = ( BuildaHQ.getCountFromInformationVector("Gen") > 0 ? true : false );
		if(genGlobal && !genSelected) oGen.setAktiv(false);
		else oGen.setAktiv(true);

		if(oGen.isSelected()) {
			genSelected = true;
			BuildaHQ.setInformationVectorValue("Gen", 1);
		} else {
			if(genSelected) {
				genSelected = false;
				BuildaHQ.setInformationVectorValue("Gen", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		// Unique entry: Hierophant
		boolean hierophantGlobal = ( BuildaHQ.getCountFromInformationVector("Hierophant") > 0 ? true : false );
		if(hierophantGlobal && !hierophantSelected) oHierophant.setAktiv(false);
		else oHierophant.setAktiv(true);

		if(oHierophant.isSelected()) {
			hierophantSelected = true;
			BuildaHQ.setInformationVectorValue("Hierophant", 1);
		} else {
			if(hierophantSelected) {
				hierophantSelected = false;
				BuildaHQ.setInformationVectorValue("Hierophant", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
	
	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		if(hierophantSelected) {
			BuildaHQ.setInformationVectorValue("Hierophant", 0);
		}
		super.deleteYourself();
	}
}
