package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMLandRaiderProteus extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

	public SMLandRaiderProteus() {
		name = "Land Raider Proteus";
		grundkosten = 225;
		
		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderHelios.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolter", "Twin-linked heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy flamer", "Twin-linked heavy flamer", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured Ceramite", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
//		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		complete();
	}

	@Override
	public void refreshen() {

//		// Unique entry: Antaro Chronus
//		boolean chronusGlobal = ( BuildaHQ.getCountFromInformationVector("SMChronus") > 0 ? true : false );
//		if(chronusGlobal && !chronusSelected) chronus.setAktiv(false);
//		else chronus.setAktiv(true);
//
//		if(chronus.isSelected()) {
//			chronusSelected = true;
//			BuildaHQ.addToInformationVector("SMChronus", 1);
//		} else {
//			if(chronusSelected) {
//				chronusSelected = false;
//				BuildaHQ.setInformationVectorValue("SMChronus", 0);
//				BuildaHQ.refreshEntries(1);
//				BuildaHQ.refreshEntries(2);
//				BuildaHQ.refreshEntries(3);
//				BuildaHQ.refreshEntries(4);
//				BuildaHQ.refreshEntries(5);
//			}
//		}
	}

	@Override
	public void deleteYourself() {
//		if(chronusSelected) {
//			BuildaHQ.setInformationVectorValue("SMChronus", 0);
//		}
//		super.deleteYourself();
	}

}
