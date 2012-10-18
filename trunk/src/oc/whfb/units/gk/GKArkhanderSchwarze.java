package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class GKArkhanderSchwarze extends Eintrag {

	OptionsEinzelUpgrade oeC;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	boolean hierophantSelected = false;
	OptionsEinzelUpgrade oHierophant;
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public GKArkhanderSchwarze() {
		name = BuildaHQ.translate("Arkhan der Schwarze");
		grundkosten = 360;
                
                add(ico = new oc.Picture(this));
                
                seperator();

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));

		add(oHierophant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Hierophant"), 0, false));
		
		seperator();
		
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Streitwagen"), 55));
		add(oe1= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("zus. Skelettpferde"), 15));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fliegen"), 30));

		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, "GKMagicLores", "");
		rkLore.initKammer(false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}
	
	public void refreshen() {
		rkLore.setAbwaehlbar(false);
		
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
		
//		if (ico != null ) panel.remove(ico)
//                  if ( BuildaMenu.bilderAneigen.isSelected() ) {
//    			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//    			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//    			panel.add(ico);
//                  }
	}
	
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
