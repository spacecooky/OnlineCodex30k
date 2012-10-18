package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class BTBretonischerHerzog extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	OptionsUpgradeGruppe o1;
	OptionsGruppeEintrag oer;
	OptionsGruppeEintrag oeq;
	OptionsGruppeEintrag oeg;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public BTBretonischerHerzog() {
		name = BuildaHQ.translate("Bretonischer Herzog");
		grundkosten = 110;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
				
		ogE.addElement(oer = new OptionsGruppeEintrag(BuildaHQ.translate("Ritter Gelübde"), 0));
		ogE.addElement(oeq = new OptionsGruppeEintrag(BuildaHQ.translate("Quest Gelübde"), 12));
		ogE.addElement(oeg = new OptionsGruppeEintrag(BuildaHQ.translate("Grals Gelübde"), 28));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "BTEquipment", "");
		rkEquipment.initKammer(true, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "BTMount", "");
		rkMount.initKammer(true, false, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "BTMagicItems", "");
		rkMagic.initKammer(false, true, true, true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		BuildaHQ.setInformationVectorValue("BT_HERZOG", 1);
		
		rkEquipment.getKammer().specialAction(
				o1.isSelected(BuildaHQ.translate("Ritter Gelübde")),
				o1.isSelected(BuildaHQ.translate("Quest Gelübde")),
				o1.isSelected(BuildaHQ.translate("Grals Gelübde"))
			);
		
		rkMagic.getKammer().specialAction(
				o1.isSelected(BuildaHQ.translate("Ritter Gelübde")),
				o1.isSelected(BuildaHQ.translate("Quest Gelübde")),
				o1.isSelected(BuildaHQ.translate("Grals Gelübde")), 
				false
		);
		
		if(BuildaHQ.getCountFromInformationVector("BT_LOUEN") == 0){
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
			
			BuildaHQ.refreshEntries(3);
			BuildaHQ.refreshEntries(4);
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
		BuildaHQ.setInformationVectorValue("BT_HERZOG", 0);
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
