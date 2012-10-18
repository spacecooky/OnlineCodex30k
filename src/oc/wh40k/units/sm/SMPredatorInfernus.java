package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMPredatorInfernus extends Eintrag {

	OptionsUpgradeGruppe o1;
	//OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SMPredatorInfernus() {
		name = "Predator Infernus";
		grundkosten = 90;

		add(ico = new oc.Picture("oc/wh40k/images/SMPredatorInfernus.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("Flamestorm cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Magna-melta cannon", 30));
		add(o1 =new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", 50));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(8);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10));
		//add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		
		// Unique entry: Antaro Chronus
		/*boolean chronusGlobal = ( BuildaHQ.getCountFromInformationVector("SMChronus") > 0 ? true : false );
		if(chronusGlobal && !chronusSelected) chronus.setAktiv(false);
		else chronus.setAktiv(true);

		if(chronus.isSelected()) {
			chronusSelected = true;
			BuildaHQ.addToInformationVector("SMChronus", 1);
		} else {
			if(chronusSelected) {
				chronusSelected = false;
				BuildaHQ.setInformationVectorValue("SMChronus", 0);
			}
		}*/
	}
/*
	@Override
	public void deleteYourself() {
		if(chronusSelected) {
			BuildaHQ.setInformationVectorValue("SMChronus", 0);
		}
		super.deleteYourself();
	}*/
	
}
