package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMSpartanAssaultTank extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

	public SMSpartanAssaultTank() {
		name = "Spartan Assault Tank";
		grundkosten = 290;

		add(ico = new oc.Picture("oc/wh40k/images/SMSpartanAssaultTank.jpg"));

		/*
		• A Spartan may exchange its hull-mounted twin-linked heavy bolter for:
			--Twin-linked heavy flamer................................................................... Free
			• A Spartan may exchange its lascannon sponsons for:
			--Laser Destroyers................................................................................ Free
			--A Spartan may take frag assault launchers +10 points
			• A Spartan may take any of the following:
			--Hunter-killer missile.................................................................+10 points
			--Armoured ceramite.................................................................+20 points
			• A Spartan may take one of the following pintle-mounted weapons:
			--Storm bolter..............................................................................+5 points
			--Heavy flamer...........................................................................+15 points
			--Heavy bolter............................................................................+15 points
			--Multi-melta.............................................................................+20 points
		*/
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy Bolter", "twin-linked heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy Flamer", "Twin-linked heavy flamer", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lascannons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laser Destroyers", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured ceramite", 20));
//		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

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
