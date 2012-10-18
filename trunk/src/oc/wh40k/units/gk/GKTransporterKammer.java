/* Regeln für Deimos-Lux Pattern Psycannon unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/g/greyknightsupd.pdf
 */

package oc.wh40k.units.gk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class GKTransporterKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe razorWeapons;
    OptionsUpgradeGruppe chimeraWeapons1;
    OptionsUpgradeGruppe chimeraWeapons2;
    OptionsEinzelUpgrade promethium;
    OptionsPanelSwitcher switcher;

    boolean offerRhinoRazor = false;
    boolean offerChimera = false;

    public GKTransporterKammer() {
            grundkosten = 0;
    }

	@Override
	public void initButtons(boolean... defaults) {

		this.offerRhinoRazor = defaults[0];
        this.offerChimera = defaults[1];

		if (this.offerRhinoRazor) {
			ogE.addElement(new OptionsGruppeEintrag("Rhino", 40));
			ogE.addElement(new OptionsGruppeEintrag("Razorback", 45));
		}
		if (this.offerChimera) {
			ogE.addElement(new OptionsGruppeEintrag("Inquisitions-Chimäre", 55));
		}
		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		// If Razorback should be available, offer weapons for selection
		if(offerRhinoRazor) {
			seperator();

            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 25));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 35));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
            ogE.addElement(new OptionsGruppeEintrag("Laserkanone & Plasma", "Laserkanone und synchronisierter Plasmawerfer", 35));
            ogE.addElement(new OptionsGruppeEintrag("[FW] Psycannon", "[Forgeworld] Deimos-Lux Pattern Psycannon", 40));
			add(razorWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}

		// If Razorback should be available, offer weapons for selection
		if(offerChimera) {
			seperator();

            ogE.addElement(new OptionsGruppeEintrag("Multilaser", 0));
            ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
			add(chimeraWeapons1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

			ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
			add(chimeraWeapons2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}

        seperator();

		OptionsVater[] rhino = new OptionsVater[]{
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktive Munition", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpstabilisierungsfeld", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahrsilberpanzerung", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15)
		};

		OptionsVater[] razor = new OptionsVater[]{
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktive Munition", 5),
            promethium = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktives Promethium", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpstabilisierungsfeld", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahrsilberpanzerung", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15)
		};

		OptionsVater[] chimera = new OptionsVater[]{
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpstabilisierungsfeld", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahrsilberpanzerung", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15)
		};

		add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, rhino, razor, chimera));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!typ.isSelected()) {
			typ.setSelected(0, true);
		}

		if (typ.isSelected("Rhino")) {
			switcher.forceSwitchPanel(0);
        } else if (typ.isSelected("Razorback")) {
			switcher.forceSwitchPanel(1);
		} else if (typ.isSelected("Inquisitions-Chimäre")) {
			switcher.forceSwitchPanel(2);
		}

		if(offerRhinoRazor) {
			razorWeapons.setAktiv(typ.isSelected("Razorback"));
			if(razorWeapons.isAktiv() && !razorWeapons.isSelected()) {
				razorWeapons.setSelected(0, true);
			}

            promethium.setAktiv(typ.isSelected("Razorback") && razorWeapons.isSelected("Synchronisierter Schwerer Flammenwerfer"));
		}

		if(offerChimera) {
			chimeraWeapons1.setAktiv(typ.isSelected("Inquisitions-Chimäre"));
			if(chimeraWeapons1.isAktiv() && !chimeraWeapons1.isSelected()) {
				chimeraWeapons1.setSelected(0, true);
			}

			chimeraWeapons2.setAktiv(typ.isSelected("Inquisitions-Chimäre"));
			if(chimeraWeapons2.isAktiv() && !chimeraWeapons2.isSelected()) {
				chimeraWeapons2.setSelected(0, true);
			}
		}
	}

}
