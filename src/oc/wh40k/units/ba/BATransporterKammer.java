package oc.wh40k.units.ba;

import javax.swing.ImageIcon;

import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class BATransporterKammer extends RuestkammerVater {

	OptionsUpgradeGruppe typ;
	OptionsUpgradeGruppe razorWeapons;
	OptionsPanelSwitcher switcher;

	boolean offerRhinoRazor = false;
	boolean offerDropPod = false;
	boolean offerRaider = false;
	boolean lowerCosts = false;

	public BATransporterKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		this.offerRhinoRazor = defaults[0];
        this.offerDropPod = defaults[1];
        this.offerRaider = defaults[2];
        this.lowerCosts = defaults[3];

		add(ico = new oc.Picture("oc/wh40k/images/BARhinoGross.jpg"));
		

		if (this.offerRhinoRazor) {
			ogE.addElement(new OptionsGruppeEintrag("Rhino", lowerCosts ? 15 : 50));
			ogE.addElement(new OptionsGruppeEintrag("Razorback", lowerCosts ? 20 : 55));
		}
		if (this.offerDropPod) {
			ogE.addElement(new OptionsGruppeEintrag("Landungskapsel", lowerCosts ? 0 : 35));
		}
		if (this.offerRaider) {
			ogE.addElement(new OptionsGruppeEintrag("Land Raider", lowerCosts ? 215 : 250));
			ogE.addElement(new OptionsGruppeEintrag("Land Raider Crusader", lowerCosts ? 215 : 250));
			ogE.addElement(new OptionsGruppeEintrag("Land Raider Redeemer", lowerCosts ? 205 : 240));
		}
		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		OptionsVater[] rhino = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozer-Schaufel", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1)
		};

		OptionsVater[] pod = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deathwind-System", 20),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10)
		};

		OptionsVater[] raider = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1)
		};

		add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, rhino, pod, raider));
		
		// If Razorback should be available, offer weapons for selection
		if(offerRhinoRazor) {
			seperator();

			ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 0));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 35));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
			ogE.addElement(new OptionsGruppeEintrag("LasKa & sync. Plasma", "Laserkanone & synchronisierter Plasmawerfer", 35));
			add(razorWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!typ.isSelected()) {
			typ.setSelected(0, true);
		}

		if (typ.isSelected("Rhino") || typ.isSelected("Razorback")) {
			switcher.forceSwitchPanel(0);
		} else if (typ.isSelected("Landungskapsel")) {
			switcher.forceSwitchPanel(1);
		} else { // all Land Raider types
			switcher.forceSwitchPanel(2);
		}

		if(offerRhinoRazor) {
			razorWeapons.setAktiv(typ.isSelected("Razorback"));
			if(razorWeapons.isAktiv() && !razorWeapons.isSelected()) {
				razorWeapons.setSelected(0, true);
			}

			razorWeapons.getPanel().setLocation(
				(int) switcher.getPanel().getLocation().getX(),
				(int) switcher.getPanel().getLocation().getY() + switcher.getPanel().getSize().height + 8
			);
		}

		if (typ.isSelected("Rhino")) {
			String icon = "oc/wh40k/images/BARhino.jpg";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		} else if (typ.isSelected("Razorback")) {
			String icon = "oc/wh40k/images/BARazorback.jpg";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		} else if (typ.isSelected("Landungskapsel")) {
			String icon = "oc/wh40k/images/BALandungskapsel.jpg";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		} else { // all Land Raiders
			String icon = "oc/wh40k/images/BALandRaiderCrusader.jpg";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		}
	}
	
}
