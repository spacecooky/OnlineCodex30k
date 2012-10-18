package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABHellhound extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe oAce;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public ABHellhound() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Hellhound", 130));
		ogE.addElement(new OptionsGruppeEintrag("Devil Dog", 120));
		ogE.addElement(new OptionsGruppeEintrag("Bane Wolf", 130));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        setHeadline(o1, "Tank type & weapons");

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Searchlight", 1));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));

		cnt = randAbstand;

		ogE.addElement(new OptionsGruppeEintrag("Skilled driver", 5));
		ogE.addElement(new OptionsGruppeEintrag("Night Fighters", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ace Gunner", 10));
        ogE.addElement(new OptionsGruppeEintrag("Disciplined Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Gung-ho! Crew", 5));
		ogE.addElement(new OptionsGruppeEintrag("Battle Hardened Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Veteran Commander", 10));
		add(oAce = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE));
        setHeadline(oAce, "Ace Crew Skills");

		sizeSetzen();
	}

  @Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());

        // Special rule: If HQ "Grace of the Throne" is selected, multiple Ace Skills are allowed
        boolean graceOfTheThrone = BuildaHQ.getCountFromInformationVector("ABGraceoftheThrone") > 0;
        oAce.setMaxAnzahl(graceOfTheThrone ? 7 : 1);

        // Deselect Ace Skills if more than 1 is selected and "Grace of Throne" gets deselected
        if(!graceOfTheThrone) {
            if(oAce.getAnzahl() > 1) {
                oAce.deselectAll();
            }
        }
	}

}
