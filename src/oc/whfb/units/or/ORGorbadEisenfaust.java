package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORGorbadEisenfaust extends Eintrag {

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	OptionsEinzelUpgrade oAST;
	boolean astSelected = false;
	
	public ORGorbadEisenfaust() {
		name = BuildaHQ.translate("Gorbad Eisenfaust");
		grundkosten = 375;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oAST = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Armeestandartenträger"), 0, false));
		
		complete();
	}

	@Override
	public void refreshen() {
		oAST.setSelected(true);
		oGen.setSelected(true);
		
		BuildaHQ.setInformationVectorValue("ORast", 1);
		BuildaHQ.setInformationVectorValue("GORBAD", 1);
		BuildaHQ.setInformationVectorValue("Gen", 1);
		
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
	
	@Override
	public void deleteYourself() {
		BuildaHQ.setInformationVectorValue("ORast", 0);
		BuildaHQ.setInformationVectorValue("GORBAD", 0);
		BuildaHQ.setInformationVectorValue("Gen", 0);
		super.deleteYourself();
	}
}
