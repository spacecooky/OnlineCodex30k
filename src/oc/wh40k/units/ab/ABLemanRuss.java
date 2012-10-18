package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABLemanRuss extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsUpgradeGruppe oAce;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public ABLemanRuss() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Battle Tank", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Exterminator", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Conqueror", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Annihilator", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Vanquisher", 155));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Eradicator", 160));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Demolisher", 165));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Punisher", 180));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Executioner", 190));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        setHeadline(o1, "Tank type & weapons");

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", "Pair of heavy bolters", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 heavy flamers", "Pair of heavy flamers", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 multi-meltas", "Pair of multi-meltas", 30));
		ogE.addElement(new OptionsGruppeEintrag("2 plasma cannons","Pair of plasma cannons", 40));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Co-axial storm bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Co-axial heavy stubber", 10));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		cnt = randAbstand;

		ogE.addElement(new OptionsGruppeEintrag("Skilled driver", 5));
		ogE.addElement(new OptionsGruppeEintrag("Night Fighters", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ace Gunner", 10));
        ogE.addElement(new OptionsGruppeEintrag("Disciplined Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Gung-ho! Crew", 5));
		ogE.addElement(new OptionsGruppeEintrag("Battle Hardened Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Veteran Commander", 10));
		ogE.addElement(new OptionsGruppeEintrag("Slick Loader", 20));
		add(oAce = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE));
        setHeadline(oAce, "Ace Crew & options");

        seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Storm bolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "Extra armour", 15));
        
		sizeSetzen();
	}

  @Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        o4.setAktiv(o1.isSelected("Leman Russ Vanquisher"));

		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());

        boolean cannon = o1.isSelected("Leman Russ Battle Tank") || o1.isSelected("Leman Russ Demolisher");
        oAce.setAktiv("Slick Loader", cannon);

        // Special rule: If HQ "Grace of the Throne" is selected, multiple Ace Skills are allowed
        boolean graceOfTheThrone = BuildaHQ.getCountFromInformationVector("ABGraceoftheThrone") > 0;
        if(cannon) {
            oAce.setMaxAnzahl(graceOfTheThrone ? 8 : 1);
        } else {
            oAce.setMaxAnzahl(graceOfTheThrone ? 7 : 1);
        }
        
        // Deselect Ace Skills if more than 1 is selected and "Grace of Throne" gets deselected
        if(!graceOfTheThrone) {
            if(oAce.getAnzahl() > 1) {
                oAce.deselectAll();
            }
        }
	}

}
