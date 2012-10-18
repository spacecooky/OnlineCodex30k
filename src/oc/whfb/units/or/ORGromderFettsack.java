package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORGromderFettsack extends Eintrag {

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	OptionsEinzelUpgrade oAST;
	boolean astSelected = false;
	
	public ORGromderFettsack() {
		name = BuildaHQ.translate("Grom der Fettsack");
		grundkosten = 285;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		add(oAST = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Armeestandartenträger"), 0, false));
		

		complete();
	}

	@Override
	public void refreshen() {
		oAST.setSelected(true);
		
		BuildaHQ.setInformationVectorValue("ORast", 1);
		
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
		
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
	
	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		BuildaHQ.setInformationVectorValue("ORast", 0);
		super.deleteYourself();
	}
}
