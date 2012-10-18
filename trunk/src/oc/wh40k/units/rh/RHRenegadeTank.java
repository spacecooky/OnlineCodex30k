package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

/**
 * TODO Alle Panzer in Englischer Version plus Zusatzpanzer eintragen
 *
 *
 */
public class RHRenegadeTank extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade pask;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;


	public RHRenegadeTank() {
		grundkosten = 0;
		
		name = "Renegade Tank";
		überschriftSetzen=true;
	
		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Battletank", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Exterminator", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Vanquisher", 155));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Eradicator", 160));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Demolisher", 165));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Punisher", 180));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Executioner", 190));
		ogE.addElement(new OptionsGruppeEintrag("LR Annihilator [FW/IAA2]","Leman Russ Annihilator [Imperial Armour Apocalypse II]", 130)); //from IAA 2
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Conqueror [IA1]", 130));
		ogE.addElement(new OptionsGruppeEintrag("Thunderer [IA1]", 140));
		ogE.addElement(new OptionsGruppeEintrag("Destroyer [IA1]", 140));
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Heavy Flamers", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Multi-meltas", 30));
		ogE.addElement(new OptionsGruppeEintrag("2 Plasma cannons", 40));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 20));
		complete();
	}

  @Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0,true);
        if(!o2.isSelected()) o2.setSelected(0,true);
        o2.setAktiv(!o1.isSelected("Thunderer [IA1]") && !o1.isSelected("Destroyer [IA1]"));
        o3.setAktiv(!o1.isSelected("Thunderer [IA1]") && !o1.isSelected("Destroyer [IA1]"));

		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());	
	}
}
