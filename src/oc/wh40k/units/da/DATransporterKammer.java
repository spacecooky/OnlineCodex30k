package oc.wh40k.units.da;

import javax.swing.ImageIcon;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsSeperator;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class DATransporterKammer extends RuestkammerVater {

	OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe razorWeapons;
	OptionsPanelSwitcher switcher;
	boolean[] defaults;

	public DATransporterKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) { // [0] = keine Grundkosten? [1] = Razorback?  [2] = Drop Pod?
		this.defaults = defaults;

		add(ico = new oc.Picture("oc/wh40k/images/DARhinoGross.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("Rhino", defaults[0] ? 0 : 35));
		ogE.addElement(new OptionsGruppeEintrag("Rhino [IA2]", "Rhino [nach Imperial Armour 2 Update]", defaults[0] ? 0 : 35));

		if (defaults[1]) {
			ogE.addElement(new OptionsGruppeEintrag("Razorback", defaults[0] ? 0 : 50));
			ogE.addElement(new OptionsGruppeEintrag("Razorback [IA2]", "Razorback [nach Imperial Armour 2 Update]", defaults[0] ? 0 : 40));
		}

		if (defaults[2]) {
			ogE.addElement(new OptionsGruppeEintrag("Landungskapsel", defaults[0] ? 0 : 50));
			ogE.addElement(new OptionsGruppeEintrag("Landungskapsel [IA2]", "Landungskapsel [nach Imperial Armour 2 Update]", defaults[0] ? 0 : 35));
		}

		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		ogE.addElement(new OptionsGruppeEintrag("Sync. SchweBo", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Multimelter", "Synchronisierter Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("LasCan & sync. Plasma", "Laserkanone und synchronisierter Plasmawerfer", 35));

		seperator();

		OptionsVater[] rhino = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 15),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15)
		};

		OptionsVater[] rhinoIA2 = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10)
		};

		OptionsVater[] razorback = null;
		OptionsVater[] razorbackIA2 = null;

		if (defaults[1]) {
			razorback = new OptionsVater[]{
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5),
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 15),
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15),
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sync. Laserkanone", "Synchronisierte Laserkanone", 30)
			};

			razorbackIA2 = new OptionsVater[]{
                razorWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE),
                new OptionsSeperator(5),
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10),
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10),
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
				new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15),
			};
		}

		OptionsVater[] dropPod = new OptionsVater[]{ /*keine*/};

		OptionsVater[] dropPodIA2 = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deathwind-System", 20),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10)
        };

		if (defaults[1]) {
			add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, rhino, rhinoIA2, razorback, razorbackIA2, dropPod, dropPodIA2));
		} else {
			add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, rhino, rhinoIA2, dropPod, dropPodIA2));
		}

		sizeSetzen();

	}

	@Override
	public void refreshen() {
		if (!typ.isSelected()) {
			typ.setSelected("Rhino", true);
		}

        if (razorWeapons != null && !razorWeapons.isSelected()) {
            razorWeapons.setSelected(0, true);
        }

		switcher.switchPanel(typ.getSelectedIndex());

		if (typ.isSelected("Rhino") || typ.isSelected("Rhino [nach Imperial Armour 2 Update]")) {
			String icon = "oc/wh40k/images/DARhinoGross.gif";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		} else if (typ.isSelected("Razorback") || typ.isSelected("Razorback [nach Imperial Armour 2 Update]")) {
			String icon = "oc/wh40k/images/DARazorbackGross.gif";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		} else if (typ.isSelected("Landungskapsel") || typ.isSelected("Landungskapsel [nach Imperial Armour 2 Update]")) {
			String icon = "oc/wh40k/images/Landungskapsel.gif"; // die ist BLAU!!!
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		}
	}

}

