package oc.wh40k.units.ne;

import javax.swing.ImageIcon;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class NETransporterKammer extends RuestkammerVater {

	OptionsUpgradeGruppe typ;
	OptionsUpgradeGruppe commandWeapons;
	OptionsPanelSwitcher switcher;

	boolean offerGhost = false;
	boolean offerNight = false;

	public NETransporterKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

        this.offerGhost = defaults[0];
        this.offerNight = defaults[1];

		add(ico = new oc.Picture("oc/wh40k/images/NEGeisterbarke.jpg"));
		

		if (this.offerGhost) {
			ogE.addElement(new OptionsGruppeEintrag("Geister-Barke", 115));
		}
		if (this.offerNight) {
			ogE.addElement(new OptionsGruppeEintrag("Nachtsichel", 100));
		}
		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!typ.isSelected()) {
			typ.setSelected(0, true);
		}

		if (typ.isSelected("Geister-Barke")) {
			String icon = "oc/wh40k/images/NEGeisterbarke.jpg";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		} else { // Nachtsichel
			String icon = "oc/wh40k/images/NENachtsichel.jpg";
			ico.setIcon(icon);
			try {
				ico.updateSize();
			} catch (Exception e) {
			}
		}
	}
	
}
