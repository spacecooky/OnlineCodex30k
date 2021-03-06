package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SMTransporterKammer extends RuestkammerVater {

	OptionsGruppeEintrag oeRazor;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;
	boolean[] defaults;

	public SMTransporterKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) { // [0] = kostenlos? [1] = Razorback?
		this.defaults = defaults;

		add(ico = new oc.Picture("oc/wh40k/images/SMRhinoGross.jpg"));
		
		int mod = 1;

		if (defaults.length > 0) {
			mod = (defaults[0] ? 0 : 1);
		}

		ogE.addElement(new OptionsGruppeEintrag("Rhino", 35 * mod));

		if (defaults[1]) {
			ogE.addElement(oeRazor = new OptionsGruppeEintrag("Razorback", 40 * mod));
		}

		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(5);

		if (defaults[1]) {
			ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Multimelter [IA2]", "Synchronisierter Multimelter [Imperial Armour 2]", 0));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flamer", 25));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 35));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
			ogE.addElement(new OptionsGruppeEintrag("Laserkanone & Plasma", "Laserkanone und synchronisierter Plasmawerfer", 35));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

			seperator();
		}

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		sizeSetzen();

	}
	boolean razorbackBild = false;

	@Override
	public void refreshen() {
		boolean razorback = o1.isSelected("Razorback");

		if (!razorback) {
			o1.setSelected("Rhino", true);
		} else {
			if (!o2.isSelected()) {
				o2.setSelected("Synchronisierter Schwerer Bolter", true);
			}
		}

		if (defaults[1]) {
			o2.setAktiv(razorback);
		}

		if (razorback == true && razorbackBild == false) {
			String icon = "oc/wh40k/images/SMRazorbackGross.jpg";
			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			razorbackBild = true;
		}

		if (razorback == false && razorbackBild == true) {
			String icon = "oc/wh40k/images/SMRhinoGross.jpg";
			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			razorbackBild = false;
		}

		// Unique entry: Antaro Chronus
		boolean chronusGlobal = ( BuildaHQ.getCountFromInformationVector("SMChronus") > 0 ? true : false );
		if(chronusGlobal && !chronusSelected) chronus.setAktiv(false);
		else chronus.setAktiv(true);

		if(chronus.isSelected()) {
			chronusSelected = true;
			BuildaHQ.addToInformationVector("SMChronus", 1);
		} else {
			if(chronusSelected) {
				chronusSelected = false;
				BuildaHQ.setInformationVectorValue("SMChronus", 0);
			}
		}
	}

	@Override
	public void specialAction(boolean... b) {
		if(oeRazor != null) {
			o1.setAktiv("Razorback", b[0]);
			o2.setAktiv(b[0] && o1.isSelected("Razorback"));
		}
	}

	@Override
	public void deleteYourself() {
		if(chronusSelected) {
			BuildaHQ.setInformationVectorValue("SMChronus", 0);
		}
		super.deleteYourself();
	}
	
}
