package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABValkyrie extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe oAce;

	public ABValkyrie() {
		grundkosten = 100;
	}

  @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        setHeadline(o1, "Weapons & options");

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike Missiles", "2 Hellstrike Missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Multiple Rocked pods", "2 Multiple Rocked pods", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "2 Heavy bolters", "Pair of heavy bolters", 10));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Skilled driver", 5));
		ogE.addElement(new OptionsGruppeEintrag("Night Fighters", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ace Gunner", 10));
        ogE.addElement(new OptionsGruppeEintrag("Disciplined Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Gung-ho! Crew", 5));
		ogE.addElement(new OptionsGruppeEintrag("Battle Hardened Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Veteran Commander", 10));
		add(oAce = new OptionsUpgradeGruppe(ID, randAbstand , cnt, "", ogE));
        setHeadline(oAce, "Ace Crew Skills");

		sizeSetzen();
	}

  @Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

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
