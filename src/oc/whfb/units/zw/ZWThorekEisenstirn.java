package oc.whfb.units.zw;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ZWThorekEisenstirn extends Eintrag {
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public ZWThorekEisenstirn() {
		name = BuildaHQ.translate("Thorek Eisenstirn");
		grundkosten = 505;

		add(ico = new oc.Picture("oc/whfb/images/ZWThorekEisenstirn.jpg"));
		
		seperator(12);
		
		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		if( BuildaHQ.getCountFromInformationVector("ZWGromril") > 0 ){
			JOptionPane op = new JOptionPane(BuildaHQ.translate("Gromril-Meisterrune") + " " + BuildaHQ.translate("darf nur einmal enthalten sein."),JOptionPane.ERROR_MESSAGE);
			JDialog dialog = op.createDialog(BuildaHQ.translate("Fehler"));
			dialog.setAlwaysOnTop(true); //<-- this line
			dialog.setModal(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		
		complete();
	}

	@Override
	public void refreshen() {
		BuildaHQ.setInformationVectorValue("ZWGromril", 1);
		
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
	}
	
	@Override
	public void deleteYourself() {		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		
		BuildaHQ.setInformationVectorValue("ZWGromril", 0);
	}
}
