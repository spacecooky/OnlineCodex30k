package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.whfb.armies.VOLKOgerAB2004;

public class OG2004SpeckusGoldzahn extends Eintrag {
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public OG2004SpeckusGoldzahn() {
		name = BuildaHQ.translate("Speckus Goldzahn");
		grundkosten = 565;

		add(ico = new oc.Picture("oc/whfb/images/OGSpeckusGoldzahn.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
		oGen.setSelected(true);

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
		
		if ( VOLKOgerAB2004.EISENWAENSTE < 2 ) {
			setFehlermeldung("Min 2 " + BuildaHQ.translate("Eisenwänste"));
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}	
}
