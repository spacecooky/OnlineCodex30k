package oc.wh40k.units.cd;

import javax.swing.ImageIcon;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsSeperator;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;

public class CDDaemonenprinzdesChaos extends Eintrag {

	AnzahlPanel CDDaemonenprinzdesChaos;
	OptionsUpgradeGruppe mark;
	OptionsPanelSwitcher switcher;

	boolean nurgleBild;

	public CDDaemonenprinzdesChaos() {
		name = "Dämonenprinz";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/wh40k/images/CDDaemonenprinzdesChaos.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dämonischer Flug", 60));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Eisenhaut", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Unheilige Stärke", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 10));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 30));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 25));
		add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Dämonenblick", 20));
		ogE.addElement(new OptionsGruppeEintrag("Odem des Chaos", 30));
		ogE.addElement(new OptionsGruppeEintrag("Wohltat der Mutation", 30));

		OptionsVater[] nixAusgewählt = new OptionsVater[]{
			new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE)
		};

		OptionsVater[] khorne = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Segen des Blutgottes", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blutgeißel", 20)
		};

		OptionsVater[] slaanesh = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aura des Traumwebers", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Einlullender Duft", 20),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lähmender Blick", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Pavane des Slaanesh", 30),
			new OptionsSeperator(5),
			new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE)
		};

		OptionsVater[] nurgle = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegenwolke", 5), 
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ätzende Berührung", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aura des Verfalls", 20),
			new OptionsSeperator(5),
			new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE)
		};

		OptionsVater[] tzeentch = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterzauberer", 10), 
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seelenverschlinger", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blitz des Tzeentch", 35),
			new OptionsSeperator(5),
			new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2)
		};

		ogE.clear();

		add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, nixAusgewählt, khorne, slaanesh, nurgle, tzeentch));

		complete();
	}

	@Override
	public void refreshen() {
		switcher.switchPanel(mark.getSelectedIndex() + 1);
		boolean nurgle = mark.isSelected("Mal des Nurgle");

		if (nurgle && !nurgleBild) {
			String icon = "oc/wh40k/images/CDDaemonenprinzdesChaosNurgle.gif";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
			nurgleBild = true;
		}

		if (!nurgle && nurgleBild) {
			String icon = "oc/wh40k/images/CDDaemonenprinzdesChaos.gif";
			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			nurgleBild = false;
		}
	}

}
