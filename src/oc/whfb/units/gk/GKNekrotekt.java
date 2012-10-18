package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class GKNekrotekt extends Eintrag {
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	RuestkammerStarter rkMagic;
	
	public GKNekrotekt(){
		name = BuildaHQ.translate("Nekrotekt");
		grundkosten = 60;
                
                add(ico = new oc.Picture(this));
                
                seperator();

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "GKMagicItems", "");
		rkMagic.initKammer(false, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		complete();
	}
	
	@Override
	public void refreshen() {
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
		super.deleteYourself();
	}
}
