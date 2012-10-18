package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ABArmouredFistCompanyCommander extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter rkAceCrew;

    boolean mutex = false;

	public ABArmouredFistCompanyCommander() {
		name = "Armoured Fist Company Commander";
		grundkosten = 55;

		add(ico = new oc.Picture("oc/wh40k/images/ABArmouredFistCompanyCommander.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));

		seperator();

		rkAceCrew = new RuestkammerStarter(ID, randAbstand, cnt, "ABAceCrewKammer", "Ace Crew Skills");
		rkAceCrew.initKammer(false);
        rkAceCrew.setButtonText("Ace Crew Skills");
		add(rkAceCrew);

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();

        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        // Special rule: If HQ "Grace of the Throne" is selected, multiple Ace Skills are allowed
        boolean graceOfTheThrone = BuildaHQ.getCountFromInformationVector("ABGraceoftheThrone") > 0;
        rkAceCrew.getKammer().switchEntry("MULTIPLE", graceOfTheThrone);

        // Deselect Ace Skills if more than 1 is selected and "Grace of Throne" gets deselected
        if(!this.mutex) {
            if(rkAceCrew.isSelected() && rkAceCrew.getKammer().getSpecialValue() != Boolean.TRUE) {
                rkAceCrew.deselectYourself();
                this.mutex = true;
            } else {
                this.mutex = false;
            }
        } else {
            this.mutex = false;
        }
	}

}
