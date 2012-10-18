package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class OG2004Tyrann extends Eintrag {

	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkName;
	RuestkammerStarter rkMagic;
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	

	public OG2004Tyrann() {
		name = BuildaHQ.translate("Tyrann");
		grundkosten = 200;

		BuildaHQ.addToInformationVector("OGTyrann", 1);

		add(ico = new oc.Picture("oc/images/OGTyrann.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004Equipment", "");
		rkEquipment.initKammer(true, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkName = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004GreatName", "");
		rkName.initKammer(true, false, false);
		rkName.setButtonText(BuildaHQ.translate("Großer Name"));
		add(rkName);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004MagicItems", "");
		rkMagic.initKammer(true, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {
		if(rkMagic.getKosten() + rkName.getKosten() > 100) {
			setFehlermeldung(BuildaHQ.translate("Magie + Name") + "  > 100!");
		} else if(BuildaHQ.getCountFromInformationVector("OGTyrann") > 1) {
			setFehlermeldung("0-1 Auswahl");
		} else {
			setFehlermeldung("");
		}
		
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
		BuildaHQ.addToInformationVector("OGTyrann", -1);
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
